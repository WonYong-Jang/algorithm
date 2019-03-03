package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/** 
 * 두번째로 작은 스패닝 트리 ( 미완 ) 
 */
public class baek1626 {

	static final int max_level = 16;
	static int V, E, cnt;
	static long ans;
	static int[] set = new int[50005];
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort()); // mst 만들기 위한 큐 
	static Queue<Node> result = new LinkedList<>(); // 두번째 mst 만들기 위한 큐 
	static Queue<Pair> bfs = new LinkedList<>(); // lca 준비 큐 
	static ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>(); // 인접 리스트 
	static int[] depth = new int[50005];
	static int[][] par = new int[50005][20];
	static int[][] maxNum = new int[50005][20];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ans = 0; cnt = 0;
		que.clear(); result.clear(); adj.clear(); bfs.clear();
		for(int i=0; i<= V; i++) {
			set[i] = i;
			adj.add(new ArrayList<>());
			depth[i] = -1;
		} 
		int dx=0, dy=0,cost = 0;
		for(int i=1; i<= E; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			que.add(new Node(dx, dy, cost));
		}
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(cnt == V-1) {
				result.add(n);
				continue;
			}
			
			int ap = find(n.dx);
			int bp = find(n.dy);
			
			if(ap != bp)
			{
				union(ap, bp);
				cnt++;
				ans += (long)n.cost;
				adj.get(n.dx).add(new Pair(n.dy, n.cost));
				adj.get(n.dy).add(new Pair(n.dx, n.cost));
			}
			else result.add(n);
		}
		depth[0] = 0;
		depth[1] = 0; par[1][0] = 0;
		bfs.add(new Pair(1,0));
		while(!bfs.isEmpty())
		{
			Pair n = bfs.poll();
			
			for(Pair next : adj.get(n.dx))
			{
				if(depth[next.dx] == -1)
				{
					depth[next.dx] = depth[n.dx] + 1;
					par[next.dx][0] = n.dx;
					maxNum[next.dx][0] = next.cost;
					bfs.add(next);
				}
			}
		}
		for(int h=1; h <= max_level; h++)
		{
			for(int cur=2; cur <= V; cur++)
			{
				int tmp = par[cur][h-1];
				par[cur][h] = par[tmp][h-1];
				maxNum[cur][h] = max(maxNum[cur][h-1], maxNum[tmp][h-1]);
			}
		}
		
		int second = 0, ret = Integer.MAX_VALUE;
		while(!result.isEmpty())
		{
			Node n = result.poll();
			
			int target = query(n.dx, n.dy, n.cost); // lca
			if(n.cost <= target || target == 0) continue;
			second = n.cost - target;
			ret = min(ret, second);
		}
		if(ret <= 0 || ret == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans+ret);
	}
	public static int query(int s, int e, int maxValue)
	{
		int dx = s, dy = e;
		int value = 0;
		
		if(depth[dx] != depth[dy])
		{
			if(depth[dx] > depth[dy])
			{
				int tmp = dx;
				dx = dy;
				dy = tmp;
			}
			for(int k= max_level; k >=0 ; k--)
			{
				if(depth[dx] <= depth[par[dy][k]])
				{
					if(maxNum[dy][k] < maxValue)
					{
						value = max(value, maxNum[dy][k]);
					}
					dy = par[dy][k];
				}
			}
		}
		int lca = dx;
		
		if(dx != dy)
		{
			for(int k= max_level; k >=0; k--)
			{
				if(par[dx][k] != par[dy][k])
				{
					if( maxNum[dx][k] < maxValue )
					{
						value = max(value, maxNum[dx][k]);
					}
					if( maxNum[dy][k] < maxValue )
					{
						value = max(value, maxNum[dy][k]);
					}
					dx = par[dx][k];
					dy = par[dy][k];
				}
				lca = par[dx][k];
			}
		}
		if(lca != dx)
		{
			if( maxNum[dx][0] < maxValue )
			{
				value = max(value, maxNum[dx][0]);
			}
			if( maxNum[dy][0] < maxValue )
			{
				value = max(value, maxNum[dy][0]);
			}
		}
		return value;
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
	static class mySort implements Comparator<Node>{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
	}
	static class Pair {
		int dx, cost;
		Pair(int a, int b) {
			dx=a; cost =b;
		}
	}
	static class Node {
		int dx, dy, cost;
		Node(int a, int b, int c) {
			dx=a; dy=b; cost=c;
		}
	}
}
