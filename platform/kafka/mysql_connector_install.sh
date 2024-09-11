#!/bin/bash

cd ${CONFLUENT_HOME}

DEST_DIR="${CONFLUENT_HOME}/component/confluentinc-kafka-connect-jdbc/lib"
SOURCE_FILE="mysql-connector-java-8.0.27.jar"

wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.27.tar.gz
tar -xvf mysql-connector-java-8.0.27.tar.gz

if [ ! -f "${DEST_DIR}/$(basename ${SOURCE_FILE})" ]; then
    cp mysql-connector-java-8.0.27/${SOURCE_FILE} ${DEST_DIR}
fi


rm -rf mysql-connector-java-8.0.27
rm mysql-connector-java-8.0.27.tar.gz