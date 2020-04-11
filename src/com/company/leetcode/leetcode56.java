package com.company.leetcode;

public class leetcode56 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    public int[][] merge(int[][] intervals) {
        
        ArrayList<Node> arr = new ArrayList<>();
        ArrayList<Node> ans = new ArrayList<>();
        if(intervals.length == 0) return intervals;
        for(int[] cur : intervals) {
            arr.add(new Node(cur[0], cur[1]));
        }
        Collections.sort(arr, new mySort());
        
        int start = arr.get(0).dx , end = arr.get(0).dy;
        for(int i=1; i< arr.size(); i++) {
            
            int curStart = arr.get(i).dx;
            int curEnd = arr.get(i).dy;
            
            if(start <= curStart && curStart <= end) {
                end = Math.max(curEnd, end);
            }
            else {
                ans.add(new Node(start, end));
                start = curStart;
                end = curEnd;
            }
        }
        ans.add(new Node(start, end));
        int[][] result = new int[ans.size()][2];
        
        for(int i=0; i< ans.size(); i++) {
            result[i][0] = ans.get(i).dx;
            result[i][1] = ans.get(i).dy;
        }
        
        return result;
    }
    public class mySort implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if(a.dx != b.dx) return a.dx - b.dx;
            else return a.dy - b.dy;
        }
    }
    public class Node {
        int dx, dy;
        Node(int a, int b) {
            dx = a; dy =b;
        }
    }
} 
 */
