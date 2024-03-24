# jre基础环境
FROM openjdk:8-jdk-alpine
# 持久化目录
VOLUME /home/demo

# 添加jar到容器
ADD JAR_FILE=target/*.jar spb2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spb2.jar"]
