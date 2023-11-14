package Hash;

import Sorted.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;

    public class Node {
        public String zip;
        public String city;
        public Integer count;

        public Node(String zip, String city, Integer count) {
            this.zip = zip;
            this.city = city;
            this.count = count;
        }
    }

    public Zip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public String linear(String zip){
        return Linear.search(data, zip, max);
    }

    public String binary(String zip){
        return Binary.search(data, zip, max);
    }
}
