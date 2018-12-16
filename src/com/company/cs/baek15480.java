package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * LCA 와 쿼리 
 */
public class baek15480 {

	static final int max_node = 100005;
	static int N, M, max_level, curDepth, result;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int[][] par = new int[100005][20];
	static int[] depth = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int size = 1;
		while(max_node > size) {
			size *= 2;
			max_level++;
		}
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		int dx=0, dy=0, dz = 0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		
		depth[0] = -1;
		dfs(1,0);
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			dz = Integer.parseInt(st.nextToken());
			curDepth = -1; result = -1;
			
			query(dx, dy);
			query(dx, dz);
			query(dy, dz);
			
			bw.write(result+"\n");
		}
		bw.flush();
	}
	public static void query(int dx, int dy)
	{
		if(depth[dx] != depth[dy])
		{
			if(depth[dx] > depth[dy])
			{
				int tmp = dx;
				dx = dy;
				dy = tmp;
			}
			
			for(int i= max_level; i>=0; i--)
			{
				if(depth[dx] <= depth[par[dy][i]])
				{
					dy = par[dy][i];
				}
			}
		}
		
		int lca = dx;
		
		if(dx != dy)
		{
			for(int i= max_level; i>= 0; i--)
			{
				if(par[dx][i] != par[dy][i])
				{
					dx = par[dx][i];
					dy = par[dy][i];
				}
				lca = par[dx][i];
			}
		}
		if(depth[lca] > curDepth)
		{
			result = lca;
			curDepth = depth[lca];
		}
	}
	public static void dfs(int cur, int p)
	{
		depth[cur] = depth[p] + 1;
		par[cur][0] = p;
		
		for(int i=1; i<= max_level; i++)
		{
			int tmp = par[cur][i-1];
			par[cur][i] = par[tmp][i-1];
		}
		
		for(int next : adj.get(cur))
		{
			if(next != p)
			{
				dfs(next, cur);
			}
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}



