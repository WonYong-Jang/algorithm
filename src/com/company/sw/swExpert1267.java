package com.company.sw;

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
 * 작업순서 
 */
public class swExpert1267 {

	static int V, E;
	static int[] degree = new int[1005];
	static Queue<Integer> que = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int k=1; k<= 10; k++)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adj.clear();
			for(int i=0; i<= V; i++)
			{
				adj.add(new ArrayList<>());
				degree[i] = 0;
			}
			
			int dx = 0, dy =0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< E; i++)
			{
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				adj.get(dx).add(dy);
				degree[dy]++;
			}
			que.clear();
			for(int i=1; i<=V; i++)
			{
				if(degree[i] ==0) que.add(i);
			}
			
			System.out.print("#"+k+" ");
			solve();
			System.out.println();
		}
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			int n = que.poll();
			
			System.out.print(n+" ");
			
			for(int next : adj.get(n))
			{
				degree[next]--;
				if(degree[next] ==0 )
				{
					que.add(next);
				}
			}
		}
	}
}
