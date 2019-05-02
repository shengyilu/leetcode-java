/*
57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 */

package frequent_question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Question_57 {


    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();
        Queue<Integer> startQueue = new LinkedList<>();
        Queue<Integer> endQueue = new LinkedList<>();
        boolean isStartInsert = false;
        boolean isEndInsert = false;

        for (Interval interval : intervals) {
            int curStart = interval.start;
            int curEnd = interval.end;

            if (!isStartInsert) {
                if (newInterval.start <= curStart) {
                    ((LinkedList<Integer>) startQueue).push(newInterval.start);
                    System.out.println(newInterval.start);
                    isStartInsert = true;
                }
            }
            ((LinkedList<Integer>) startQueue).push(curStart);

            if (!isEndInsert) {
                if (newInterval.end <= curEnd) {
                    ((LinkedList<Integer>) endQueue).push(newInterval.end);
                    System.out.println(newInterval.end);
                    isEndInsert = true;
                }
            }
            ((LinkedList<Integer>) endQueue).push(curEnd);
        }

        int start = ((LinkedList<Integer>) startQueue).pop();
        int end = ((LinkedList<Integer>) endQueue).pop();
        System.out.println(start + "," + end);

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
        input.add(new Interval(1, 5));
        input.add(new Interval(6, 8));
;


        List<Interval> result = insert(input, new Interval(0, 9));
        for (Interval interval : result) {
            System.out.println(interval.toString());
        }


    }
}
