FROM payara/micro

ADD /target/jse-jar-with-dependencies.jar $PAYARA_PATH/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
