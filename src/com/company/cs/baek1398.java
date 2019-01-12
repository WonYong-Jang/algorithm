package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 문제 
 */
public class baek1398 {

	public static int len;
	public static long N;
	public static int INF;
	public static int[] dp = new int[100];
	public static int[] coin = {1, 10, 25};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		INF = Integer.MAX_VALUE;
		
		for(int i=1; i< 100; i++)
		{
			dp[i] = INF;
			for(int j=0; j<3; j++)
			{
				if(i - coin[j] >= 0)
				{
					dp[i] = min(dp[i], dp[i-coin[j]] + 1);
				}
			}
		}
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			long cnt = 0;
			while(N > 0)
			{
				int result = (int) (N % 100);
				cnt += dp[result];
				N /= 100;
			}
			System.out.println(cnt);
		}
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}
