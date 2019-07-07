package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class koitp443450 {

	static int N, M, L;
	static int[] data = new int[1005];
	static int[] dp = new int[1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int num = 0;
		for(int i=1;i <= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			data[i] = num;
		}
		
		int result = 0;
		for(int i= 1; i<= N; i++)
		{
			dp[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++)
			{
				if(data[i] - data[j] <= M)
				{
					dp[i] = min(dp[i], dp[j]+1);
				}
			}
			if(data[i]+M >= L)
			{
				result = dp[i];
				break;
			}
		}
		
		System.out.println(result);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}

