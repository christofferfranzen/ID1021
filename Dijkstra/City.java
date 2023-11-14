package Dijkstra;

import java.util.*;

public class City{
    public String name;
    public Integer id;
    public ArrayList<Connection> neighbours;

    public City(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.neighbours = new ArrayList<>();
    }

    public void connect(City to, int distance){
        neighbours.add(new Connection(to, distance));
    }

    public ArrayList<Connection> neighbours(){
        return neighbours;
    }

    public String getName(){
        return name;
    }

    public Integer getId(){
        return id;
    }
}

