package com.company.leetcode;

public class leetcode253 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int len = intervals.length;
        
        Arrays.sort(intervals, new mySort());
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        int answer = 0;
        for(int i=0; i< len; i++) {
            
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if(que.isEmpty()) {
                que.add(end);
                answer++;
            }
            else {
                if(start >= que.peek()) {
                    que.poll();
                }
                else {
                    answer++;
                }
                que.add(end);
            }
        }
        return answer;
    }
    public class mySort implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        }
    }
}
 */
