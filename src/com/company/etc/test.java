package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
    
    static final int MAX_VALUE = 32001;
    static int N, M; 
    static ArrayList<Integer>[] adj = new ArrayList[MAX_VALUE];
    static int[] indegree = new int[MAX_VALUE];
    static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        int dx =0, dy=0;
        for(int i=1; i<= M; i++) {
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            adj[dx].add(dy);
            indegree[dy]++;
        }
        
        for(int i=1; i<= N; i++) {
            if(indegree[i] == 0) que.add(i);
        }
        
        while(!que.isEmpty()) {
            int num = que.poll();
            bw.write(num+" ");
            for(int next : adj[num]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    que.add(next);
                }
            }
        }
        bw.flush();
    }
    
}





