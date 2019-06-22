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

public class source {

	static final int max_level = 17;
	static int N, M, K;
	static int[] set = new int[100005];
	static int[][] par = new int[100005][20];
	static int[][] maxNum = new int[100005][20];
	static int[] dep = new int[100005];
	static ArrayList<ArrayList<Point>> adj = new ArrayList<>();
	static Queue<Point> tmpQue = new LinkedList<>();
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	static Queue<Node> resultQue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++) {
			set[i] = i;
			adj.add(new ArrayList<>());
			dep[i] = -1;
			for(int j = 0; j <= max_level; j++)
			{
				maxNum[i][j] = Integer.MIN_VALUE;
			}
		}
		
		int dx =0, dy =0;
		long cost = 0, total = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Long.parseLong(st.nextToken());
			total += cost;
			que.add(new Node(dx,dy,-cost));
		}
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Long.parseLong(st.nextToken());
			que.add(new Node(dx,dy,cost));
		}
		
		int cnt = 0, root = N;
		long result = total;
		while(!que.isEmpty())
		{	
			if(cnt == N -1) break;
			
			Node n = que.poll();
			
			int ap = find(n.dx);
			int bp = find(n.dy);
			if(ap != bp)
			{
				union(ap,bp);
				adj.get(n.dx).add(new Point(n.dy,n.cost));
				adj.get(n.dy).add(new Point(n.dx,n.cost));
				root = min(root, min(n.dx, n.dy));
				result += n.cost;
				cnt++;
			}
			else resultQue.add(n);
		}
		
		dep[1] = 0;
		tmpQue.add(new Point(root,0));
		while(!tmpQue.isEmpty())
		{
			Point n = tmpQue.poll();
			
			for(Point next : adj.get(n.dx))
			{
				if(dep[next.dx] == -1)
				{
					dep[next.dx] = dep[n.dx] + 1;
					maxNum[next.dx][0] = (int)next.cost;
					par[next.dx][0] = n.dx;
					tmpQue.add(next);
				}
			}
		}
		
		for(int k=1; k<= max_level; k++)
		{
			for(int i=1; i<= N; i++)
			{
				int tmp = par[i][k-1];
				par[i][k] = par[tmp][k-1];
				
				maxNum[i][k] = max(maxNum[i][k-1], maxNum[tmp][k-1]);
			}
		}
		int flag = 0;
		
		resultQue.addAll(que);
		total = result;
		while(!resultQue.isEmpty())
		{
			Node n = resultQue.poll();
			
			long ans = lca(n.dx, n.dy);
			if(total - ans + n.cost == result)
			{
				flag = 1;
				break;
			}
			
		}
		
		if(flag == 0) bw.write(result+" unique\n");
		else bw.write(result+" not unique\n");
		bw.flush();
	}
	public static long lca(int dx, int dy)
	{
		int maxValue = Integer.MIN_VALUE;
		if(dep[dx] != dep[dy])
		{
			if(dep[dx] > dep[dy])
			{
				int tmp = dx;
				dx = dy;
				dy = tmp;
			}
			
			for(int i=max_level; i>= 0; i--)
			{
				if(dep[dx] <= dep[par[dy][i]])
				{
					maxValue = max(maxValue, maxNum[dy][i]);
					dy = par[dy][i];
				}
			}
		}
		int lca = dx;
		
		if(dx != dy)
		{
			for(int i= max_level; i>=0; i--)
			{
				if(par[dx][i] != par[dy][i])
				{
					maxValue = max(maxValue, max(maxNum[dx][i], maxNum[dy][i]));
					dx = par[dx][i];
					dy = par[dy][i];
				}
				lca = par[dx][i];
			}
		}
		if(dx != lca)
		{
			maxValue = max(maxValue, max(maxNum[dx][0], maxNum[dy][0]));
		}
		return (long)maxValue;
	}
	public static void union(int a, int b)
	{
		int ap = find(a);
		int bp = find(b);
		set[ap] = bp;
	}
	public static int find(int a)
	{
		if(set[a] == a) return a;
		else return set[a] = find(set[a]);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int min(int a, int b) { return a > b ? b : a; }
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
	}
	static class Point {
		int dx;
		long cost;
		Point(int a, long b) {
			dx=a; cost=b;
		}
	}
	static class Node {
		int dx, dy;
		long cost;
		Node(int a, int b, long c) {
			dx=a; dy=b;cost=c;
		}
	}
}








