/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length < 3)
            return points.length;

        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Point base = points[i];
            int samePointsAsBase = 0, maxPointsInLine = 1;
            Map<Float, Integer> slopeCount = new HashMap<Float, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                Point next = points[j];
                Float slope;
                if (base.y == next.y) {
                    if (base.x == next.x) {
                        samePointsAsBase += 1;
                        continue;
                    } else
                        slope = Float.POSITIVE_INFINITY;
                } else {
                    if (base.x == next.x)
                        slope = new Float(0);
                    else
                        slope = new Float((float) (next.y - base.y)
                                / (float) (next.x - base.x));
                }
                int count = 1;
                if (slopeCount.containsKey(slope))
                    count = slopeCount.get(slope);
                slopeCount.put(slope, count + 1);
                maxPointsInLine = Math.max(count + 1, maxPointsInLine);
            }
            result = Math.max(result, maxPointsInLine + samePointsAsBase);
        }
        return result;
    }
}