package com.company.leetcode;

import java.util.ArrayList;

/**
 * Cheapest Flights Within K Stops
 */
public class leetcode787 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    public static class Node {
        
    }
}

/**
class Solution {
    
    public final int INF = 987654321;
    public int[][] dp = new int[105][105];
    public PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
    public ArrayList<Node>[] adj;
    public int minValue;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        adj = new ArrayList[n+1];
        minValue = INF;
        for(int i=0; i< n; i++)
        {
            adj[i] = new ArrayList<>();
        }
        
        int len = flights.length;
        int dx = 0, dy = 0, cost = 0;
        for(int i=0; i< len; i++)
        {
            dx = flights[i][0];
            dy = flights[i][1];
            cost = flights[i][2];
            adj[dx].add(new Node(dy,cost,0));
        }
        
        que.add(new Node(src, 0, 0));
        while(!que.isEmpty())
        {
            Node cur = que.poll();
            if(cur.dx == dst) {
                minValue = min(minValue, cur.cost);
                break;
            }
            
            for(Node next : adj[cur.dx])
            {
                if(next.dx == dst) {
                    que.add(new Node(next.dx, cur.cost+ next.cost, 0));
                }
                else if(cur.cnt + 1 <= K  ) {
                    int nK = cur.cnt + 1;
                    if(dp[nK][next.dx] == 0) {
                        dp[nK][next.dx] = next.cost + cur.cost;
                        que.add(new Node(next.dx, next.cost+ cur.cost, nK));
                    }
                    else if(dp[nK][next.dx] > next.cost + cur.cost ) {
                        dp[nK][next.dx] = next.cost + cur.cost;
                        que.add(new Node(next.dx, next.cost+ cur.cost, nK));
                    }
                }
            }
        }
        
        if(minValue == INF) minValue = -1;
        return minValue;
    }
    public int min(int a, int b) { return a > b ? b: a;}
    public class mySort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.cost < b.cost) return -1;
            else if(a.cost > b.cost) return 1;
            else return 0;
        }
    }
    public class Node {
        int dx, cost, cnt;
        Node(int a, int b, int c) {
            dx = a; cost = b; cnt = c;
        }
    }
}
 */
