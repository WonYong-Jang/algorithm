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

public class Main {

	static final int max_level = 17;
	static int N, M;
	static int[][] par = new int[100005][20];
	static int[] depth = new int[100005];
	static Queue<Integer> que = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
			depth[i] = -1;
		}
		int dx =0, dy =0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		
		depth[1] = 0;
		que.add(1);
		while(!que.isEmpty())
		{
			int n = que.poll();
			
			for(int next : adj.get(n))
			{
				if(depth[next] == -1)
				{
					depth[next] = depth[n] + 1;
					par[next][0] = n;
					que.add(next);
				}
			}
		}
		
		for(int k=1; k<= max_level; k++)
		{
			for(int i=1; i<= N; i++)
			{
				int tmp = par[i][k-1];
				par[i][k] = par[tmp][k-1];
			}
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			
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
						dy = par[dy][k];
						dx = par[dx][k];
					}
					lca = par[dx][k];
				}
			}
			bw.write(lca+"\n");
		}
		bw.flush();
			
	}
}






