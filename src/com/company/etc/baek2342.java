package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * Dance Dance Revolution
 */
public class baek2342 {
	
	static int N;
	static int[][][] dp = new int[5][5][100005]; // left, right, node 
	static int[] data = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = 0;
		int num =0;
		while(st.hasMoreTokens())
		{
			num = Integer.parseInt(st.nextToken());
			if(num == 0) break;
			N++;
			data[N] = num;
		}
		for(int i=0; i < 5; i++)
		{
			for(int j=0; j < 5; j++)
			{
				for(int k=1; k<= N; k++)
				{
					dp[i][j][k] = -1;
				}
			}
		}
		
		System.out.println(solve(0,0,1));
	}
	public static int solve(int left, int right, int target)
	{
		if(target > N) return 0;
		else if(dp[left][right][target] != -1) return dp[left][right][target];
		int l = solve(data[target], right, target+1) + check(left, data[target]);
		int r = solve(left, data[target], target+1) + check(right, data[target]);
		
		return dp[left][right][target] = min(l,r);
	}
	public static int check(int from, int to)
	{
		if(from == 0) return 2;
		else if(from == to) return 1;
		else if(abs(to,from) == 2) return 4;
		else return 3;
	}
	public static int abs(int a, int b) 
	{ 
		return a > b ? a - b : b - a;
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}







