package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 알약 
 */
public class baek4811 {

	static int N;
	static long[][] dp = new long[40][40];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			for(int i=0; i<= N; i++)
			{
				for(int j=0; j<= N; j++)
				{
					dp[i][j] = 0;
				}
			}
			long result = solve(N, 0);
			bw.write(result+"\n");
			
		}
		bw.flush();
	}
	public static long solve(int whole, int half)
	{
		if(whole == 0 && half == 0) return 1;
		else if(dp[whole][half] > 0) return dp[whole][half];
		long wholeCnt =0, halfCnt =0;
		
		if(half > 0 && half <= N)
		{
			halfCnt = solve(whole, half-1);
		}
		if(whole > 0 && whole <= N)
		{
			wholeCnt = solve(whole-1, half+1);
		}
		
		return dp[whole][half] = wholeCnt + halfCnt;
	}
}


