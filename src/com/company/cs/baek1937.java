package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class baek1937 {

	static int N, result;
    static int[][] dp = new int[505][505];
    static int[][] data = new int[505][505];
    static int[] dxArr = {0, 0, 1, -1}, dyArr ={1, -1, 0, 0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        result =0;
       	for(int i=1; i<= N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<= N; j++)
            {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
      	
        for(int i=1; i<= N; i++)
        {
            for(int j=1; j<= N; j++)
            {
                if(dp[i][j] > 0 ) continue;
                solve(i,j);
            }
        }
        bw.write(result+"\n");
        bw.flush();
	}
    public static int solve(int dx, int dy)
    {
        if(dp[dx][dy] > 0 ) return dp[dx][dy];
        dp[dx][dy] = 1;
        int maxValue =0;
        for(int i=0; i<4; i++)
        {
            int rdx = dx + dxArr[i];
            int rdy = dy + dyArr[i];
            if(!isRange(rdx, rdy) || data[rdx][rdy] <= data[dx][dy] ) continue;
            int num = solve(rdx,rdy);
            maxValue = max(maxValue, num);
        }
        dp[dx][dy] += maxValue;
        result = max(result, dp[dx][dy]);
        return dp[dx][dy];
    }
    public static int max(int a, int b) { return a > b? a: b; }
    public static boolean isRange(int dx, int dy)
    {
        return dx >= 1 && dy >= 1 && dx<= N && dy <= N;
    }
}


