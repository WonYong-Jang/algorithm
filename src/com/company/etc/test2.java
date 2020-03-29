package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;



public class test2 {
    
    static int N, M, K;
    static long[] tree, data;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new long[N*4];
        data = new long[N+1];
        for(int i=1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, N);
        
        for(int i=1; i<= M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            if(cmd == 1) {
                update(1,1,N, dx, (long)dy - data[dx]);
                data[dx] = dy;
            }
            else {
                long result = sum(1,1,N, dx, dy);
                bw.write(result+"\n");
            }
        }
        bw.flush();
    }
    public static long init(int node, int start, int end) {
        int mid = (start + end) / 2;
        if(start == end) return tree[node] = data[start];
        else return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }
    public static void update(int node, int start, int end, int target, long diff) {
        if(target < start || target > end) return;
        tree[node] += diff;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(node*2, start, mid, target, diff);
        update(node*2+1, mid+1, end, target, diff);
    }
    public static long sum(int node, int start, int end, int i, int j) {
        if(j < start || i > end) return 0;
        else if(i <= start && end <= j) return tree[node];
        int mid = (start + end) / 2;
        return sum(node*2, start, mid, i, j) + sum(node*2+1, mid+1, end, i, j);
    }
}





