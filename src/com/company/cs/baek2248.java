package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 이진수 찾기
 * 고려 사항
 * 사전순으로 생각하게 되면 0이 1을 채우는 수보다 앞의 수
 * 따라서 해당 자릿수를 채우기 전에 dp[n-1][m] 을 확인하는데
 * 즉 그 전 자릿수의 경우의 수를 확인
 * k <= dp[n-1][m] 이라면 이번에 채울 수는 0이고
 * 아닐 때는 1을 채워줌 
 */
public class baek2248 {

	static int N, L;
	static long I;
	static String result;
	static long[][] dp = new long[50][50];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		I = Long.parseLong(st.nextToken());
		for(int i=0; i<= N; i ++)
		{
			dp[i][0] = 1;
			dp[0][i] = 1;
		}
		result = "";
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= L; j++)
			{
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		solve(N,L,I,0);
		System.out.println(result);
	}
	public static void solve(int n, int m, long k, int p)
	{
		if(n ==0) return;
		if(m == 0)
		{
			for(int i=0; i< n; i++) result += '0';
			return;
		}
		
		long target = dp[n-1][m];
		
		if(target < k) {
			result += '1';
			solve(n-1, m-1, k-target, p+1);
		}
		else {
			result += '0';
			solve(n-1, m, k, p+1);
		}
	}
}
