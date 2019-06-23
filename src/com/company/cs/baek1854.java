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

/**
 * K 번째 최단 경로 
 */
public class baek1854 {

	static int N, M, K;
	static int[] dis = new int[1005];
	static ArrayList<Node>[] adj = new ArrayList[1005];
	static PriorityQueue<Integer>[] dist = new PriorityQueue[1005];
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
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
			dist[i] = new PriorityQueue<>(new desc());
		}
		
		int dx = 0 ,dy =0, cost = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			adj[dx].add(new Node(dy,cost));
		}
		
		que.add(new Node(1,0));
		dist[1].add(0);
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(Node next : adj[n.dx])
			{
				if(dist[next.dx].size() < K)
				{
					dist[next.dx].add(n.cost + next.cost);
					que.add(new Node(next.dx, n.cost + next.cost));
				}
				else
				{
					if(dist[next.dx].peek() > next.cost + n.cost)
					{
						dist[next.dx].poll();
						dist[next.dx].add(next.cost + n.cost);
						que.add(new Node(next.dx, next.cost + n.cost));
					}
				}
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			if(dist[i].size() == K) bw.write(dist[i].peek()+"\n");
			else bw.write(-1+"\n");
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
	static class desc implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			// TODO Auto-generated method stub
			if(a < b) return 1;
			else if(a > b) return -1;
			else return 0;
		}
	}
	static class Node {
		int dx, cost;
		Node(int a, int b) {
			dx=a; cost=b;
		}
	}
}
