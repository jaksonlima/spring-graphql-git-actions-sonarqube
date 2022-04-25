#### Start the server by running docker:

```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
```

#### Scanner sonar manual

```
./gradlew sonarqube \
  -Dsonar.projectKey=spring-kotlin-graphql \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=2b6d0e2a29ef926033b07e5ff6218b06b1c805d2
```

#### Properties build.gradle

```build.gradle
sonarqube {
  properties {
    property("sonar.projectKey", "spring-kotlin-graphql")
    property("sonar.host.url", "http://localhost:9000")
    property("sonar.login", "2b6d0e2a29ef926033b07e5ff6218b06b1c805d2")
  }
}
```
