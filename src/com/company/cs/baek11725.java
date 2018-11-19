package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기 
 */
public class baek11725 {

	static int N;
	static int[] parent = new int[100005];
	static int[] depth = new int[100005];
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
		
		int dx = 0, dy=0;
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
		for(int i=2; i<= N; i++)
		{
			bw.write(parent[i]+"\n");
		}
		bw.flush();
	}
	public static void dfs(int cur, int p)
	{
		depth[cur] = depth[p] + 1;
		parent[cur] = p;
		
		for(int next : adj.get(cur))
		{
			if(next != p)
			{
				dfs(next, cur);
			}
		}
	}
}





