package com.company.leetcode;

public class leetcode1184 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;

class Solution {
    static final int INF = 10001*10001;
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int len = distance.length;
        int[] dp = new int[len];
        Arrays.fill(dp,INF);
        
        PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
        
        dp[start] = 0;
        que.add(new Node(distance[start], start));
        
        while(!que.isEmpty()) {
            Node cur = que.poll();
            
            int right = (cur.index + 1) % len;
            int left = (cur.index - 1);
            if(left < 0) left = len - 1;
            
            if(dp[cur.index] + distance[cur.index] < dp[right]) {
                dp[right] = dp[cur.index] + distance[cur.index];
                que.add(new Node(dp[right], right));
            }
            if(dp[cur.index] + distance[left] < dp[left]) {
                dp[left] = dp[cur.index] + distance[left];
                que.add(new Node(dp[left], left));
            }
            
        }
        
        return dp[destination];
    }
    static class mySort implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.num - b.num;
        }
    }
    static class Node {
        int num, index;
        Node(int a, int b) {
            num=a; index=b;
        }
    }
} 
 */
