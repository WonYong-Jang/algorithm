package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek2688 {

	static int N;
	static long[][] dp = new long[65][10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= 9; i++) dp[1][i] = 1;
		for(int i = 2; i <= 64; i++)
		{
			long sum = 0;
			for(int j = 0; j <= 9; j++)
			{
				dp[i][j] = dp[i-1][j] + sum;
				sum = dp[i][j];
			}
		}
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			long result = 0;
			for(int i=0; i<= 9; i++)
			{
				result += dp[N][i];
			}
			bw.write(result+"\n");
		}
		bw.flush();
	}
}



