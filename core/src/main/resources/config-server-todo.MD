


- trzeba dodać nowy moduł Maven reprezentujący config server
- stworzyć nową aplikację Spring Boot, która posiada adnotację @EnableConfigServer obok @SpringBootApplication
- do `application.properties` dodać customowy `server.port` (żeby nie gryzło się z drugą apką)
- do `application.properties` dodać `spring.cloud.config.server.git.uri` prowadzące do repo git z konfiguracją
- do `pom.xml` config servera dodać `org.springframework.cloud:spring-cloud-starter-config`
- do `pom.xml` dodać zależności `spring-cloud-dependencies`