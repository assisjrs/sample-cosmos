FROM azul/zulu-openjdk-alpine:11.0.9-11.43.21-jre

WORKDIR /home/javauser

EXPOSE 9090

RUN addgroup -S javauser && adduser -S javauser -G javauser

ADD target/samples-cosmos-0.0.1-SNAPSHOT.jar /home/javauser/app.jar

USER javauser

ENTRYPOINT ["java", "-jar", "/home/javauser/app.jar", "-Xms512M", "-Xmx1024M"]
