package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek13907 {

	static final long INF = 987654321987654321l;
	static int N, M, K, start, end;
	static long[][] dis = new long[1005][1005];
	static ArrayList<Node>[] adj = new ArrayList[1005];
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	static ArrayList<Node> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			adj[i] = new ArrayList<>();
			for(int j=0; j<= N; j++)
			{
				dis[i][j] = INF;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int dx =0, dy=0, cost = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			adj[dx].add(new Node(dy, cost, 0));
			adj[dy].add(new Node(dx, cost, 0));
		}
		
		dis[start][0] = 0;
		que.add(new Node(start,0,0));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == end || n.cnt >= 1000) continue;
			
			int find = 0;
			for(int i=0; i< n.cnt; i++)
			{
				if(dis[n.dx][i] < n.cost) {
					find = 1;
					break;
				}
			}
			
			if(n.cost > dis[n.dx][n.cnt] || find == 1) continue;
			
			int nextCnt = n.cnt + 1;
			for(Node next : adj[n.dx])
			{
				if(dis[next.dx][nextCnt] > dis[n.dx][n.cnt] + next.cost )
				{
					dis[next.dx][nextCnt] = dis[n.dx][n.cnt] + next.cost;
					que.add(new Node(next.dx, dis[next.dx][nextCnt], nextCnt));
				}
			}
		}
		int num =0;
		long result = INF , tmp = 0;
		for(int k=1; k<= N; k++)
		{
			if(dis[end][k] == INF) continue;
			arr.add(new Node(end, dis[end][k], k));
			result = min(result, dis[end][k]);
		}
		bw.write(result+"\n");
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			
			result = INF;
			
			for(int k=0; k < arr.size(); k++)
			{
				Node n = arr.get(k);
				tmp = (long)(n.cnt*num) + n.cost;
				arr.get(k).cost = tmp;
				result = min(result, tmp);
			}
			
			bw.write(result+"\n");
		}
		bw.flush();
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
		int dx, cnt;
		long cost;
		Node(int a, long b, int c) { 
			dx=a; cost=b; cnt=c;
		}
	}
	public static long min(long a, long b) { return a > b ? b : a; }
}
