package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
    
    static int H, W, N;
    static int[][] dp, data;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[H+2][W+2];
        data = new int[H+2][W+2];
        
        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= W; j++) {
                if(i == 1 && j == 1) dp[1][1] = N-1; // 출근길 N-1 번째 동안 밟은 횟수
                
                if(dp[i][j] % 2 != 0) {
                    if(data[i][j] == 1) {
                        dp[i][j+1] += (dp[i][j] + 1) / 2;
                        dp[i+1][j] += dp[i][j] / 2;
                    }
                    else {
                        dp[i][j+1] += dp[i][j] / 2;
                        dp[i+1][j] += (dp[i][j]+1) / 2;
                    }
                }
                else {
                    dp[i][j+1] += dp[i][j] / 2;
                    dp[i+1][j] += dp[i][j] / 2;
                }
            }
        }
        
        int dx = 1, dy =1; // 시작 인덱스 
        while(dx >=1 && dy >=1 && dx<= H && dy <= W)
        {
            if(dp[dx][dy] % 2 != 0) {       // 홀수 일때 방향 전환 
                if(data[dx][dy] == 1) dx++; // 아래로 방향 전환 
                else dy++;                  // 오른쪽 으로 방향 전환 
            }
            else { // 짝수 일때 그대로 
                if(data[dx][dy] == 1) dy++;
                else dx++;
            }
        }
        bw.write(dx+" "+dy+"\n");
        bw.flush();
    }
}





