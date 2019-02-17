package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 초콜릿 자르기 
 */
public class baek2163 {

	static int N, M;
	static int[][] dp = new int[305][305];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(i==1 && j==1) continue;
				dp[i][j] = dp[i-1][j] + dp[i][j-1] + 1 - dp[i-1][j-1];
			}
		}
		System.out.println(dp[N][M]);
	}

}
