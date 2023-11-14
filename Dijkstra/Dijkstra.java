package Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Dijkstra {
    private Path[] done;
    private PriorityQueue<Path> queue;
    private Map map;

    private class Path implements Comparable<Path> {
        private City city;
        private City prev;
        private Integer dist;

        public Path(City city){
            this.city = city;
            this.prev = null;
            dist = 0;
        }

        private Path(City city, City prev, Integer dist){
            this.city = city;
            this.prev = prev;
            this.dist = dist;
        }

        @Override
        public int compareTo(Path pt) {
            return this.dist.compareTo(pt.dist);
        }
    }

    public Dijkstra(Map map){
        int n = map.size();
        done = new Path[n];
        queue = new PriorityQueue<>();
    }

    public Integer dist(City city){
        if (city != null && done[city.id] != null){
            return done[city.id].dist;
        } else {
            return null;
        }
    }

    public Integer cities(){
        Integer n = 0;
        for (int i = 0; i < done.length; i++){
            if (done[i] != null){
                n++;
            }
        }
        return n;
    }

    public City from(City city){
        if (city != null && done[city.id] != null) {
            return done[city.id].prev;
        } else {
            return null;
        }
    }

    public void search(City from, City dest){
        Path path = new Path(from);
        queue.add(path);
        shortest(dest);

        //System.out.println("Number of entries in the 'done' array: " + cities());
    }

    public void shortest(City dest){
        while (!queue.isEmpty()){
            Path path = queue.remove();

            City city = path.city;
            if (done[city.id] == null){
                done[city.id] = path;

                if (city == dest){
                    break;
                }

                Integer sofar = path.dist;

                for (Connection con : city.neighbours){
                    City to = con.city;
                    if (done[to.id] == null){
                        Path newPath = new Path(to, city, sofar + con.distance);
                        queue.add(newPath);
                    }
                }
            }
        }
    }

    public void printShortestPath(City from, City to) {
        int stops = 0;
        ArrayList<String> path = new ArrayList<>();

        City prv = to; // Start with the destination city
        while (prv != null) {
            path.add(prv.name);
            prv = from(prv); // Update prv to the previous city
            stops++;
        }

        // Reverse the path and print it out in a single line
        Collections.reverse(path);
        //System.out.println("Shortest path: " + String.join(" -> ", path));

        System.out.println("Shortest distance: " + dist(to) + ", Stops: " + stops + ", From: "+ from.name + " to: " + to.name);
    }


    public static final String file = "C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\Dijkstra\\europe.csv";

    public static void main(String[] args) {
        Map map = new Map(file);

        City from = map.lookup("Stockholm");
        String[] cities = {"Köpenhamn", "Berlin", "Leipzig", "Dresden", "Prag", "Bologna", "Pescara", "Rom", "Neapel", "Foggia", "Bari", "Taranto"};
        //City to = map.lookup("Kiruna");

        // Warm up
        {
            Dijkstra djk2 = new Dijkstra(map);
            for (int i = 0; i < 1000000; i++){
                for (int j = 0; j < 10; j++){
                    djk2.search(from, map.lookup("Dresden"));
                }
            }
        }

        for (String city : cities){
            City to = map.lookup(city);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Dijkstra djk = new Dijkstra(map);
                djk.search(from, to);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            Dijkstra djk = new Dijkstra(map);
            djk.search(from, to);
            djk.printShortestPath(from, to);
            System.out.println("Number of entries in the 'done' array: " + djk.cities());
            System.out.println("Time: " + min / 1_000 + " mikro sek");


            /*
            long t0 = System.nanoTime();

            Dijkstra djk = new Dijkstra(map);

            djk.search(from, to);

            long time = (System.nanoTime() - t0) / 1_000;

            djk.printShortestPath(from, to);

            System.out.println("Time: " + time + " mikro sek");
             */
        }
    }
}