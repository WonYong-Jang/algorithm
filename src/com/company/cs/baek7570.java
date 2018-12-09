package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 줄 세우기 
 */
public class baek7570 {

	static int N, size;
	static int[] dp = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		size = 0;
		for(int i=1; i<= N; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			dp[num] = dp[num-1] + 1;
			size = max(size, dp[num]);
		}
		System.out.println(N - size);
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
