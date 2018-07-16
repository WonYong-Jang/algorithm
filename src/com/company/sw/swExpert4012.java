package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 요리사 
 */
public class swExpert4012 {
	
	static int[][] map = new int[17][17];
	static int[] visited = new int[17];
	static int N, mid, result;
	static Vector<Integer> vec1 = new Vector<>();
	static Vector<Integer> vec2 = new Vector<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k = 1; k <= testCase; k++)
		{
			N = Integer.parseInt(br.readLine());
			mid = N / 2; // 절반 값 
			init();
			for(int i=1; i<= N; i++) // input 
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=1; i<= mid-1; i++)
			{
				visited[i] = 1;
				dfs(i,1);
				visited[i] = 0;
			}
			System.out.println("#" + k + " " + result);
		}
	}
	public static void dfs(int index, int cnt)
	{
		visited[index] = 1;
		
		if(cnt == mid) {
			int temp = solve();
			result = Math.min(temp, result);
			return;
		}
		
		for(int i = index+1; i<= N; i++)
		{
			if(visited[i] == 1) continue;
			visited[i] = 1;
			dfs(i,cnt+1);
			visited[i] = 0;
		}
	}
	public static int solve()
	{
		int vecNum1 =0, vecNum2=0;
		
		for(int i=1; i<= N; i++)
		{
			if(visited[i] == 1) vec1.add(i);
			else vec2.add(i);
		}
		for(int i=1; i<mid; i++)
		{
			for(int j=i+1; j<= mid; j++)
			{
				vecNum1 += (map[vec1.get(i-1)][vec1.get(j-1)]+map[vec1.get(j-1)][vec1.get(i-1)]);
				vecNum2 += (map[vec2.get(i-1)][vec2.get(j-1)]+map[vec2.get(j-1)][vec2.get(i-1)]);
			}
		}
		
		
		vec1.clear();
		vec2.clear();
		return Math.abs(vecNum1- vecNum2);
	}
	public static void init()
	{
		result = Integer.MAX_VALUE;
	}
}
