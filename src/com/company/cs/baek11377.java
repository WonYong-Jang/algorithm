package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 열혈 강호 3 
 */
public class baek11377 {

	static int N, M, K;
	static int[] visit = new int[1005];
	static int[] match = new int[1005];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		int cnt = 0, num = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			for(int j=1; j<= cnt; j++)
			{
				num = Integer.parseInt(st.nextToken());
				adj.get(i).add(num);
			}
		}
		
		System.out.println(bmatch());
	}
	public static int bmatch()
	{
		int ret = 0, count = 0;
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++) visit[j] = 0;
			if(dfs(i) == 1) ret++;
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++) visit[j] = 0;
			if(dfs(i) == 1) {
				ret++;
				count++;
			}
			if(count == K) break;
		}
		
		return ret;
	}
	public static int dfs(int cur)
	{
		if(visit[cur] == 1) return 0;
		visit[cur] = 1;
		
		for(int next : adj.get(cur))
		{
			if(match[next] == 0 || dfs(match[next]) == 1)
			{
				match[next] = cur;
				return 1;
			}
		}
		
		return 0;
	}
}



