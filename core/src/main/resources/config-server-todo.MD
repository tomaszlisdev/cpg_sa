


- trzeba dodać nowy moduł Maven reprezentujący config server
- do `pom.xml` config servera dodać 
  `org.springframework.cloud:spring-cloud-config-server`
- do `pom.xml` dodać zależności 
  `spring-cloud-dependencies`
  
  <dependencyManagement>
      <dependencies>
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-dependencies</artifactId>
              <version>Finchley.RELEASE</version>
              <type>pom</type>
              <scope>import</scope>
          </dependency>
      </dependencies>
  </dependencyManagement>


- stworzyć nową aplikację Spring Boot, która posiada adnotację 
  @EnableConfigServer obok @SpringBootApplication
- do `application.properties` dodać customowy `server.port` (żeby nie gryzło się z drugą apką)
- do `application.properties` dodać `spring.cloud.config.server.git.uri` 
  prowadzące do repo git z konfiguracją `https://github.com/pivovarit/cpg_sa.git`

- do aplikacji `core` dodać nowy plik configuracyjny `bootstrap.properties` 
  (obok `application.properties`) i umieścić tam dwa wpisy:

`spring.application.name=rental-store`
`spring.cloud.config.uri=http://localhost:8888` (adres do config-servera)
- i dodać zależności spring cloud :) czyli  powyższe <dependencyManagement> oraz:
         ```<dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-config</artifactId>
         </dependency>```
         

