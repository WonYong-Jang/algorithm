package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 피보나치 함수 
 */
public class baek1003 {

	static int N, one, zero;
	static int[] dp = new int[45];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		dp[0] = 0; dp[1] = 1;
		for(int i=2; i<= 40; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N ==0) {
				zero = 1; one =0;
			}
			else {
				zero = dp[N-1]; one = dp[N];
			}
			
			System.out.println(zero+" "+one);
		}
	}
	
}






