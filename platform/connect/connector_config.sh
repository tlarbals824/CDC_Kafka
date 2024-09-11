curl -X POST "http://localhost:8083/connectors" -d '{
  "name": "article-connector",
  "config": {
    "connector.class": "io.confluent.connect.jdbc.JdbcSourceConnector",
    "connection.url": "jdbc:mysql://cdc-mysql:3306/livid",
    "connection.user": "cdc",
    "connection.password": "livid",
    "mode": "timestamp+incrementing",
    "timestamp.column.name": "updated_at",
    "incrementing.column.name": "id",
    "topic.prefix": "livid_",
    "topic.creation.default.replication.factor": "2",
    "topic.creation.default.partitions": "3",
    "table.whitelist": "article",
    "validate.non.null": "false",
    "tasks.max": "3",
    "key.converter": "org.apache.kafka.connect.json.JsonConverter",
    "key.converter.schemas.enable": "false",
    "transforms": "createKey",
    "transforms.createKey.type": "org.apache.kafka.connect.transforms.ValueToKey",
    "transforms.createKey.fields": "id"
  }
}' -H "Content-Type: application/json"