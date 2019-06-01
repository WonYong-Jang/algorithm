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
 * 가장 가까운 공통 조상 
 */
public class baek3584 {
	
	static final int max_level = 15;
	static int N;
	static int[] depth = new int[10005];
	static int[] check = new int[10005];
	static int[][] par = new int[10005][20];
	static Queue<Integer> que = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adj.clear();
			for(int i=0; i<= N; i++)
			{
				adj.add(new ArrayList<>());
				depth[i] = -1;
				check[i] = 0;
				for(int j=0; j<= max_level; j++)
				{
					par[i][j] = 0;
				}
			}
			
			int dx = 0, dy =0, tDx =0, tDy =0;
			for(int i=1; i< N; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				adj.get(dx).add(dy);
				check[dy]++;
			}
			st = new StringTokenizer(br.readLine());
			tDx = Integer.parseInt(st.nextToken());
			tDy = Integer.parseInt(st.nextToken());
			int root = 0;
			for(int i=1; i<= N; i++)
			{
				if(check[i] == 0) {
					root = i;
					break;
				}
			}
			
			depth[root] = 0;
			que.add(root);
			while(!que.isEmpty())
			{
				int cur = que.poll();
				
				for(int next : adj.get(cur))
				{
					if(depth[next] == -1)
					{
						depth[next] = depth[cur] + 1;
						par[next][0] = cur;
						que.add(next);
					}
				}
			}
			
			for(int i=1; i<= max_level; i++)
			{
				for(int j=1; j<= N; j++)
				{
					int tmp = par[j][i-1];
					par[j][i] = par[tmp][i-1];
				}
			}
			
			int result = lca(tDx, tDy);
			
			bw.write(result+"\n");
		}
		bw.flush();
	}
	public static int lca(int a, int b)
	{
		int dx = 0, dy = 0;
		dx = a; dy = b;
		
		if(depth[dx] != depth[dy])
		{
			if(depth[dx] > depth[dy])
			{
				int tmp = dx;
				dx = dy;
				dy = tmp;
			}
			
			for(int i= max_level; i>= 0; i--)
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
			for(int i=max_level; i>=0; i--)
			{
				if(par[dx][i] != par[dy][i])
				{
					dx = par[dx][i];
					dy = par[dy][i];
				}
				lca = par[dx][i];
			}
		}
		
		return lca;
	}
}





