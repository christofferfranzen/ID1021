package Hash;

import Sorted.Binary;
import Sorted.Linear;

import java.io.BufferedReader;
import java.io.FileReader;

public class intZip {
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

    public intZip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public String linear(int zip){
        return Linear.search(data, zip, max);
    }

    public String binary(int zip){
        return Binary.search(data, zip, max);
    }

    public String lookup(String zip){
        return null;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            //Integer index = keys[i] % mod;
            //cols[data[index]]++;
            //data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }
}
