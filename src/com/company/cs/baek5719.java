package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 거의 최단 경로 
 */
public class baek5719 {

	static final int INF = 1000 *550;
	static int N, M, start, end, minDis;
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	static ArrayList<ArrayList<Node>> rAdj = new ArrayList<ArrayList<Node>>();
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	static Queue<Node> del = new LinkedList<Node>();
	static int[] dis = new int[505];
	static int[][] map = new int[505][505];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N ==0 && M == 0) break;
			minDis = 0;
			adj.clear(); rAdj.clear();
			for(int i=0; i< N; i++)
			{
				adj.add(new ArrayList<>());
				rAdj.add(new ArrayList<>());
				dis[i] = INF;
				for(int j=0; j< N; j++) {
					map[i][j] = 0;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			int dx=0, dy=0, cost=0;
			for(int i=1; i<= M; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
				adj.get(dx).add(new Node(dy,cost));
				rAdj.get(dy).add(new Node(dx,cost));
			}
			
			dijkstra(start, end);
			solve(start, end);
			
			for(int i=0; i< N; i++) dis[i] = INF;
			
			dijkstra(start, end);
			
			if(minDis == INF ) bw.write("-1\n");
			else bw.write(minDis+"\n");
			bw.flush();
		}
	}
	public static void dijkstra(int s, int e)
	{
		dis[s] = 0;
		que.clear();
		que.add(new Node(s,0));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.cost > dis[n.dx]) continue;
			
			for(Node next : adj.get(n.dx))
			{
				if(map[n.dx][next.dx] == -1) continue;
				if(dis[next.dx] > next.cost + dis[n.dx])
				{
					dis[next.dx] = next.cost + dis[n.dx];
					que.add(new Node(next.dx, dis[next.dx]));
				}
			}
		}
		minDis = dis[e];
	}
	public static void solve(int s, int e) // 최단거리로 가는 정점 지워주기 
	{
		del.clear();
		del.add(new Node(e, minDis));
		while(!del.isEmpty())
		{
			Node n = del.poll();
			
			for(Node next : rAdj.get(n.dx))
			{
				if( next.dx == e) continue;
				if(n.cost == next.cost + dis[next.dx])
				{
					del.add(new Node(next.dx, dis[next.dx]));
					map[next.dx][n.dx] = -1;
				}
			}
		}
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
		int dx, cost;
		Node(int a , int b) {
			dx=a; cost=b;
		}
	}
}
