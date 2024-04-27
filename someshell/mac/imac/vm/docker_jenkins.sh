# imac_vm docker jekins default password
21563deec5a64efd9e0826e8358b6426

docker search xxl-job
docker pull xuxueli/xxl-job-admin:2.4.0

-- 导入数据

docker run  -d \
        -p 8088:8088\
        -v /tool/xxl-job/logs:/data/applogs \
        -v /tool/xxl-job/application.properties:/xxl-job/xxl-job-admin/src/main/resources/application.properties \
        -e PARAMS="--server.port=8088\
        --spring.datasource.url=jdbc:mysql://192.168.31.100:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai \
        --spring.datasource.username=root \
        --spring.datasource.password=Wing1Q2W#E" \
        --name xxl-job-admin  \
        --link mysql \
xuxueli/xxl-job-admin:2.4.0

