https://blog.csdn.net/djdjfjf1/article/details/134775443

docker network create es-net

docker pull elasticsearch:7.12.1
docker pull kibana:7.12.1 #由于kibana没有arm架构的，暂时未安装


docker run -d \
  --name es \
    -e "ES_JAVA_OPTS=-Xms512m -Xmx512m" \
    -e "discovery.type=single-node" \
    -v es-data:/usr/local/elasticsearch7.12.1/data \
    -v es-plugins:/usr/local/elasticsearch7.12.1/plugins \
    -v es-logs:/usr/local/elasticsearch7.12.1/logs \
    --privileged \
    --network es-net \
    -p 9200:9200 \
    -p 9300:9300 \
elasticsearch:7.12.1

docker exec -it es bash

cd /usr/share/elasticsearch/bin

./elasticsearch-plugin  install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.12.1/elasticsearch-analysis-ik-7.12.1.zip

exit

docker restart es

