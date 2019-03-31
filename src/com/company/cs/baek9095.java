package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek9095 {

	static int N;
	static int[] dp = new int[50];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			for(int i=4; i<= N; i++)
			{
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			bw.write(dp[N]+"\n");
		}
		bw.flush();
	}

}
