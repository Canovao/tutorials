# Adapted example from Chat-GPT
# Prompt: "make me a ".yml" tutorial"

import yaml

# Load YAML from a file
with open('python-yml-example.yml', 'r') as file:
    data = yaml.safe_load(file)

# Access data
print(data['name'])
print(data['address']['city'])

print('\n***\n')

# Convert Python data to YAML
new_data = {'name': 'Jane Doe', 'age': 25}
yaml_data = yaml.dump(new_data)
print(yaml_data)
