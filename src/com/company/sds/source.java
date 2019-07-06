package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class source {

	static int N, M, L;
	static int[] dp = new int[1000000005];
	static int[] data = new int[1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
	
		int value = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			value = Integer.parseInt(st.nextToken());
			data[i] = value;
		}
		data[N+1] = L;
		
		int num = 0;
		for(int i=1; i<= N+1; i++)
		{
			num = data[i] - M;
			if(num <= 0) num =0;
			dp[data[i]] = max(dp[num] + 1, dp[data[i-1]]);
		}
		System.out.println(dp[data[N+1]]);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}




