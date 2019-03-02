package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek1197 {

	static int V, E, cnt;
	static long ans;
	static int[] par = new int[10005];
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ans = 0; cnt = 0;
		
		for(int i=1; i<= V; i++) par[i] = i;
		
		int dx=0, dy=0;
		long cost = 0;
		for(int i=1; i<= E; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Long.parseLong(st.nextToken());
			que.add(new Node(dx, dy, cost));
		}
		while(!que.isEmpty())
		{
			if(cnt == V-1) break;
			Node n = que.poll();
			int ap = find(n.dx);
			int bp = find(n.dy);
			
			if(ap != bp)
			{
				union(ap, bp);
				cnt++;
				ans += n.cost;
			}
		}
		System.out.println(ans);
	}
	public static void union(int a, int b)
	{
		int ap = find(a);
		int bp = find(b);
		par[ap] = bp;
	}
	public static int find(int a)
	{
		if(par[a] == a) return a;
		else return par[a] = find(par[a]);
	}
	static class mySort implements Comparator<Node>{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
	}
	static class Node {
		int dx, dy;
		long cost;
		Node(int a, int b, long c) {
			dx=a; dy=b; cost=c;
		}
	}
}
