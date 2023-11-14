package Hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class keyZip {
    Node[] data;
    int max;

    public class Node {
        public Integer zip;
        public String city;
        public Integer count;

        public Node(int zip, String city, Integer count) {
            this.zip = zip;
            this.city = city;
            this.count = count;
        }
    }

    public keyZip(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2])); // Use the key as index
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public String lookup(String zip){
        int index = Integer.parseInt(zip);
        if (index >= 0 && index < data.length && data[index] != null) {
            return "City: " + data[index].city + ", Count: " + data[index].count;
        }
        return null;
    }
}
