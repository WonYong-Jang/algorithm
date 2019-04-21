package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek5557 {

	static int N;
	static int[] data = new int[105];
	static int[][] dp = new int[105][25];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int target = 0, plus =0, minus = 0;
		dp[1][data[1]] = 1;
		for(int i=2; i< N; i++)
		{
			target = data[i];
			for(int j = 0; j<= 20; j++)
			{
				if(dp[i-1][j] > 0)
				{
					plus = j + target;
					minus = j - target;
					if(isRange(plus))
					{
						dp[i][plus] +=  dp[i-1][j] ;
					}
					if(isRange(minus))
					{
						dp[i][minus] +=  dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[N-1][data[N]]);
	}
	public static boolean isRange(int num)
	{
		return num >= 0 && num <= 20;
	}
}
