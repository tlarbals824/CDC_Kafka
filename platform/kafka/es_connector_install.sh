

cd ${CONFLUENT_HOME}/jdbc_connector/bin

./confluent-hub install confluentinc/kafka-connect-elasticsearch:latest --component-dir ${CONFLUENT_HOME}/component \
--worker-configs ${CONFLUENT_HOME}/config/worker.properties