FROM eclipse-temurin:8-jre-alpine

LABEL maintainer="zhuangsuzheng"
LABEL description="Campus Information Platform Backend"

WORKDIR /app

COPY target/renren-fast.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
