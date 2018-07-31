package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 네트워크 연결 ( 최소 신장 트리 ( Minimum Spanning Tree ) MST  / 크루스칼 알고리즘 ! 
 * 무향 그래프 G가 순환이 없는 연결 그래프 이면 G는 트리 이다. 
 * Union, find 이용 ! 
 */
public class baek1922 {
	
	static int N, M, result;
	static int[] parent = new int[1001];
	static PriorityQueue<Node> que = new PriorityQueue<>(new Mysort());
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int a,b,cost;
		result =0;
		for(int i=1; i<= N; i++)
		{
			parent[i] = i;
		}
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			que.add(new Node(a ,b ,cost)); // 우선순위 큐 
		}
		solve();
		System.out.println(result);
	}
	public static void solve()
	{
		int edge =0; // tree 조건인 간선의 갯수 v-1 개 인지 확인 
		while(!que.isEmpty())
		{
			Node n = que.poll();
			int ap = find(n.dx);
			int bp = find(n.dy);
			
			if(ap == bp) continue; // 이미 같은 집합이므로 
			
			else {
				union(n.dx, n.dy);
				result += n.cost;
				edge++;
			}
			
			if(edge == N -1) break; // 트리를 만들어야 하므로 
		}
	}
	public static void union(int a, int b)
	{
		int ap = find(a);
		int bp = find(b);
		parent[ap] = bp;
	}
	public static int find(int a)
	{
		if(parent[a] == a) return a; // 그룹을 가르키는 대표값 찾음
		else return parent[a] = find(parent[a]);
	}
	static class Mysort implements Comparator<Node> {

		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
	}
	static class Node{
		int dx, dy, cost;
		Node(int x, int y, int z) {
			dx = x; dy = y; cost =z;
		}
	}
}
	