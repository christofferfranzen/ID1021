package Graphs;

public class Naive {
    public static final String file = "C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\Graphs\\trains.csv";

    public static void main(String[] args) {
        Map map = new Map(file);
        //String from = args[0];
        //String to = args[1];
        //Integer max = Integer.valueOf(args[2]);

        //int[] max = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000};
        int[] max = {1000, 1300, 10000};

        for (int i : max){
            String from = "Göteborg";
            String to = "Sundsvall";
            long t0 = System.nanoTime();
            Integer dist = shortest(map.lookup(from), map.lookup(to), i);
            long time = (System.nanoTime() - t0) / 1_000_000;
            System.out.println("shorest: " + dist + " min (" + time + " ms)" + ", From: "+ from + " to: " + to + ", Max: " + i);
        }
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;

        if (from == to)
            return 0;

        Integer shortestPath = null;

        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                City neighborCity = conn.city;
                int timeToNeighbor = conn.minutes;

                // Check if the time consumed so far is within the allowed maximum
                if (max - timeToNeighbor >= 0) {
                    // Recursively search for the shortest path from the neighbor city to the destination
                    Integer pathToDestination = shortest(neighborCity, to, max - timeToNeighbor);

                    // If a valid path is found, update the shortestPath
                    if (pathToDestination != null) {
                        int totalPathTime = timeToNeighbor + pathToDestination;
                        if (shortestPath == null || totalPathTime < shortestPath) {
                            shortestPath = totalPathTime;
                        }
                    }
                }else {
                    return null;
                }
            }
        }

        return shortestPath;
    }
}
