package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 음악 프로그램 ( 위상정렬 + 사이클 확인 가능 !  ) 
 */
public class baek2623 {

	static boolean flag;
	static int N, M;
	static int[] degree = new int[1005];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> temp = new ArrayList<>();
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		flag = false;
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		int len = 0, dx =0, dy = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			for(int k=1; k < len; k++)
			{
				dy = Integer.parseInt(st.nextToken());
				adj.get(dx).add(dy);
				degree[dy]++;
				dx = dy;
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			if(degree[i] == 0) que.add(i); 
		}
		solve();
		if(!flag)
		{
			for(int i=0; i< temp.size(); i++)
			{
				System.out.println(temp.get(i));
			}
		}
		
	}
	public static void solve()
	{
		for(int i=0; i< N; i++)
		{
			if(que.isEmpty())
			{
				System.out.println(0);
				flag = true;
				return;
			}
			
			int n = que.poll();
			
			temp.add(n);
			
			for(int next : adj.get(n))
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
