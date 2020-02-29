package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test {
    
    static int N;
    static int[] dp, data;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        data = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for(int i=1; i<= N; i++)
        {
            for(int j=0; j< i; j++)
            {
                if(data[j] < data[i]) { 
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        bw.write(answer+"\n");
        bw.flush();
    }
}





