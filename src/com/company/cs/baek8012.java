package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 한동이는 영업사원!
 */
public class baek8012 {

	static int N, M, max_level, result;
	static final int max_node = 30005;
	static int[][] par = new int[max_node][20];
	static int[] depth = new int[max_node];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		int size = 1;
		max_level = 0; result =0;
		while(max_node > size) {
			size *=2;
			max_level++;
		}
		
		int dx = 0, dy =0;
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
		
		int sdx = 1, sdy = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			sdy = Integer.parseInt(st.nextToken());
			dx = sdx; // 시작점 
			dy = sdy;
			if(depth[dx] != depth[dy])
			{
				if(depth[dx] > depth[dy])
				{
					int tmp = dx;
					dx = dy;
					dy = tmp;
				}
				
				for(int k = max_level; k >= 0; k--)
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
				for(int k = max_level; k >= 0; k--)
				{
					if(par[dx][k] != par[dy][k])
					{
						dx = par[dx][k];
						dy = par[dy][k];
					}
					lca = par[dx][k];
				}
			}
			
			int temp = depth[sdx]+ depth[sdy] - ( 2*depth[lca] );
			sdx = sdy;
			result += temp;
		}
		System.out.println(result);
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
}
