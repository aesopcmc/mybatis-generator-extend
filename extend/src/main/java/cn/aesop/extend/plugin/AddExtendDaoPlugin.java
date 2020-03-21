package cn.aesop.extend.plugin;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.XmlConstants;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 生成扩展Dao文件，用于扩展Mapper的操作。
 * 每个表分别对应生成两个文件 xxxDao.java、xxxDao.xml。 该插件通过生成的xxxDao.java，继承了原来生成的xxxMapper.java文件，已经包含默认的sql操作，
 * 项目中可以直接使用xxxDao.java进行开发，无需对xxxMapper.java文件进行更改，而且原所有由mybatis generator生成的文件（包括model、mapper、example），每次生成都会被重新覆盖，
 * 不应该再修改这些文件，与数据库表建立了固定联系， 后续开发只需要集中于xxxDao.xml 和 xxxDao.xml 文件即可。
 * 总体开发步骤：数据库表添加或变更->运行Mybatis Generator生成->model、mapper、example文件重新覆盖更新，扩展文件已存在的不覆盖—>根据需要对扩展的xxxDao进行开发
 *
 *
 * 使用方法：
 * 在generatorConfig.xml中的Content内添加该插件 ，四个属性值必传，如：
 * <content ...>
 *  <extend type="cn.aesop.extend.plugin.AddExtendDaoPlugin">
 *      <property name="baseDir" value="${basedir}"/> POM所在目录
 *      <property name="targetProject" value="src/main/java"/> 根包位置
 *      <property name="targetProjectXml" value="src/main/resources"/> xml资源位置
 *      <property name="targetPackage" value="cn.issuetracker.group.dao"/> 根包位置
 *  </extend>
 *  ...
 * </content>
 *
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/18 16:28
 */
public class AddExtendDaoPlugin extends PluginAdapter {
    private String fileTitle="《扩展Dao操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》";
    private String targetPackage;
    private String targetProject;
    private String targetProjectXml;
    private String daoBaseName;
    private String baseDir;

    @Override
    public boolean validate(List<String> list) {
        baseDir = properties.getProperty("baseDir");
        targetPackage = properties.getProperty("targetPackage");
        targetProject = properties.getProperty("targetProject");
        targetProjectXml = properties.getProperty("targetProjectXml");
        if(baseDir==null || baseDir.trim().isEmpty()
            ||targetPackage==null || targetPackage.trim().isEmpty()
            ||targetProject==null || targetProject.trim().isEmpty()
            ||targetProjectXml==null || targetProjectXml.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        daoBaseName = introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "Dao";

        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        String targetPackagePath = targetPackage.replaceAll("\\.", "/");
        StringBuilder filePath = new StringBuilder();
        filePath.append(baseDir)
            .append(File.separator)
                .append(targetProject)
                .append(File.separator)
                .append(targetPackagePath)
                .append(File.separator)
                .append(daoBaseName)
                .append(".java");
        if(new File(filePath.toString()).exists()) {
            System.out.println(filePath+"文件存在，不生成");
            return null;
        }

        CompilationUnit unit = generateUnit(introspectedTable);
        // this.context.getProperty("javaFileEncoding")
        GeneratedJavaFile gf = new GeneratedJavaFile(unit, targetProject, "utf-8", this.context.getJavaFormatter());
        return Arrays.asList(gf);
    }

    @Override
    public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable) {
        String targetPackagePath = targetPackage.replaceAll("\\.", "/");
        StringBuilder filePath = new StringBuilder();
        filePath.append(baseDir)
                .append(File.separator)
                .append(targetProjectXml)
                .append(File.separator)
                .append(targetPackagePath)
                .append(File.separator)
                .append(daoBaseName)
                .append(".xml");
        if(new File(filePath.toString()).exists()) {
            System.out.println(filePath+"文件存在，不生成");
            return null;
        }

        String domainType = introspectedTable.getBaseRecordType();
        Document document = new Document(
                XmlConstants.MYBATIS3_MAPPER_CONFIG_PUBLIC_ID,
                XmlConstants.MYBATIS3_MAPPER_SYSTEM_ID);
        XmlElement root = new XmlElement("mapper"); //$NON-NLS-1$
        document.setRootElement(root);
        root.addAttribute(new Attribute("namespace", targetPackage +"."+daoBaseName));
        root.addElement(new TextElement("<!--")); //$NON-NLS-1$
        root.addElement(new TextElement("  "+fileTitle)); //$NON-NLS-1$
        root.addElement(new TextElement(
                "  这是一个继承自父xxxMapper.xml的配置文件，扩展的sql语句操作都放在这个文件")); //$NON-NLS-1$
        root.addElement(new TextElement(
                "  注意：不要使用与父mapper相同的statement（select、insert、update、delete），会被覆盖，而sql、resultMap不会覆盖")); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        sb.append("  generator date："); //$NON-NLS-1$
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        sb.append(dateFormatter.format(new Date()));
        sb.append('.');
        root.addElement(new TextElement(sb.toString()));

        root.addElement(new TextElement("-->")); //$NON-NLS-1$

        /*
        <resultMap id="BaseResultMap" type="cn.issuetracker.group.generator.model.DemoTest">
            <id column="id" jdbcType="BIGINT" property="id" />
            <result column="name" jdbcType="VARCHAR" property="name" />
            <result column="workflow_scheme_id" jdbcType="BIGINT" property="workflowSchemeId" />
            <result column="able_status" jdbcType="TINYINT" property="ableStatus" />
            <result column="create_user" jdbcType="INTEGER" property="createUser" />
            <result column="create_time" jdbcType="TIMESTAMP" property="createTime" />
            <result column="update_user" jdbcType="INTEGER" property="updateUser" />
            <result column="update_time" jdbcType="TIMESTAMP" property="updateTime" />
            <result column="group_id" jdbcType="INTEGER" property="groupId" />
          </resultMap>
        */
        XmlElement resultMap = new XmlElement("resultMap"); //$NON-NLS-1$
        resultMap.addAttribute(new Attribute("id", "BaseResultMap"));
        resultMap.addAttribute(new Attribute("type", domainType));

        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        for (IntrospectedColumn primaryKeyColumn : primaryKeyColumns) {
            this.addResultElement(resultMap,
                    "id",
                    primaryKeyColumn.getActualColumnName(),
                    primaryKeyColumn.getJdbcTypeName(),
                    primaryKeyColumn.getJavaProperty());
        }

        List<IntrospectedColumn> baseColumns = introspectedTable.getBaseColumns();
        for (IntrospectedColumn baseColumn : baseColumns) {
            this.addResultElement(resultMap,
                    "result",
                    baseColumn.getActualColumnName(),
                    baseColumn.getJdbcTypeName(),
                    baseColumn.getJavaProperty());
        }

        List<IntrospectedColumn> blobColumns = introspectedTable.getBLOBColumns();
        for (IntrospectedColumn blobColumn : blobColumns) {
            this.addResultElement(resultMap,
                    "result",
                    blobColumn.getActualColumnName(),
                    blobColumn.getJdbcTypeName(),
                    blobColumn.getJavaProperty());
        }
        root.addElement(resultMap);

        /*
        <sql id="Base_Column_List">
            id, name, workflow_scheme_id, able_status, create_user, create_time, update_user,
            update_time, group_id,remark
          </sql>
        */
        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
        StringBuilder builder = new StringBuilder();
        for (IntrospectedColumn column : allColumns) {
            builder.append(column.getActualColumnName()).append(", ");
        }
        String columnsText = builder.substring(0, builder.length()-2);

        XmlElement baseColumnList = new XmlElement("sql"); //$NON-NLS-1$
        baseColumnList.addAttribute(new Attribute("id", "Base_Column_List"));
        baseColumnList.addElement(new TextElement(columnsText));
        root.addElement(baseColumnList);

        root.addElement(new TextElement("<!-- 自定义 -->\n"));

        GeneratedXmlFile gxf = new GeneratedXmlFile(document,
                daoBaseName+".xml", //$NON-NLS-1$ //$NON-NLS-2$
                targetPackage, //$NON-NLS-1$
                targetProjectXml, //$NON-NLS-1$
                false, context.getXmlFormatter());

        List<GeneratedXmlFile> answer = new ArrayList<>(1);
        answer.add(gxf);

        return answer;
    }

    private void addResultElement(XmlElement resultMap, String ele, String actualColumnName, String jdbcTypeName, String javaProperty) {
        XmlElement result = new XmlElement(ele);
        result.addAttribute(new Attribute("column", actualColumnName));
        result.addAttribute(new Attribute("jdbcType", jdbcTypeName));
        result.addAttribute(new Attribute("property", javaProperty));
        resultMap.addElement(result);
    }

    private CompilationUnit generateUnit(IntrospectedTable introspectedTable) {
        //实体类类型
        // String entityClazzType = introspectedTable.getBaseRecordType();
        // xxxMapper类类型
        String mapperInterfaceType = introspectedTable.getMyBatis3JavaMapperType();

        String domainObjectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        StringBuilder builder = new StringBuilder();

        //继承接口 xxxMapper.java
        FullyQualifiedJavaType superClassType = new FullyQualifiedJavaType(
                builder.append(domainObjectName)
                        .append("Mapper").toString()
        );
        Interface dto = new Interface(targetPackage +"."+daoBaseName);
        dto.addSuperInterface(superClassType);
        dto.setVisibility(JavaVisibility.PUBLIC);

        //导入xxxMapper类所在的包
        FullyQualifiedJavaType modelJavaType = new FullyQualifiedJavaType(mapperInterfaceType);
        dto.addImportedType(modelJavaType);

        //导入注解包、并添加注解
        FullyQualifiedJavaType importType = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");
        dto.addImportedType(importType);
        dto.addAnnotation("@Mapper");

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dto.addJavaDocLine("/**\n" +
                " * " +fileTitle+"\n"+
                " * \n" +
                " * @author Mybatis Generator\n" +
                " * @date " + dateFormatter.format(new Date()) +"\n"+
                " */");

        return dto;
    }

}
