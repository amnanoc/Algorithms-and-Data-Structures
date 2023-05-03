package com.company;
import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 541;
    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                //look if either of the two cities exist
                //if they do, update the connections for the ones that exist
                //otherwise add a new city
                City city1 = lookup(fields[0]);
                City city2 = lookup(fields[1]);
                city1.addNewConnection(city2, Integer.parseInt(fields[2]));
                city2.addNewConnection(city1, Integer.parseInt(fields[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

   private boolean cityExists(String city) {
        return cities[hash(city)] != null;
    }

    public City lookup(String city) {

        if(!cityExists(city)) {
            cities[hash(city)] = new City(city);
            return cities[hash(city)];
        } else
            return cities[hash(city)];
    }

  /*  public City lookup(String city){
        Integer look = hash(city);
        for(int i = look; i < cities.length; i++){
            if(cities[i] == null){
                cities[i] = new City(city);
                return cities[i];
            }
            else if(cities[i].name.equals(city)){
                return cities[i];
            }
        }
        System.out.println("No such city");
        return null;
    }*/
}
