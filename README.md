
# 概述
在项目中加入mybatis generator 插件自动mybatis实体映射文件，并对原插件进行扩展（参考extend模块），
生成mybatis-generator-extend.jar，把jar嵌入到mybatis generator 插件中

# 功能
- 自动生成实体
- 自动生成Dao、xxxDao.xml，可自定义sql
- java版本1.7 

# 使用步骤
## 1.打包extend模块：mvn clean package -pl extend
## 2.从target拷贝打包后的文件mybatis-generator-extend.jar 到需要的位置
## 3.在你的项目中添加 mybatis-generator-extend.jar 插件，并指定文件生成的位置，请参考example模块
```xml

<properties>
    <!--
        【mybatis.generator插件相关参数设置】
        更多参数配置请参看http://mybatis.org/generator/running/runningWithMaven.html -> Parameter Reference
    -->
    <mybatis.generator.verbose>true</mybatis.generator.verbose>
    <!--覆盖已存在的文件-->
    <mybatis.generator.overwrite>true</mybatis.generator.overwrite>
    <!--链接数据库信息-->
    <mybatis.generator.jdbcDriver>com.mysql.jdbc.Driver</mybatis.generator.jdbcDriver>
    <mybatis.generator.jdbcURL><![CDATA[jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=utf8]]></mybatis.generator.jdbcURL>
    <mybatis.generator.jdbcUserId>root</mybatis.generator.jdbcUserId>
    <mybatis.generator.jdbcPassword>root</mybatis.generator.jdbcPassword>
    <!-- 生成Model类的位置 -->
    <model.package>cn.aesop.example.generator.model</model.package>
    <!-- 生成Mapper类的位置 -->
    <mapper.package>cn.aesop.example.generator.mapper</mapper.package>
    <!-- 生成Mapper xml文件位置,-->
    <mapper.xml.package>cn.aesop.example.generator.mapper</mapper.xml.package>
    <!-- 插件配置，生成扩展Dao文件的位置 -->
    <plugin.base.dir>${basedir}</plugin.base.dir>
    <plugin.dao.package>cn.aesop.example.dao</plugin.dao.package>
</properties>
    
<build>
    <plugins>
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>${mybatis.generator.version}</version>
            <dependencies>
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>5.1.21</version>
                </dependency>
                <dependency>
                    <groupId>cn.aesop</groupId>
                    <artifactId>mybatis-generator-extend</artifactId>
                    <version>1.0</version>
                    <scope>system</scope>
                    <systemPath>${basedir}/../mybatis-generator-extend.jar</systemPath>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>

```
## 4.在resources添加generatorConfig.xml配置文件，请参考example模块

## 5.打开example模块，运行mybatis-generator插件，生成文件

# 导航
- Github项目地址：https://github.com/aesopcmc/mybatis-generator-extend

- Csdn博客地址：https://blog.csdn.net/u014438244/article/details/102776762
