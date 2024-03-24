#springboot项目远程调试启动命令
java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 spb2-hotdev-0.0.1-SNAPSHOT.jar
