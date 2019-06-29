package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek14621 {

	static int N, M;
	static char[] data = new char[1005];
	static int[] par = new int[1005];
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
			String str = st.nextToken();
			data[i] = str.charAt(0);
			par[i] = i;
		}
		int dx =0, dy =0, cost =0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			que.add(new Node(dx,dy,cost));
		}
		
		int cnt = 0, sum =0;
		while(!que.isEmpty())
		{
			if(cnt == N-1) break;
			Node n = que.poll();
			
			int ap = find(n.dx);
			int bp = find(n.dy);
			if(ap != bp && data[n.dx] != data[n.dy])
			{
				sum += n.cost;
				union(ap,bp);
				cnt++;
			}
			
		}
		
		if(cnt == N-1) System.out.println(sum);
		else System.out.println(-1);
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
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
	}
	static class Node {
		int dx, dy, cost;
		Node(int a, int b, int c) {
			dx=a; dy=b; cost=c;
		}
	}
}
