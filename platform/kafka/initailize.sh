#sh build_worker.sh
#sh jdbc_connector_install.sh
#sh mysql_connector_install.sh
#sh es_connector_install.sh


cd ${CONFLUENT_HOME}

SOURCE_DIR_PATTERN="${CONFLUENT_HOME}/component/"
DEST_DIR="${CONFLUENT_HOME}/component/lib"

mkdir -p ${DEST_DIR}

find ${SOURCE_DIR_PATTERN} -type f -name "*.jar" -exec cp {} ${DEST_DIR} \;

find



