package Föreläsning;

import java.util.*;

import java.util.*;

public class DijkstraShortestPath {
    /*
    public static void findShortestPath(Map<Integer, City> cities, int sourceId, int destinationId) {
        PriorityQueue<Path> queue = new PriorityQueue<>();
        Map<Integer, Path> shortestPaths = new HashMap<>();

        queue.add(new Path(cities.get(sourceId), null, 0));

        while (!queue.isEmpty()) {
            Path currentPath = queue.poll();
            City currentCity = currentPath.city;

            if (currentCity.id == destinationId) {
                // Shortest path to destination found
                printShortestPath(currentPath);
                break;
            }

            if (shortestPaths.containsKey(currentCity.id)) {
                continue; // Skip if we've already found a shorter path to this city
            }

            shortestPaths.put(currentCity.id, currentPath);

            for (Connection connection : currentCity.neighbours) {
                City neighbor = connection.neighbour;
                int newDistance = currentPath.dist + connection.distance;
                Path newPath = new Path(neighbor, currentPath, newDistance);

                queue.add(newPath);
            }
        }
    }

     */

    private static void printShortestPath(Path path) {
        List<City> cities = new ArrayList<>();
        while (path != null) {
            cities.add(path.city);
            path = path.prev;
        }
        Collections.reverse(cities);

        int totalDistance = path.dist; // The distance of the final path is the total distance

        for (City city : cities) {
            System.out.print(city.name + " -> ");
        }
        System.out.println("Total Distance: " + totalDistance);
    }

    /*
    public static void main(String[] args) {
        // Create a map to hold cities, where the key is the city's ID
        Map<Integer, City> cities = new HashMap<>();

        // Create and populate cities
        City malmo = new City("Malmö", 0);
        City stockholm = new City("Stockholm", 1);
        // Add more cities as needed

        // Create connections between cities
        List<Connection> malmoConnections = new ArrayList<>();
        malmoConnections.add(new Connection(stockholm, 500)); // Example connection from Malmö to Stockholm
        malmo.setNeighbours(malmoConnections);

        // Set up the data structure for cities
        cities.put(malmo.id, malmo);
        cities.put(stockholm.id, stockholm);

        // Find the shortest path from Malmö to Stockholm (assuming their respective IDs)
        findShortestPath(cities, 0, 1);
    }

     */

class City {
    public String name;
    public Integer id;
    public List<Connection> neighbours;

    public City(String name, Integer id, List<Connection> neighbours) {
        this.name = name;
        this.id = id;
        this.neighbours = neighbours;
    }
}

class Connection {
    public City neighbour;
    public int distance;

    public Connection(City neighbour, int distance) {
        this.neighbour = neighbour;
        this.distance = distance;
    }
}

class Path implements Comparable<Path> {
    public City city;
    public Path prev;
    public Integer dist;

    public Path(City city, Path prev, Integer dist) {
        this.city = city;
        this.prev = prev;
        this.dist = dist;
    }

    @Override
    public int compareTo(Path other) {
        return this.dist.compareTo(other.dist);
    }
    }
}
