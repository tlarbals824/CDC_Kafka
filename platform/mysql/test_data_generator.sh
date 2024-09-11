
# Check if a file is provided as an argument
if [ -z "$1" ]; then
  echo "Usage: $0 <csv_file>"
  exit 1
fi

# Check if the file name is test_data_content
if [ "$1" != "test_data_content.csv" ]; then
  echo "Error: The file name must be 'test_data_content'"
  exit 1
fi

# Read the CSV file line by line
while IFS=, read -r content
do
  curl -X POST "http://localhost:8080/articles" -H "Content-Type: application/json" -d "{\"content\": \"$content\"}"
done < "$1"