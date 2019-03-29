package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제곱수의 합 
 */
public class baek1699 {

	static int N;
	static int[] dp = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i <= N; i++) dp[i] = -1;
		
		int mul = 0;
		for(int target =1; target <= N; target++)
		{
			for(int i=1; i<= target; i++)
			{
				mul = i * i;
				if(mul > target) break;
				if(dp[target] == -1) dp[target] = dp[target - mul] + 1;
				else dp[target] = min(dp[target], dp[target - mul] + 1);
			}
		}
		System.out.println(dp[N]);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}





