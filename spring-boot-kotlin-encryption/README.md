# How to use Jasypt
- github: https://github.com/ulisesbocchio/jasypt-spring-boot
- Dependency for spring boot applications
  - ```xml
    <dependency>
        <groupId>com.github.ulisesbocchio</groupId>
        <artifactId>jasypt-spring-boot-starter</artifactId>
        <version>3.0.4</version>
    </dependency>
    ```
- Default values 
  - ![img.png](images/img.png)
- Custom settings 
  - ```java
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("password");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
    ```
- Use `StringEncryptor` bean to encrypt or decrypt 
- How to run spring application
  - `-Djasypt.encryptor.password="MDAwMDAwMDA6IDc4YmYgYTcxYiAxNzExIGY3NjUgZGYyOCBhMzJiIGY2NGUgODdlMiAgeC4uLi4uLmUuKC4rLk4uLgo"`
- How to encrypt single value using plugin 
  - ```xml 
    <!-- Add dependency --> 
    <build>
      <plugins>
        <plugin>
          <groupId>com.github.ulisesbocchio</groupId>
          <artifactId>jasypt-maven-plugin</artifactId>
          <version>3.0.4</version>
        </plugin>
      </plugins>
    </build>
    ```
  - Run `mvn jasypt:encrypt-value -Djasypt.encryptor.password="the password" -Djasypt.plugin.value="theValueYouWantToEncrypt"`
- Jasypt 3.0.0 이하 버전을 활용하고 싶은 경우 
  - ```yaml
    jasypt:
      encryptor:
      algorithm: PBEWithMD5AndDES
      iv-generator-classname: org.jasypt.iv.NoIvGenerator
    ```
- Jasypt 3.0.0 이상 버전을 활용하고 싶은 경우 
  - Reference `jasypt-version-3-encryption` module 