package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test2 {
    
    static final int MAX_VALUE = 1000001;
    static int N, M, K;
    static long[] tree = new long[4*MAX_VALUE];
    static long[] data = new long[MAX_VALUE];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i] = Long.parseLong(st.nextToken());
        }
        init(1,1,N);
        
        int cmd = 0, dx = 0, dy =0;
        for(int i=1; i<= M+K; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            
            if(cmd == 1) {
                
                long diff =dy-data[dx];
                data[dx] = dy;
                
                update(1,1,N,dx,diff);
            }
            else {
                long result = sum(1, 1, N, dx, dy);
                bw.write(result+"\n");
            }
        }
        bw.flush();
    }
    public static void update(int node, int start, int end, int target, long diff) {
        int mid = start + (end - start) / 2;
        if(target < start || end < target) return;
        tree[node] += diff;
        if(start == end) return;
        update(node*2, start, mid, target, diff);
        update(node*2+1, mid+1, end, target, diff);
    }
    public static long init(int node, int start, int end) {
        int mid = start + (end - start) /2;
        if(start == end) return tree[node] = data[start];
        else return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }
    public static long sum(int node, int start, int end, int i, int j) {
        int mid = start + (end - start) / 2;
        if(j < start || end < i) return 0;
        else if(i <= start && end <= j) return tree[node];
        else return sum(node*2, start, mid, i, j) + sum(node*2+1, mid+1, end, i, j);
    }
}









