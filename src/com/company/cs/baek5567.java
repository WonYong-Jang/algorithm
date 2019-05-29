package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 결혼식 
 */
public class baek5567 {

	static int N, M, result;
	static int[] visit = new int[505];
	static Queue<Node> que = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		int dx =0, dy =0;
		for(int i=1; i<=M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		solve();
		System.out.println(result);
	}
	public static void solve()
	{
		visit[1] = 1;
		que.add(new Node(1, 0));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			int cur = n.cur;
			int cnt = n.cnt;
			
			if(n.cnt > 2) break;
			
			if(cur != 1) {
				
				result++;
			}
			
			for(int next : adj.get(cur))
			{
				if(visit[next] == 1) continue;
				visit[next] = 1;
				que.add(new Node(next, cnt+1));
			}
		}
	}
	static class Node {
		int cur, cnt;
		Node(int a, int b) {
			cur=a; cnt=b;
		}
	}
}
