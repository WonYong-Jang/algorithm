package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int max_node = 100001;
	static final int max_level = 17;
	static int[][] par = new int[max_node][20];
	static int[][] minNum = new int[max_node][20];
	static int[][] maxNum = new int[max_node][20];
	static int[] depth = new int[max_node];
	static int N, M;
	static Queue<Node> que = new LinkedList<>();
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx =0, dy =0, cost = 0;
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
			depth[i] = -1;
		}
		
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			adj.get(dx).add(new Node(dy,cost));
			adj.get(dy).add(new Node(dx,cost));
		}
		
		que.add(new Node(1,0));
		depth[1] = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(Node next : adj.get(n.dx))
			{
				if(depth[next.dx] == -1)
				{
					depth[next.dx] = depth[n.dx] + 1;
					par[next.dx][0] = n.dx;
					minNum[next.dx][0] = next.cost;
					maxNum[next.dx][0] = next.cost;
					que.add(next);
				}
			}
		}
		
		System.out.println();
		int tmp = 0;
		for(int i=1; i<= max_level; i++)
		{
			for(int cur=2; cur<= N; cur++)
			{
				tmp = par[cur][i-1];
				par[cur][i] = par[tmp][i-1];
			}
		}
		
		
		for(int i=1; i<= max_level; i++)
		{
			for(int cur=2; cur <= N; cur++)
			{
				tmp = par[cur][i-1];
				maxNum[cur][i] = max(maxNum[cur][i-1], maxNum[tmp][i-1]);
				minNum[cur][i] = min(minNum[cur][i-1], minNum[tmp][i-1]);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			int minValue = 1000005, maxValue = -1;
			if(depth[dx] != depth[dy])
			{
				if(depth[dx] > depth[dy])
				{
					tmp = dx;
					dx = dy;
					dy = tmp;
				}
				for(int k= max_level; k>= 0; k--)
				{
					if(depth[dx] <= depth[par[dy][k]])
					{
						minValue = min(minNum[dy][k], minValue);
						maxValue = max(maxNum[dy][k], maxValue);
						dy = par[dy][k];
					}
				}
			}
			int lca = dx;
			
			if(dx != dy)
			{
				for(int k = max_level; k >= 0; k--)
				{
					if(par[dx][k] != par[dy][k])
					{
						minValue = min(minNum[dy][k], minValue);
						maxValue = max(maxNum[dy][k], maxValue);
						
						minValue = min(minNum[dx][k], minValue);
						maxValue = max(maxNum[dx][k], maxValue);
						dx = par[dx][k];
						dy = par[dy][k];
						
					}
					lca = par[dx][k];
				}
			}
			
			if(dx != lca)
			{
				minValue = min(minNum[dy][0], minValue);
				maxValue = max(maxNum[dy][0], maxValue);
				
				minValue = min(minNum[dx][0], minValue);
				maxValue = max(maxNum[dx][0], maxValue);
			}
			
			System.out.println(minValue+" "+maxValue);
		}
	}
	static class Node {
		int dx, cost;
		Node(int a, int b){
			dx=a; cost=b;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int min(int a, int b) { return a > b ? b : a; }
}





