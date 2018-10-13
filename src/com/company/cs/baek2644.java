package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 촌수 계산 
 */
public class baek2644 {

	static int N, start, end, ans, M;
	static int[] visit = new int[105];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
			visit[i] = 0;
		}
		ans = -1;
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		int dx = 0, dy =0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		solve();
	}
	public static void solve()
	{
		que.add(new Node(start, 0));
		visit[start] = 1;
		boolean flag = false;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			
			if(n.index == end)
			{
				ans = n.cost;
				flag = true;
				break;
			}
			
			for(int next : adj.get(n.index))
			{
				if(visit[next] == 1) continue;
				que.add(new Node(next, n.cost+1));
				visit[next] = 1;
			}
		}
		if(flag) System.out.println(ans);
		else System.out.println(-1);
	}
	static class Node{
		int index, cost;
		Node(int a, int b)
		{
			index=a; cost=b;
		}
	}
}
