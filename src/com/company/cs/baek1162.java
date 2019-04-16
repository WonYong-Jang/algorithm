package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도로 포장 
 */
public class baek1162 {

	static final long INF = 50005000000L;
	static int N, M, K;
	static long[][] dis = new long[10001][21];
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
			for(int j=0; j<= K; j++)
			{
				dis[i][j] = INF;
			}
		}
		int dx =0, dy =0;
		long cost =0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Long.parseLong(st.nextToken());
			adj.get(dx).add(new Node(dy, cost, 0));
			adj.get(dy).add(new Node(dx, cost, 0));
		}
		
		solve();
		
		long result = INF;
		for(int i=0; i<= K; i++)
		{
			result = min(result, dis[N][i]);
		}
		System.out.println(result);
	}
	public static void solve()
	{
		que.add(new Node(1,0,0));
		dis[1][0] = 0;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			//if(n.cost > dis[n.dx][n.cnt]) continue;
			
			int count = n.cnt;
			
			for(Node next : adj.get(n.dx))
			{
				if(dis[next.dx][count] > dis[n.dx][count] + next.cost)
				{
					dis[next.dx][count] = dis[n.dx][count] + next.cost;
					que.add(new Node(next.dx, dis[next.dx][count], count));
				}
				if((count+1 <= K) && (dis[next.dx][count+1] > dis[n.dx][count]))
				{
					dis[next.dx][count+1] = dis[n.dx][count];
					que.add(new Node(next.dx, dis[next.dx][count+1], count+1));
				}
			}
		}
	}
	static class Node {
		int dx, cnt;
		long cost;
		Node(int a, long b, int c) {
			dx=a; cost=b; cnt=c;
		}
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
		
	}
	public static long min(long a, long b) { return a > b ? b : a; }
}





