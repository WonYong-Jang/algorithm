package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주유소 
 */
public class baek13305 {

	static int N;
	static long[] cost = new long[100005];
	static long[] dist = new long[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N-1; i++)
		{
			dist[i] = (long)Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			cost[i] = (long)Integer.parseInt(st.nextToken());
		}
		
		long minCost = 1000000005;
		long result = 0;
		for(int i=1; i<= N-1; i++)
		{
			minCost = min(minCost, cost[i]);
			result += (minCost*dist[i]);
		}
		System.out.println(result);
	}
	public static long min(long a, long b) { return a > b ? b : a; }
}
