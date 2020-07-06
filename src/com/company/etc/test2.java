package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test2 {
    
    static int M ,N;
    static int[][] data, dp;
    static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        data = new int[M][N];
        dp = new int[M][N];
        for(int i=0; i< M; i++) {   // 초기화 
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< N; j++) {
                dp[i][j] = -1;      // 방문 표시 
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bw.write(solve(0, 0)+"\n");
        
        bw.flush();
    }
    public static int solve(int dx, int dy) {
        if(dx == M-1 && dy == N-1) return 1;               // 도착점인 경우 count + 1
        else if(dp[dx][dy] != -1) return dp[dx][dy];   // 방문한 적이 있는 경우 
        else {                                         // 한번도 방문하지 않았을 경우 
            dp[dx][dy] = 0;
            
            for(int i=0; i< 4; i++) {
                
                int rdx = dxArr[i] + dx;
                int rdy = dyArr[i] + dy;
                // M, N 범위 안에 들어오고 현재 높이보다 낮은 높이만 이동 가능 
                if(isRange(rdx, rdy) && data[dx][dy] > data[rdx][rdy] ) {
                    dp[dx][dy] += solve(rdx, rdy);
                }
            }
            
            return dp[dx][dy];
        }
    }
    public static boolean isRange(int dx, int dy) { 
        return dx >= 0 && dy >= 0 && dx < M && dy < N;
    }
}









