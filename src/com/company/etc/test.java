package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
    
    static int[] indegree;
    static ArrayList<Integer>[] adj;
    static Queue<Integer> que = new LinkedList<>();
    static int N, M;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=1; i<= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        int dx = 0, dy = 0;
        for(int i=1; i<= M; i++) {
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            adj[dx].add(dy);
            indegree[dy]++; // 선행되어야할 노드 갯수 세기 
        }
        
        for(int i=1; i<= N; i++) { // ingegree == 0 은 선행되어야 할 노드  
            if(indegree[i] == 0) que.add(i); // 전부 처리되었으니 진행 가능 ! 
        }
        
        int flag = 0; // flag == N 이면 위상정렬 완료
                      // flag > N 사이클 존재 ! 
                      // flag < N 위상정렬 불가능 
        while(!que.isEmpty()) {
            
            int cur = que.poll();
            flag++;
            bw.write(cur + " ");
            
            for(int next : adj[cur]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    que.add(next);
                }
            }
        }
        bw.write("\n");
        bw.flush();
    }
}





