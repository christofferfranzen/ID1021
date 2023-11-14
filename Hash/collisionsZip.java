package Hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class collisionsZip {
    private static int keySize = 10000;
    private static int mod = 10000;

    ArrayList<Node>[] data;
    int max;
    int[] keys;

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

    public collisionsZip(String file) {
        data = new ArrayList[10000];
        keys = new int[keySize];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                int index = code % mod;
                if (data[index] == null) {
                    data[index] = new ArrayList<>();
                }
                data[index].add(new Node(code, row[1], Integer.valueOf(row[2]))); // Use the key as index
                keys[i++] = code;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public String lookup(String zip){
        int index = Integer.parseInt(zip) % mod;
        if (index >= 0 && index < data.length && data[index] != null) {
            for (Node node : data[index]) {
                if (node.zip.equals(Integer.parseInt(zip))) {
                    return "City: " + node.city + ", Count: " + node.count;
                }
            }
        }
        return null;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }
}
