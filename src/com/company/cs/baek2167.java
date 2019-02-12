package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 2차원 배열의 합 
 */
public class baek2167 {
 
	static int N, M, K;
	static int[][] data = new int[305][305];
	static int[][] dp = new int[305][305];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int num = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				num = Integer.parseInt(st.nextToken());
				data[i][j] = num;
				dp[i][j] = num;
				dp[i][j] += (dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		int sdx=0, sdy=0, edx=0, edy=0, result = 0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			sdx = Integer.parseInt(st.nextToken());
			sdy = Integer.parseInt(st.nextToken());
			edx = Integer.parseInt(st.nextToken());
			edy = Integer.parseInt(st.nextToken());
			
			result = dp[edx][edy] - dp[sdx-1][edy] - dp[edx][sdy-1] + dp[sdx-1][sdy-1];
			bw.write(result+"\n");
		}
		bw.flush();
	}

}
