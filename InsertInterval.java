/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int insertPos = 0;
        while (insertPos < intervals.size()) {
            int start = intervals.get(insertPos).start;
            int end = intervals.get(insertPos).end;
            if (newInterval.start < start)
                break;
            else if (newInterval.start >= start && newInterval.start <= end) {
                newInterval.start = start;
                break;
            } else if (newInterval.start > end)
                insertPos++;
        }

        while (insertPos < intervals.size()) {
            int start = intervals.get(insertPos).start;
            int end = intervals.get(insertPos).end;
            if (newInterval.end < start) {
                break;
            } else if (newInterval.end >= start && newInterval.end <= end) {
                newInterval.end = end;
                intervals.remove(insertPos);
                break;
            } else if (newInterval.end > end) {
                intervals.remove(insertPos);
            }
        }
        intervals.add(insertPos, newInterval);
        return intervals;
    }
}