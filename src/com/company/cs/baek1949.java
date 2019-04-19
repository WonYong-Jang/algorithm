package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 우수 마을 
 */
public class baek1949 {

	static int N;
	static int[] data = new int[10005];
	static int[][] dp = new int[10005][2];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<2; j++)
			{
				dp[i][j] = -1;
			}
		}
		int dx = 0, dy =0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		System.out.println(max(solve(0 , 1,0), solve(0 , 1,1)));
	}
	public static int solve(int p, int cur, int type)
	{
		if(dp[cur][type] != -1) return dp[cur][type];
		
		int ret = 0, left = 0, right = 0;
		if(type == 1) ret = data[cur];
		for(int next : adj.get(cur))
		{
			if(next == p) continue;
			if(type == 1)
			{
				ret +=  solve(cur, next, 0);
			}
			else
			{
				left = solve(cur, next, 1);
				right = solve(cur, next, 0);
				ret += max(left, right);
			}
		}
		return dp[cur][type] = ret;
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}








