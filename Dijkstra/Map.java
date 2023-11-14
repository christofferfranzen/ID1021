package Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {
    public City[] cities;
    public ArrayList<String> identifiers;
    public final int mod = 541;
    int r = 0;

    public Map(String file) {
        cities = new City[mod];
        identifiers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                r++;
                String[] row = line.split(",");  // row[0] = from, row[1] = to, row[2] = minutes
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                Integer dist = Integer.valueOf(row[2]);
                one.connect(two, dist);
                two.connect(one, dist);
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

    public City lookup(String name) {
        Integer index = hash(name);
        while (cities[index] != null && !cities[index].getName().equals(name)) {
            index = (index + 1) % mod; // Linear probing
        }
        if (cities[index] == null) {
            identifiers.add(name);
            cities[index] = new City(name, identifiers.indexOf(name));
        }
        return cities[index];
    }

    public int size() {
        return identifiers.size();
    }
}