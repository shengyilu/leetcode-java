package frequent_question;

import java.util.*;

/*
 *   Given a collection of intervals, merge all overlapping intervals.
 *   Input: [[1,3],[2,6],[8,10],[15,18]]
 *   Output: [[1,6],[8,10],[15,18]]
 *   Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * */
public class Question_56 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();

        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        Queue<Integer> startQueue = new LinkedList<>();
        Queue<Integer> endQueue = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i++) {
            ((LinkedList<Integer>) startQueue).push(starts[i]);
            ((LinkedList<Integer>) endQueue).push(ends[i]);
        }

        int start = ((LinkedList<Integer>) startQueue).pop();
        int end = ((LinkedList<Integer>) endQueue).pop();

        while (startQueue.size() > 0) {
            int curStart = ((LinkedList<Integer>) startQueue).pop();
            int curEnd = ((LinkedList<Integer>) endQueue).pop();
            System.out.println(curStart + "," + curEnd);
            if (start > curStart && start > curEnd) {
                result.add(new Interval(start, end));
                start = curStart;
                end = curEnd;
            } else {
                start = curStart;
            }
            if (startQueue.size() == 0) {
                result.add(new Interval(start, end));
            }

        }


        return result;
    }

    public void solve() {

        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 18));


        List<Interval> result = merge(input);
        for (Interval interval : result) {
            System.out.println(interval.toString());
        }


    }

}
