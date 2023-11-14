package Paths;

import java.util.HashSet;
import java.util.Set;

class Naive {
    public static final String file = "C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\Paths\\trains.csv";

    public static void main(String[] args) {

        //int[] max = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        int[] max = {10000};
        int i = 10000;
        String[] cities = {
                "Lund", "Helsingborg",
                "Kristianstad", "Jönköping", "Göteborg", "Norrköping",
                "Stockholm", "Uppsala", "Västerås", "Umeå", "Luleå"
        };

        //for (int i : max) {
        for (String to : cities){
            Map map = new Map(file);
            //String from = args[0];
            //String to = args[1];
            //Integer max = Integer.valueOf(args[2]);
            String from = "Malmö";
            //String to = "Kiruna";
            long t0 = System.nanoTime();

            //Paths paths = new Paths(); // Create an instance of the Paths class
            //Paths paths = new Paths();
            Paths_improved paths = new Paths_improved();
            //Set<City> visited = new HashSet<>();
            //Integer dist = paths.shortest(map.lookup(from), map.lookup(to), i, visited);
            Integer dist = paths.shortest(map.lookup(from), map.lookup(to), i);

            //Integer dist = paths.shortest(map.lookup(from), map.lookup(to), max);

            long time = (System.nanoTime() - t0) / 1_000; // Changed from milliseconds to microseconds
            //System.out.println("shortest: " + dist + " min (" + time + " ms)");
            System.out.println("shorest: " + dist + " min (" + time + " µs)" + ", From: "+ from + ", To: "+ to + ", Max: "+ i);
        }
    }
}
