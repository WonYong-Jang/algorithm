package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1309 {

	static final int mod = 9901;
	static int N;
	static int[][] dp = new int[100005][3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// dp[n][] : n 번째 줄 사자 배치하는 경우의 수 3가지 
		// 0 : 사자 배치 안하는 경우 
		// 1 : 왼쪽에 사자 배치 하는 경우
		// 2: 오른쪽에 사자 배치하는 경우 
		dp[1][0] = 1; dp[1][1] =1; dp[1][2] = 1;
		
		for(int i=2; i<= N; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
		}
		
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % mod);
	}

}
