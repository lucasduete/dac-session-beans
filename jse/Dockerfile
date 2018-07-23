FROM openjdk:8-jdk-alpine

COPY /target/jse.jar app.jar

CMD ["java", "-classpath", "app.jar", "io.github.lucasduete.dac.sessionbeans.jse.Main"]
