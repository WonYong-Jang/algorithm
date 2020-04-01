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
    static int[] data, dp;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        data = new int[N+1];
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        int index = 1;
        dp[1] = data[1];
        for(int i=2; i <= N; i++) {
            if(dp[index] < data[i]) dp[++index] = data[i];
            else {
                int idx = lower_bound(1, index, data[i]);
                dp[idx] = data[i];
            }
        }
        bw.write(index+"\n");
        bw.flush();
    }
    public static int lower_bound(int s, int e, int target) {
        
        int mid = 0;
        
        while(s < e) {
            mid = (s + e) / 2;
            if(dp[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid;
            }
        }
        return e;
    }
}





