/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class MergeIntervals {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval interval0, Interval interval1) {
            return interval0.start - interval1.start;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<Interval> ();
        if (intervals == null || intervals.size() == 0)
            return merged;
        Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);
        for (Interval curr : intervals) {
            if (prev.end < curr.start) {
                merged.add(prev);
                prev = curr;
            } else {
                prev.start = Math.min(curr.start, prev.start);
                prev.end = Math.max(curr.end, prev.end);
            }
        }
        merged.add(prev);
        return merged;
    }
}