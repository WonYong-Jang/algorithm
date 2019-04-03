package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 극장 좌석 
 */
public class baek2302 {

	static int N, M;
	static int[] dp = new int[50];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp[0] = 1;
		dp[1] = 1; dp[2] = 2;
		for(int i=2; i<= N; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int vip = 0, result = 1, cur =0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			vip = Integer.parseInt(st.nextToken());
			result *= dp[vip - cur - 1];
			cur = vip;
		}
		result *= dp[N - cur];
		System.out.println(result);
	}

}
