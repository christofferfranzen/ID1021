package Paths;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 541;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");  // row[0] = from, row[1] = to, row[2] = minutes
                int minutes = Integer.parseInt(row[2]);

                Integer from = insert(row[0]);
                Integer to = insert(row[1]);

                cities[from].newConnection(cities[to], minutes);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    private Integer insert(String name) {
        Integer index = hash(name);
        while (cities[index] != null && !cities[index].getName().equals(name)) {
            index = (index + 1) % mod; // Linear probing
        }
        if (cities[index] == null) {
            cities[index] = new City(name);
        }
        return index;
    }

    public City lookup(String name) {
        Integer index = hash(name);
        while (cities[index] != null && !cities[index].getName().equals(name)) {
            index = (index + 1) % mod; // Linear probing
        }
        return cities[index];
    }
}