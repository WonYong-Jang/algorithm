package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 조종하기 
 */
public class baek2169 {

	static int N, M;
	static final int INF = 1005 * 100 * 100 * -1;
	static int[][] dp = new int[1005][1005];
	static int[][] map = new int[2][1005]; // 0 : 좌 -> 우 / 1 : 우 -> 좌 
	static int[][] data = new int[1005][1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = data[1][1];
		for(int j=2; j<= M; j++) dp[1][j] = dp[1][j-1]+ data[1][j];
		
		map[0][0] = INF; map[1][M+1] = INF;
		for(int i=2; i<= N; i++)
		{
			
			for(int j=1; j<= M; j++)
			{
				map[0][j] = data[i][j] + max(dp[i-1][j], map[0][j-1]);
			}
			for(int j= M; j >=1; j--)
			{
				map[1][j] = data[i][j] + max(dp[i-1][j], map[1][j+1]);
			}
			
			for(int j=1; j<= M; j++)
			{
				dp[i][j] = data[i][j] + max(dp[i-1][j], max(map[0][j-1], map[1][j+1]));
			}
		}
		
		System.out.println(dp[N][M]);
		
	}
	public static int max(int a, int b) { return a > b ? a : b ;}
}

/**

3 3
-1 -1 -1
-1 -1 -1
-1 -1 -1

3 3
1 1 1
1 1 1
1 1 1

 */
