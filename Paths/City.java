package Paths;

public class City {
    String name;
    Connection[] neighbors;
    int index;

    public City(String name) {
        this.name = name;
        neighbors = new Connection[10]; // No city will have more then 10 connections
        index = 0;
    }

    public void newConnection(City destination, int minutes) {
        neighbors[index++] = new Connection(destination, minutes);
        destination.neighbors[destination.index++] = new Connection(this, minutes);
    }

    public String getName() {
        return name;
    }
}