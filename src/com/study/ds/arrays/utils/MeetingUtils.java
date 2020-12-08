package com.study.ds.arrays.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingUtils {
    /**
     * Meeting Room
     *
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     *
     * Example 1:
     *
     * Input: [[0,30],[5,10],[15,20]]
     * Output: false
     * Example 2:
     *
     * Input: [[7,10],[2,4]]
     * Output: true
     *
     */
    public static boolean canAttendMeetings(int[][] intervals){
        if(intervals.length == 0) return false;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; i++) {
            int end = intervals[i - 1][1];
            int start = intervals[i][0];

            if(end > start) return false;
        }

        return true;
    }

    /**
     * Meeting Room II
     *
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     *
     * Example 1:
     *
     * Input: [[0, 30],[5, 10],[15, 20]]
     * Output: 2
     * Example 2:
     *
     * Input: [[7,10],[2,4]]
     * Output: 1
     *
     */
    public static int minMeetingRooms(int[][] intervals){
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int meetingRooms = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if(priorityQueue.isEmpty()){
                meetingRooms ++;
                priorityQueue.add(interval[1]);
            } else {
                int end = priorityQueue.peek();
                int start = interval[0];

                if(start >= end) {
                    priorityQueue.poll();
                } else {
                    meetingRooms ++;
                }

                priorityQueue.add(interval[1]);
            }
        }

        return meetingRooms;
    }

    /**
     * Merge Intervals
     *
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     *
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0])
                merged.add(interval);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }

        return merged.toArray(new int[merged.size()][]);

    }
}
