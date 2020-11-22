package cn.aesop.extend.comment;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import java.util.Properties;

/**
 * 自定义注解，加载数据库comment注解，去除默认生成的无用的注释
 *
 * 使用方法：
 * 在generatorConfig.xml中的Content内添加该插件，属性addRemarkComments 必须设置为true才能生效，如下：
 * <content ...>
 *     ...
 *     <commentGenerator type="cn.aesop.extend.comment.MySQLCommentGenerator">
 *      <property name="addRemarkComments" value="true"/>
 *     </commentGenerator
 *     ...
 * </content>
 *
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/21 16:50
 */
public class MySQLCommentGenerator extends EmptyCommentGenerator {

    private Properties properties;

    public MySQLCommentGenerator() {
        properties = new Properties();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        // 获取自定义的 properties
        this.properties.putAll(properties);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = "Mybatis Generator";//properties.getProperty("author");
        // String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        // SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks);
        topLevelClass.addJavaDocLine(" * " + tableName);
        topLevelClass.addJavaDocLine(" * ");
        topLevelClass.addJavaDocLine(" * @author " + author);
        // topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 获取列注释
        String remarks = introspectedColumn.getRemarks();
        String columnName = introspectedColumn.getActualColumnName();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + remarks);
        field.addJavaDocLine(" * " + columnName);
        field.addJavaDocLine(" */");
    }
}
