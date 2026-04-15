FROM eclipse-temurin:17-jdk

# Thư mục làm việc trong container
WORKDIR /app

# Copy file JAR đã được build vào image
ARG JAR_FILE=target/openjob-spring-boot-samples.jar
COPY ${JAR_FILE} app.jar


RUN set -x \
    && apt-get update \
    && apt-get install -y iputils-ping netcat-openbsd vim curl tzdata telnet \
    && apt-get clean

# Expose port mặc định (có thể bị ghi đè bởi biến môi trường)
EXPOSE 8888

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
