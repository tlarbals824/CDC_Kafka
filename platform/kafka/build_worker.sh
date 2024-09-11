cd ${CONFLUENT_HOME}

rm -rf "component"
rm -rf "config"

mkdir "component"
mkdir "config"

cd config
touch worker.properties