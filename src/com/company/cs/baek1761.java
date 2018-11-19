package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 정점들의 거리 
 */
public class baek1761 {

	static final int max_node = 40005;
	static int N, M, max_level;
	static int[][] parent = new int[max_node][20];
	static int[] dist = new int[max_node]; 
	static int[] depth = new int[max_node];
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		max_level=0;
		
		int dx =0, dy=0, cost =0, result = 1;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			adj.get(dx).add(new Node(dy, cost));
			adj.get(dy).add(new Node(dx, cost));
		}
		
		while(result < max_node) {
			result *= 2;
			max_level++;
		}
		
		depth[0] = -1;
		dfs(1,0,0);
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			
			int fdx = dx, fdy = dy; // 처음 값 저장 
			
			if(depth[dx] != depth[dy])
			{
				if(depth[dx] > depth[dy]) {
					int tmp = dx;
					dx = dy;
					dy = tmp;
				}
				
				for(int k = max_level; k >= 0; k--)
				{
					if(depth[dx] <= depth[parent[dy][k]])
						dy = parent[dy][k];
				}
			}
			int lca = dx;
			
			if(dx != dy)
			{
				for(int k = max_level; k >= 0; k--)
				{
					if(parent[dx][k] != parent[dy][k])
					{
						dx = parent[dx][k];
						dy = parent[dy][k];
					}
					lca = parent[dx][k];
				}
			}
			bw.write(dist[fdx] + dist[fdy] - 2*dist[lca]+"\n");
		}
		bw.flush();
	}
	public static void dfs(int cur, int p, int cost)
	{
		depth[cur] = depth[p] + 1;
		parent[cur][0] = p;
		
		if(cur != 1) {
			dist[cur] = dist[p] + cost;
		}
		
		for(int i=1; i<= max_level; i++)
		{
			int tmp = parent[cur][i-1];
			parent[cur][i] = parent[tmp][i-1];
		}
		
		for(Node next : adj.get(cur))
		{
			if(next.dx != p)
			{
				dfs(next.dx, cur, next.cost);
			}
		}
	}
	public static void print()
	{
		for(int i=1; i<= N; i++)
		{
			System.out.print(dist[i]+" ");
		}
		System.out.println();
	}
	static class Node {
		int dx, cost;
		Node(int a, int b) {
			dx = a; cost = b;
		}
	}
}
