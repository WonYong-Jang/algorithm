package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 지름  
 */
public class baek1167 {

	static int N, target, sum;
	static int[] visit = new int[100005];
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = 1; sum = 0;
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		int dx = 0, dy =0, cost =0;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			while(true)
			{
				dy = Integer.parseInt(st.nextToken());
				if(dy == -1) break;
				cost = Integer.parseInt(st.nextToken());
				adj.get(dx).add(new Node(dy,cost));
				adj.get(dy).add(new Node(dx,cost));
			}
		}
		dfs(1,0);
		for(int i=1; i<= N; i++) visit[i] = 0;
		dfs(target, 0);
		System.out.println(sum);
	}
	public static void dfs(int cur, int cost)
	{
		visit[cur] = 1;
		if(sum < cost) {
			sum = cost;
			target = cur;
		}
		for(Node next : adj.get(cur))
		{
			if(visit[next.dx] == 1) continue;
			dfs(next.dx, cost + next.cost);
		}
	}
	static class Node {
		int dx, cost;
		Node(int a, int b) {
			dx =a; cost =b;
		}
	}
}

