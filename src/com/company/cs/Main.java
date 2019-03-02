package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int mod = 10007;
	static int N, K;
	static int[][] dp = new int[1002][1002];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++) 
		{
			dp[i][0] = 1; dp[i][i] = 1;
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= min(N, K); j++)
			{
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % mod;
			}
		}
		System.out.println(dp[N][K]);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}





