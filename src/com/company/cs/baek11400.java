package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 단절선 
 */ 
public class baek11400 {

	static int N, K, number;
	static int[] order = new int[100005];
	static ArrayList<Node> result = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		number = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		int dx =0, dy=0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		
		for(int i=1; i<= N; i++)
		{
			if(order[i] > 0) continue;
			dfs(i, 0);
		}
		
		Collections.sort(result, new mySort());
		bw.write(result.size()+"\n");
		for(Node next : result)
		{
			bw.write(next.dx+" "+next.dy+"\n");
		}
		bw.flush();
	}
	public static int dfs(int cur, int p)
	{
		order[cur] = ++number;
		int ret = order[cur];
		
		for(int next : adj.get(cur))
		{
			if(next == p) continue;
			
			if(order[next] > 0)
			{
				ret = min(ret, order[next]);
				continue;
			}
			
			int prev = dfs(next, cur);
			
			if(prev > order[cur])
			{
				result.add(new Node(min(cur, next), max(cur, next)));
			}
			
			ret = min(prev, ret);
		}
		
		return ret;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	static class mySort implements Comparator<Node>{

		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else {
				if(a.dy < b.dy) return -1;
				else if(a.dy > b.dy) return 1;
				else return 0;
			}
		}
		
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			dx=a; dy=b;
		}
	}
}
