package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제집 ( 위상정렬 ) 
 */
public class baek1766 {

	static int N, M;
	static int[] degree = new int[32005];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static PriorityQueue<Integer> que = new PriorityQueue<>()
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
			degree[i] = 0;
		}
		
		int dx = 0, dy =0;
		for(int i=0; i< M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			degree[dy]++;
		}
		
		for(int i=1; i<= N; i++)
		{
			if(degree[i] == 0 ) que.add(i);
		}
		solve();
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			int target = que.poll();
			
			System.out.print(target+" ");
			
			for(int next : adj.get(target))
			{	
				degree[next]--;
				if(degree[next] == 0) 
				{
					que.add(next);
				}
			}
		}
	}
}
