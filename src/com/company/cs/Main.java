package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[] data = new long[10005];
	static long[] dp = new long[10005];
	static final long mod = 1000000007;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= N; i++)
			{
				data[i] = Long.parseLong(st.nextToken());
				dp[i] = 0;
			}
			dp[0]=0;
			dp[1] = data[1];
			for(int i=2; i<= N; i++)
			{
				dp[i] = (dp[i-1]*(data[i]-data[i-1]+1))%mod;
			}
			
			for(int i=1; i<= N; i++)
			{
				System.out.print(dp[i] + " ");
			}
			System.out.println();
			
		}
	}
}
/**
1
3
1 2 2

 */
