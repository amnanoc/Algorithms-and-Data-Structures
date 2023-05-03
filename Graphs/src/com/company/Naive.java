package com.company;

public class Naive {
    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer found = shortest(conn.city2,to,max - conn.distance);
                if (found != null) {
                    int current = conn.distance + found;
                    if (shrt == null) shrt = current; // Prevent NullPointerException
                    else shrt = Math.min(shrt, current); // Keep the shortest route
                }
            }
        }
        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\amnan\\Downloads\\trains.csv");
        String from = args[0];
        String to = args[1];
        Integer max = Integer.valueOf(args[2]);
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }
}
