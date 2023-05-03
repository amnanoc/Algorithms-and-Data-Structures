package com.company;


public class City {
    String name;
    Connection[] neighbors;

    public City(String name) {
        this.name = name;
        neighbors = null;
    }

    public void addNewConnection(City city, int distance) {
        if(this.neighbors == null){
            this.neighbors = new Connection[1];
            neighbors[0] =  new Connection(city, distance);
        }
        else{
            Connection[] temp = new Connection[neighbors.length + 1];
            int k;
            for (k = 0; k < neighbors.length; k++){
                temp[k] = neighbors[k];
            }
            temp[k] = new Connection(city, distance);
            neighbors = temp;
        }
    }
}
