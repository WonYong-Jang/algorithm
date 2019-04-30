package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 본대 산책 
 */
public class baek12849 {

	static int N;
	static int mod = 1000000007;
	static long[][] dp = new long[10][100005];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<= 7; i++)
		{
			adj.add(new ArrayList<>());
			for(int j = 0; j<= 100000; j++)
			{
				dp[i][j] = -1;
			}
		}
		adj.get(0).add(1); adj.get(1).add(0);
		adj.get(0).add(2); adj.get(2).add(0);
		adj.get(1).add(2); adj.get(2).add(1);
		adj.get(1).add(3); adj.get(3).add(1);
		adj.get(2).add(3); adj.get(3).add(2);
		adj.get(2).add(5); adj.get(5).add(2);
		adj.get(3).add(4); adj.get(4).add(3);
		adj.get(3).add(5); adj.get(5).add(3);
		adj.get(4).add(5); adj.get(5).add(4);
		adj.get(4).add(6); adj.get(6).add(4);
		adj.get(6).add(7); adj.get(7).add(6);
		adj.get(5).add(7); adj.get(7).add(5);
		
		long result = solve(0, 0);
		System.out.println(result);
	}
	public static long solve(int cur, int time)
	{
		long sum = 0;
		if(time == N)
		{
			if(cur == 0) return 1;
			else return 0;
		}
		else if(dp[cur][time] != -1) return dp[cur][time];
		else
		{
			//System.out.println(cur + " " + time);
			for(int next : adj.get(cur))
			{
				sum += ( solve(next, time+1) % mod );
				sum %= mod;
			}
			return dp[cur][time] = sum;
		}
	}
}



