package com.company.programmers;

public class pro43162 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}

/**
import java.util.*;

class Solution {
    public ArrayList<Integer>[] adj;
    public int[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        adj = new ArrayList[n];
        visit = new int[n];
        
        for(int i=0; i< n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        int row = computers.length;
        int col = computers[0].length;
        
        for(int i=0; i< row; i++) {
            for(int j=0; j< col; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    adj[i].add(j);
                }
            }
        }
        
        for(int i=0; i< n; i++) {
            if(visit[i] == 0) {
                answer++;
                search(i);
            }
        }
        
        return answer;
    }
    public void search(int index) {
        
        Queue<Integer> que = new LinkedList<>();
        que.add(index);
        visit[index] = 1;
        while(!que.isEmpty()) {
            
            int cur = que.poll();
            
            for(int next : adj[cur]) {
                if(visit[next] == 1) continue;
                visit[next] = 1;
                que.add(next);
            }
        }
        
    }
} 
 */
