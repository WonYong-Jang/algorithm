package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 암호 코드 
 */
public class baek2011 {

	static int mod = 1000000;
	static int N;
	static int[] data = new int[5005];
	static long[] dp = new long[5005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = str.length();
		for(int i=1; i<= N; i++)
		{
			data[i] = str.charAt(i-1) - '0';
		}
		if(N == 1 && data[1] == 0) System.out.println(0);
		else
		{
			dp[0] = 1;
			int num = 0, target =0;
			for(int i=1; i<= N; i++)
			{
				num = data[i];
				if(num > 0)
				{
					dp[i] = (dp[i] + dp[i-1]) % mod;
				}
				target = data[i-1]*10 + data[i];
				if(target >= 1 && target <= 26 && data[i-1] != 0)
				{
					dp[i] = (dp[i] + dp[i-2]) % mod;
				}
			}
			
			System.out.println(dp[N]);
		}
		
		
	}

}
