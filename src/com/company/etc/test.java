package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class test {
    
    static int N, M, number;
    static ArrayList<Integer>[] adj = new ArrayList[100001];
    static int[] order = new int[10001];       // 순서 배열 
    static boolean[] cut = new boolean[10001]; // 단절점 체크 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = 0;
        for(int i=1; i<= N; i++)
        {
            adj[i] = new ArrayList<>();
        }
        int dx = 0, dy = 0;
        for(int i=1; i<= M; i++)
        {
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            adj[dx].add(dy);
            adj[dy].add(dx);
        }
        
        for(int i=1; i<= N; i++)
        {
            if(order[i] > 0) continue;   // 방문 기록있으면 continue 
            search(0, i);                // root를 0 으로 표시 
        }
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<= N; i++) 
        {
            if(cut[i]) {
                cnt++;
                sb.append(i+" ");
            }
        }
        bw.write(cnt+"\n");
        bw.write(sb.toString()+"\n");
        bw.flush();
    }
    public static int search(int p, int cur)
    {
        order[cur] = ++number; // 순서 표시 
        int ret = order[cur];  // 가장 빠른 순서 체크 
        int child = 0;         // 자식 수 
        
        for(int next : adj[cur])
        {
            if(next == p) continue; // 부모면 continue
            if(order[next] > 0 )
            {
                ret = Math.min(ret, order[next]);
                continue;
            }
            
            child++;
            int prev = search(cur, next);
            
            if(p != 0 && prev >= order[cur]) // root 가 아니고 자식이 더 빠른 방문순서로 갈수 없다면 단절 
            {
                cut[cur] = true;
            }
            
            ret = Math.min(ret, prev);
        }
        if(p == 0 && child >= 2) cut[cur] = true;
        HashSet<Integer> set = new HashSet<>();
        
        return ret;
    }
}





