package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek11441 {

	static int N, M;
	static int[] dp = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			dp[i] = Integer.parseInt(st.nextToken());
			dp[i] += dp[i-1];
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int start = 0, end = 0, ans = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			ans = dp[end] - dp[start-1];
			bw.write(ans+"\n");
		}
		bw.flush();
	}
	
}







