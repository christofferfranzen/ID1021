package Föreläsning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Test2 {
    static class Route {
        String start;
        String end;
        int distance;

        Route(String start, String end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static final String file = "C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\Graphs\\trains.csv";

    public static void main(String[] args) {
        List<Route> routes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");  // row[0] = from, row[1] = to, row[2] = minutes
                int minutes = Integer.parseInt(row[2]);
                routes.add(new Route(row[0], row[1], minutes));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }

        findCombinations(routes, 143, new ArrayList<>(), 0, 0);
    }

    private static void findCombinations(List<Route> routes, int target, List<Route> currentCombination, int currentSum, int startIndex) {
        if (currentSum == target) {
            for (Route route : currentCombination) {
                System.out.println(route.start + " -> " + route.end + " : " + route.distance);
            }
            System.out.println();
            return;
        }

        for (int i = startIndex; i < routes.size(); i++) {
            Route route = routes.get(i);
            int newSum = currentSum + route.distance;

            if (newSum <= target) {
                currentCombination.add(route);
                findCombinations(routes, target, currentCombination, newSum, i + 1);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
