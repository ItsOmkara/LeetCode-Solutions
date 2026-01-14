import java.util.*;

class Solution {

    static class Event {
        long y;
        long x1, x2;
        int type; 
        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            long x1 = s[0];
            long y1 = s[1];
            long l  = s[2];
            long x2 = x1 + l;
            long y2 = y1 + l;

            events.add(new Event(y1, x1, x2, +1)); 
            events.add(new Event(y2, x1, x2, -1)); 
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        TreeMap<Long, Integer> active = new TreeMap<>();
        long prevY = events.get(0).y;
        double totalArea = 0;

       
        for (Event e : events) {
            long currY = e.y;
            long height = currY - prevY;
            if (height > 0) {
                long width = mergedWidth(active);
                totalArea += (double) width * height;
            }
            update(active, e);
            prevY = currY;
        }

        double half = totalArea / 2.0;

        
        active.clear();
        prevY = events.get(0).y;
        double acc = 0;

        for (Event e : events) {
            long currY = e.y;
            long height = currY - prevY;
            if (height > 0) {
                long width = mergedWidth(active);
                double slabArea = (double) width * height;

                if (acc + slabArea >= half) {
                    double need = half - acc;
                    return prevY + need / width;
                }
                acc += slabArea;
            }
            update(active, e);
            prevY = currY;
        }

        return prevY; 
    }

    private void update(TreeMap<Long, Integer> map, Event e) {
        map.put(e.x1, map.getOrDefault(e.x1, 0) + e.type);
        map.put(e.x2, map.getOrDefault(e.x2, 0) - e.type);

        if (map.get(e.x1) == 0) map.remove(e.x1);
        if (map.get(e.x2) == 0) map.remove(e.x2);
    }

    private long mergedWidth(TreeMap<Long, Integer> map) {
        long width = 0;
        int count = 0;
        long last = 0;

        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            long x = e.getKey();
            if (count > 0) width += x - last;
            count += e.getValue();
            last = x;
        }
        return width;
    }
}
