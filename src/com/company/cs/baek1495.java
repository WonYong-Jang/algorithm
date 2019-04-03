package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 기타 리스트 
 */
public class baek1495 {

	static int N, S, M;
	static int[] data = new int[105];
	static int[][] dp = new int[105][1005];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int target = 0;
		dp[0][S] = 1;
		for(int i=1; i<= N; i++)
		{
			for(int j=0; j<= M; j++)
			{
				if(dp[i-1][j] == 0) continue;
				target = j;
				if(target + data[i] <= M)
				{
					dp[i][target+data[i]] = 1;
				}
				if(target - data[i] >= 0)
				{
					dp[i][target-data[i]] = 1;
				}
			}
		}
		int ans = -1;
		for(int i= M; i>=0; i--)
		{
			if(dp[N][i] == 1) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

}
