package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test4 {
    
    static int N, K;
    static final int mod = 100000007;
    static long[] dp = new long[5001];
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=5000; i++) {
            dp[i] =  (dp[i-1] * i ) % mod;
        }
        
        int testCase = Integer.parseInt(st.nextToken());
        
        for(int k=1; k<= testCase; k++) {
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            long answer = dp[N] / ((dp[K] * dp[N-K]) % mod);
            
            bw.write("#"+k+" "+answer+"\n");
        }
        bw.flush();
    }
    
}
