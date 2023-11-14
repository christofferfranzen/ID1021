package Paths;

public class Paths_improved {
    City[] path;
    int sp;

    public Paths_improved() {
        path = new City[54]; // Make sure this array size is large enough
        sp = 0;
    }

    Integer shortest(City from, City to, Integer max) {
        for (int i = 0; i < sp; i++) {
            if (path[i] == from) {
                return null; // Avoid revisiting cities or exceeding time constraint
            }
        }
        if (from == to) {
            return 0;
        }

        path[sp++] = from; // Mark the current city as visited

        Integer shrt = max;

        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer remainingTime;
                if (shrt == null) {
                    remainingTime = null;
                } else {
                    remainingTime = shrt - conn.minutes;
                }

                Integer subShortest = shortest(conn.city, to, remainingTime);
                if (subShortest != null) {
                    int totalMinutes = conn.minutes + subShortest;
                    if (shrt == null || totalMinutes < shrt) {
                        shrt = totalMinutes;
                    }
                }
            }
        }

        path[--sp] = null; // Unmark the current city when backtracking

        return shrt;
    }
}
