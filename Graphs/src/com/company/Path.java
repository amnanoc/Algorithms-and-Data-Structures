package com.company;
public class Path {
    City[] path;
    int sp;
    public Path() {
        path = new City[54];
        sp = 0;
    }
    private Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }

        path[sp++] = from; //store the first city
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer found;
                if(max==null)
                    found = shortest(conn.city2,to,null);
                else
                    found = shortest(conn.city2,to,max- conn.distance);

                if (found != null) {
                    int current = conn.distance + found;
                    if (shrt == null) shrt = current;
                    else shrt = Math.min(shrt, current);
                }
            }
        }

        path[sp--] = null;
        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\amnan\\Downloads\\trains.csv");
        String from = args[0];
        String to = args[1];
        Integer max = Integer.valueOf(args[2]);
        Path path = new Path();
        long t0 = System.nanoTime();
        Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }


}
