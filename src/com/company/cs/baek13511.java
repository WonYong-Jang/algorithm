package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리와 쿼리 
 */
public class baek13511 {

	static final int max_level = 17;
	static int N, M;
	static int[] depth = new int[100005];
	static long[] dis = new long[100005];
	static int[][] par = new int[100005][20];
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++) {
			adj.add(new ArrayList<>());
			depth[i] = -1;
		}
		int dx=0, dy=0, cost =0, cmd = 0, k =0, result =0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			adj.get(dx).add(new Node(dy,cost));
			adj.get(dy).add(new Node(dx, cost));
		}
		
		dis[1] = 0; depth[1] = 0;
		que.add(new Node(1, 0));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			for(Node next : adj.get(n.dx))
			{
				if(depth[next.dx] == -1)
				{
					par[next.dx][0] = n.dx;
					depth[next.dx] = depth[n.dx] + 1;
					dis[next.dx] = dis[n.dx] + (long)next.cost;
					que.add(next);
				}
			}
		}
		
		for(int h=1; h<= max_level; h++)
		{
			for(int cur =2; cur <= N; cur++)
			{
				int tmp = par[cur][h-1];
				par[cur][h] = par[tmp][h-1];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		long sumResult = 0;
		int leftDepth =0, rightDepth =0, lcaDepth =0, leftHeight=0, rightHeight=0, temp =0; 
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			int lca = solve(dx, dy); // 거리
			
			if(cmd == 1)
			{ 
				sumResult = dis[dx] + dis[dy] - (2*dis[lca]);
				bw.write(sumResult+"\n");
			}
			else {
				k = Integer.parseInt(st.nextToken());
				
				leftDepth = depth[dx];
				rightDepth = depth[dy];
				lcaDepth = depth[lca];
				leftHeight = leftDepth - lcaDepth + 1;
				rightHeight = rightDepth - lcaDepth + 1;
				int ans = 0, target =0, sum = 1;
				if(leftHeight >= k) { // 왼쪽에서 k 번째 찾아 
					target = dx;
				}
				else if(leftHeight < k) {
					temp = k - leftHeight;
					k = rightHeight - temp;
					target = dy;
				}
				ans = target;
				for(int h = max_level; h >= 0; h--)
				{
					if(par[target][h] <= 0 ) continue;
					int check = sum + ( 1 << h );
					if(k >= check )
					{
						sum += (1 << h);
						
						if(k == check) {
							ans = par[target][h];
							break;
						}
						target = par[target][h];
					}
				}
				
				bw.write(ans+"\n");
				
			}
		}
		bw.flush();
	}
	public static int solve(int a, int b)
	{
		int dx = a, dy = b;
		
		if(depth[dx] != depth[dy])
		{
			
			if(depth[dx] > depth[dy])
			{
				int tmp = dx;
				dx = dy;
				dy = tmp;
			}
			
			for(int k= max_level; k>=0; k--) 
			{
				if(depth[dx] <= depth[par[dy][k]])
				{
					dy = par[dy][k];
					
				}
			}
		}
		
		int lca = dx;
		
		if(dx != dy)
		{
			for(int k = max_level; k >=0; k--) 
			{
				if(par[dx][k] != par[dy][k]) 
				{
					dx = par[dx][k];
					dy = par[dy][k];
				}
				lca = par[dx][k];
			}
		}
		
		return lca; 
	}
	static class Node {
		int dx, cost;
		Node(int a, int b) {
			dx =a; cost =b;
		}
	}
}
