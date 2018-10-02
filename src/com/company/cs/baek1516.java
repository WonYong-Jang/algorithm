package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 게임 개발 
 */
public class baek1516 {

	static int N;
	static int[] cost = new int[505];
	static int[] ans = new int[505];
	static int[] degree = new int[505];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			cost[i] = num; // 비용 
			while(st.hasMoreTokens())
			{
				int dy = Integer.parseInt(st.nextToken());
				if(dy == -1) break; // 끝 
				adj.get(dy).add(i); // 인접 리스트 
				degree[i]++; 
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			if(degree[i] == 0) 
			{
				que.add(i);
				ans[i] = cost[i];
			}
		}
		
		solve();
		for(int i=1; i<= N; i++)
		{
			System.out.println(ans[i]+" ");
		}
		
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			int n = que.poll();
			
			for(int next : adj.get(n))
			{
				if(ans[next] < ans[n] + cost[next]) // 선행 건물이 다 지어져야 하기때문에 최대값 갱신 
				{
					ans[next] = ans[n] + cost[next];
				}
				degree[next]--;
				if(degree[next] == 0)
				{
					que.add(next);
				}
			}
		}
	}
}
