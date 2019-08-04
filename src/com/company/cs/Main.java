package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	static int[] par = new int[5005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++) par[i] = i;
		
		int dx = 0, dy = 0, cost = 0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			que.add(new Node(dx,dy,cost));
		}
		
		int sum = 0;
		int cnt = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			if(cnt == N-1) break;
			int ap = find(n.dx);
			int bp = find(n.dy);
			if(ap != bp)
			{
				union(ap, bp);
				cnt++;
				sum += n.cost;
			}
		}
		System.out.println(sum);
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
			dx = a; dy = b; cost = c;
		}
	}
}











