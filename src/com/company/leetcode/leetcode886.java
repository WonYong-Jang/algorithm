package com.company.leetcode;

public class leetcode886 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    
    ArrayList<Integer>[] adj;
    int[] visit;
    boolean flag;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        
        adj = new ArrayList[N+5];
        visit = new int[N+5];
        flag = true;
        for(int i=1; i<= N; i++) {
            adj[i] = new ArrayList<>();
            visit[i] = -1;
        }
        
        for(int[] cur : dislikes) {
            adj[cur[0]].add(cur[1]);
            adj[cur[1]].add(cur[0]);
        }
        
        for(int i=1; i<= N; i++) {
            if(visit[i] != -1) continue;
            visit[i] = 0;
            search(i, 0);
            if(!flag) return false;
        }
        
        return true;
    }
    public void search(int cur, int color) {
        
        int nextColor = (color+1) % 2;
        for(int next : adj[cur]) {
            if(visit[next] != -1 && visit[next] == color) {
                flag = false;
                return;
            }
            if(visit[next] == -1) {
                visit[next] = nextColor;
                search(next, nextColor);   
            }
        }
    }
    
}



 
 */
