package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek15649 {

	static int N, M;
	static int[] output = new int[9];
	static int[] visit = new int[9];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			visit[i] = 1;
			dfs(i, 1);
			visit[i] = 0;
		}
	}
	public static void dfs(int cur, int cnt)
	{
		output[cnt] = cur;
		
		if(cnt == M)
		{
			for(int i=1; i<= M; i++)
			{
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<= N; i++)
		{
			if(visit[i] == 1) continue;
			visit[i] = 1;
			dfs(i, cnt+1);
			visit[i] = 0;
		}
	}
}




