
# mybatis-generator-extend
扩展mybatis generator的使用：

# 使用步骤
## 1.打包extend模块：mvn clean package -pl extend
## 2.从target拷贝打包后的文件mybatis-generator-extend.jar 到需要的位置
## 3.在mybatis generator插件中配置指定jar位置
```xml
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

github项目地址https://github.com/aesopcmc/mybatis-generator-extend