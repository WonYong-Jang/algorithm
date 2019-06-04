package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] order = new int[1005];
	static int[][][] dp = new int[1005][3][35];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			order[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=0; j<= M; j++)
			{
				if(order[i] == 1)
				{
					if( j  > 0 ) dp[i][1][j] = max(dp[i][1][j], dp[i-1][2][j-1] + 1);
					dp[i][1][j] = max(dp[i][1][j], dp[i-1][1][j] + 1);
					
					dp[i][2][j] = max(dp[i][2][j], dp[i-1][2][j]);
					dp[i][2][j] = max(dp[i][2][j], dp[i-1][1][j]);
					
				}
				else if(order[i] == 2)
				{
					if( j > 0 )dp[i][1][j] = max(dp[i][1][j], dp[i-1][2][j-1]);
					dp[i][1][j] = max(dp[i][1][j], dp[i-1][1][j]);
					
					dp[i][2][j] = max(dp[i][2][j], dp[i-1][2][j] + 1);
					dp[i][2][j] = max(dp[i][2][j], dp[i-1][1][j] + 1);
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<= M; i++)
		{
			result = max(result, max( dp[N][2][i], dp[N][1][i] ));
		}
		System.out.println(result);
		
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}



/**
5 4
2
1
2
1
2
 */



