package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 주유소 
 */
public class baek13308 {

	static int N, M;
	static int[] cost = new int[2505];
	static long[][] dp = new long[2505][2505];
	static ArrayList<Node>[] adj = new ArrayList[2505];
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			adj[i] = new ArrayList<>();
			cost[i] = Integer.parseInt(st.nextToken());
		}
		int dx=0, dy=0, dist =0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			adj[dx].add(new Node(dy, dist, 0));
			adj[dy].add(new Node(dx, dist, 0));
		}
		
		que.add(new Node(1, cost[1], 0));
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			//System.out.println(n.dx + " "+ n.cost + " " + n.sum);
			if(dp[n.dx][n.cost] == 1) continue;
			dp[n.dx][n.cost] = 1;
			
			if(n.dx == N) {
				System.out.println(n.sum);
				break;
			}
			for(Node next : adj[n.dx])
			{
				long nextSum = n.sum;
				nextSum += (next.cost*n.cost);
				que.add(new Node(next.dx, min(cost[next.dx], n.cost), nextSum ));
			}
			
		}
		
	}
	public static int min(int a, int b) { return a > b ? b : a; }
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.sum < b.sum) return -1;
			else if(a.sum > b.sum) return 1;
			else return 0;
		}
	}
	static class Node {
		int dx, cost;
		long sum;
		Node(int a, int b, long c) {
			dx = a; cost = b; sum = c;
		}
	}
}
