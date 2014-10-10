package math.geometry.leetCode;

import java.util.HashMap;

import math.geometry.Point;

public class MaxPointsLine {

    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;

        int max = 1;
        HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
        // Two points are on the same line if y1 = mx1 + b and y2 = mx2 + b
        // so two points are on same line if y1 - y2 = m(x1 - x2)
        // we can store this using key m=(y1 - y2)/(x1 - x2) to number points
        for (int i = 0; i < points.length; i++) {
            Point a = points[i];
            lines.clear();
            // keep track of number of points on top of a
            int duplicates = 0;
            // If all points are on top of one another
            lines.put((double) Integer.MIN_VALUE, 1);

            // construct a map from m values to number of points (not a) sharing
            // m value
            for (int j = i + 1; j < points.length; j++) {
                Point b = points[j];
                if (a.x == b.x && a.y == b.y) {
                    duplicates++;
                    continue;
                }
                double m = a.x - b.x == 0 ? Integer.MAX_VALUE : 0.0
                        + ((double) a.y - b.y) / ((double) a.x - b.x);
                if (lines.containsKey(m)) {
                    lines.put(m, lines.get(m) + 1);
                } else {
                    lines.put(m, 2);
                }
            }
            for (double slope : lines.keySet()) {
                int tmp = lines.get(slope) + duplicates;
                System.out
                        .printf("Number points on line of slope %.2f with Point %s: %d\n",
                                slope, a, tmp);

                max = tmp > max ? tmp : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Point[] pts = new Point[3];
        pts[0] = new Point(2, 3);
        pts[1] = new Point(3, 3);
        pts[2] = new Point(-5, 3);
        System.out.println(maxPoints(pts));
    }
}
