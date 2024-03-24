brew services start zookeeper
brew services start kafka
brew services status zookeeper
brew services stop zookeeper

#查看所有主题
kafka-topics --list -bootstrap-server localhost:9092
#发送消息
kafka-console-producer --broker-list localhost:9092 --topic test
#消费消息
kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning

