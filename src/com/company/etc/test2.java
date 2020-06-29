package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test2 {
    
    static final int INF = 1 << 30;
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        
        for(int i=1; i<= N; i++) dp[i] = INF;
        
        search(N, 0);
        
        bw.write(dp[1]+"\n");
        bw.flush();
        
    }
    public static void search(int num, int cnt) {
        
        if(num <= 0 || dp[num] <= cnt ) {
            return;
        }
        
        dp[num] = cnt;
        
        if(num % 3 == 0) search(num/3, cnt+1);
        if(num % 2 == 0) search(num/2, cnt+1); 
        
        search(num-1, cnt+1);
    }
}









