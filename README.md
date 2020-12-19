
# 1.概述
spring boot项目整合mybatis, 并对mybatis generator 插件进行扩展，自动生成mybatis配置环境及实体文件

example模块是使用样例参考，extend模块是扩展源码，可直接拷贝到项目中以模块安装方式使用，也可打成jar包引入使用

# 2.功能
- 自动生成实体
- 自动生成Dao、xxxDao.xml，可自定义sql
- 使用mysql dynamicSql 语法语句，具体语法参考： http://mybatis.org/generator/generatedobjects/dynamicSqlV2.html
- 要求jdk1.8及以上

# 3.方式一：模块安装方式
### 3.1 pom.xml配置
```xml
    <dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis.dynamic-sql</groupId>
            <artifactId>mybatis-dynamic-sql</artifactId>
            <version>1.1.4</version>
        </dependency>
    </dependencies>

    <properties>
        <!-- 【org.mybatis.generator插件配置参数】-->
        <!--更多参数配置请参看http://mybatis.org/generator/running/runningWithMaven.html -> Parameter Reference-->
        <mybatis.generator.verbose>true</mybatis.generator.verbose>
        <mybatis.generator.overwrite>true</mybatis.generator.overwrite>
        <plugin.base.dir>${basedir}</plugin.base.dir>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.4.0</version>
                <dependencies>
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>5.1.46</version>
                    </dependency>
                    <dependency>
                        <groupId>cn.aesop</groupId>
                        <artifactId>extend</artifactId>
                        <version>1.0-SNAPSHOT</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
```

### 3.2 添加配置文件 resources/generatorConfig.properties
配置数据库连接、生成文件的位置

### 3.3 添加配置文件 resources/generatorConfig.xml
指定要生成哪些表

### 3.4 安装extend模块到maven库
`mvn clean install -pl extend`

### 3.5 开始生成文件
`cd example`

`mvn mybatis-generator:generate`

或 idea 下直接运行mybatis-generator:generate

以后每次增加表，只需更改generatorConfig.xml指定表名，执行生成，generator目录下的文件会覆盖更新，dao目录下文件不覆盖不更新

## 4. 方式二：打jar包方式
### 4.1 打包extend模块
`mvn clean package -pl extend`

拷贝mybatis-generator-extend-1.4.0.jar文件到目标项目
### 4.2 pom.xml配置

```xml
    <dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis.dynamic-sql</groupId>
            <artifactId>mybatis-dynamic-sql</artifactId>
            <version>1.1.4</version>
        </dependency>
    </dependencies>

    <properties>
        <!-- 【org.mybatis.generator插件配置参数】-->
        <!--更多参数配置请参看http://mybatis.org/generator/running/runningWithMaven.html -> Parameter Reference-->
        <mybatis.generator.verbose>true</mybatis.generator.verbose>
        <mybatis.generator.overwrite>true</mybatis.generator.overwrite>
        <plugin.base.dir>${basedir}</plugin.base.dir>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.4.0</version>
                <dependencies>
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>5.1.46</version>
                    </dependency>
                        <dependency>
                            <groupId>cn.aesop</groupId>
                            <artifactId>custom-plugin</artifactId>
                            <version>1.0</version>
                            <scope>system</scope>
                            <systemPath>${basedir}/../../mybatis-generator-extend-1.4.0.jar</systemPath>
                        </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
```

### 4.3 添加配置文件 resources/generatorConfig.properties
配置数据库连接、生成文件的位置

### 4.4 添加配置文件 resources/generatorConfig.xml
指定要生成哪些表

### 4.5 开始生成文件
`cd 对应模块根目录`

`mvn mybatis-generator:generate`

或 idea 下直接运行mybatis-generator:generate

以后每次增加表，只需更改generatorConfig.xml指定表名，执行生成，generator目录下的文件会覆盖更新，dao目录下文件不覆盖不更新

### 5 注意要在Application启动类添加包扫描
`@MapperScan(basePackages = {"cn.aesop.example.dao", "cn.aesop.example.generator.mapper"})`
# 导航
- Github项目地址：https://github.com/aesopcmc/mybatis-generator-extend

- Csdn博客地址：https://blog.csdn.net/u014438244/article/details/102776762
