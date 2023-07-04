package com.yaml.example.yamlExample;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class YAMLExample {
    public static void main(String[] args) {
        try {
            // Load YAML from a file
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/yml/data-example.yml");
            Map<String, Object> data = yaml.load(fileInputStream);

            // Access data
            System.out.println(data.get("name"));
            System.out.println(data.get("address"));

            // Modify data
            data.put("age", 31);
            data.put("languages", new String[]{"English", "Spanish", "German"});

            // Save modified data back to YAML file
            yaml.dump(data, new FileWriter("src/main/resources/yml/data-example.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
