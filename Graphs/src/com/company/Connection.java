package com.company;

public class Connection {
    City city2;
    int distance;

    public Connection(City city1, int distance) {
        this.city2 = city1;
        this.distance = distance;
    }

    public City getCity2() {
        return city2;
    }

    public void setCity2(City city2) {
        this.city2 = city2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
