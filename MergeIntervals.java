/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new LinkedList<Interval>();
        for (Interval interval : intervals)
            insertIntoList(list, interval);
        return list;
    }

    private void insertIntoList(List<Interval> intervals, Interval newInterval) {
        int pos = 0;
        while (pos < intervals.size()) {
            Interval currInterval = intervals.get(pos);
            if (newInterval.end < currInterval.start)
                break;
            else if (newInterval.start > currInterval.end)
                pos++;
            else {
                newInterval.end = Math.max(currInterval.end, newInterval.end);
                newInterval.start = Math.min(currInterval.start,
                        newInterval.start);
                intervals.remove(pos);
            }
        }
        intervals.add(pos, newInterval);
    }
}