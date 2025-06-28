# kafkaproducer

A kafka producer sample app.

## Setup

Set enviroment variables (Linux)
```bash
export KAFKA_PASSWORD=$USER1_PASSWORD
export KAFKA_BOOTSTRAP_SERVER=$CONTROLLER_HOSTNAME:$SERVICE_EXTERNAL_PORT
```
set hostname in /etc/hosts
```
LOADBALANCED_KAFKA_SERVICE_EXTERNAL_IP  kafka-controller-0.kafka-controller-headless.kafka.svc.cluster.local kafka-controller-1.kafka-controller-headless.kafka.svc.cluster.local kafka-controller-2.kafka-controller-headless.kafka.svc.cluster.local
```
## Run

java -jar kafkaproducer-0.0.1-SNAPSHOT.jar

## Open Swagger URL

http://localhost:8080/swagger-ui/index.html
