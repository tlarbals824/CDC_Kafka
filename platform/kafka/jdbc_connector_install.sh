cd ${CONFLUENT_HOME}

rm -rf "jdbc_connector"

mkdir "jdbc_connector"
cd jdbc_connector

wget http://client.hub.confluent.io/confluent-hub-client-latest.tar.gz
tar -xvf confluent-hub-client-latest.tar.gz

cd bin

./confluent-hub install confluentinc/kafka-connect-jdbc:latest --component-dir ${CONFLUENT_HOME}/component \
--worker-configs ${CONFLUENT_HOME}/config/worker.properties