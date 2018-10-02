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
 * ACM Craft ( 위상 정렬 ) 
 */
public class baek1005 {

	static int N, K, target;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int[] time = new int[1005];
	static int[] degree = new int[1005];
	static int[] ans = new int[1005];
	static Queue<Integer> que = new LinkedList<>();
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
			K = Integer.parseInt(st.nextToken());
			adj.clear();
			for(int i=0; i<= N; i++) 
			{
				adj.add(new ArrayList<>());
				degree[i] = ans[i] = time[i] = 0;
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= N; i++)
			{
				time[i] = Integer.parseInt(st.nextToken());
			}
			target =0;
			int dx = 0, dy =0;
			for(int i=1; i<= K; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				adj.get(dx).add(dy);
				degree[dy]++;
			}
			
			st = new StringTokenizer(br.readLine());
			target = Integer.parseInt(st.nextToken());
			que.clear();
			for(int i=1; i<= N; i++)
			{
				if(degree[i] == 0) 
				{
					ans[i] = time[i];
					que.add(i);
				}
			}
			
			solve();
			
			bw.write(ans[target]+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			int n = que.poll();
			
			for(int next : adj.get(n))
			{
				
				ans[next] = max(ans[next], time[next] + ans[n]);
				
				degree[next]--;
				if(degree[next] ==0 )
				{
					que.add(next);
				}
			}
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
