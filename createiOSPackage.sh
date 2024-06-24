
# Check if the correct number of arguments is provided
if [ "$#" -lt 2 ]; then
  echo "Usage: $0 input_file output_file key1=value1 [key2=value2 ...]"
  exit 1
fi

# Input file and output file
input_file=$1
output_file=$2
shift 2

# Copy the input file to the output file
cp "$input_file" "$output_file"

echo "$@"

# Perform find and replace for each key-value pair
for kv in "$@"; do
  echo "Changing " + ${kv%%=*}
  key=${kv%%=*}
  value=${kv#*=}
  
  if [[ -z "$key" || -z "$value" ]]; then
    echo "Invalid key-value pair: $kv"
    continue
  fi
  
  # Use sed to perform the replacement
  sed -i '' "s/$key/$value/g" "$output_file"
done

echo "Replacement completed. Output written to $output_file"