package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class test2 {
    
    static int N;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        long[] dp = new long[N+2];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        bw.write(dp[N]+"\n");
        
        bw.flush();
    }
    
}





