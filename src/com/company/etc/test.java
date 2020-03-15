package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
    
    static final int max_level = 17; // 2^17 이 100,000 을 조금 넘으므로 
    static int N, M;
    static Queue<Integer> que = new LinkedList<>();
    static int[] depth;
    static int[][] par;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        par = new int[N+1][max_level+1];
        depth = new int[N+1];
        for(int i=0; i<= N; i++) {
            adj[i] = new ArrayList<>();
            depth[i] = -1; // 주의 : 모두 -1로 초기화 해주기! 
        } // 아래 소스 중 if(depth[dx] <= depth[par[dy][k]])  
        // par[dy][k] 가 0이 나왔을때 dy 가 0으로 업데이트 되면 안되기 때문에 depth[0] = -1 반드시 해주기 
        for(int i=1; i<= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            adj[dx].add(dy);
            adj[dy].add(dx);
        }
        
        que.add(1); // 루트 부터 depth 와 각 노드별 조상 기록 하기
        depth[1] = 0;
        while(!que.isEmpty()) {
            int n = que.poll();
            
            for(int next : adj[n]) {
                if(depth[next] == -1) {
                    depth[next] = depth[n] + 1;
                    par[next][0] = n;
                    que.add(next);
                }
            }
        }
        
        for(int k = 1; k <= max_level; k++) { // 각 노드 별로 부모 기록 ! 
            for(int cur = 1; cur <= N; cur++) { // 2^0 , 2^1, 2^2 ..
                int tmp = par[cur][k-1];
                par[cur][k] = par[tmp][k-1];
            }
        }
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for(int i=1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            
            if(depth[dx] != depth[dy]) {
                
                if(depth[dx] > depth[dy]) { // dy 기준으로 depth 맞추기 위해서 
                    int tmp = dx;
                    dx = dy;
                    dy = tmp;
                }
                
                for(int k = max_level; k >= 0; k--) {
                    if(depth[dx] <= depth[par[dy][k]]) {
                        dy = par[dy][k];
                    }
                }
            }
            
            int lca = dx;
            
            if(dx != dy) {
                for(int k = max_level; k >= 0; k--) {
                    if(par[dx][k] != par[dy][k]) {
                        dx = par[dx][k];
                        dy = par[dy][k];
                    }
                    lca = par[dx][k];
                }
            }
            bw.write(lca+"\n");
        }
        bw.flush();
    }
}





