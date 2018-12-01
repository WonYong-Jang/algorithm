package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 수들의 합 
 */
public class baek2268 {
	
	static int N, K, start, end;
	static final int max_node = 1000005;
	static long[] tree = new long[4*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		start = 1;
		while(start < N) start *= 2;
		end = start + N - 1;
		
		int cmd =0, dx=0, dy=0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			if(cmd == 0) {
				sum(min(dx,dy), max(dx,dy));
			}
			else if(cmd == 1) modify(dx, dy);
		}
	}
	public static void sum(int dx, int dy)
	{
		int s = start + dx - 1;
		int e = start + dy - 1;
		long sum = 0;
		
		while(s <= e)
		{
			if(s % 2 != 0) sum += tree[s];
			s =  (s+1) / 2;
			
			if(e % 2 == 0) sum += tree[e];
			e = (e-1) / 2;
		}
		System.out.println(sum);
	}
	public static void modify(int dx, int dy)
	{
		int s = start + dx - 1;
		tree[s] = dy;
		
		while(s > 1)
		{
			s /= 2;
			int left = s*2;
			int right = (s*2)+1;
			tree[s] = tree[left] + tree[right];
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}




