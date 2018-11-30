package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 단절점 
 */
public class baek11266 {

	static int V, E, number;
	static boolean[] cut = new boolean[10005]; // 단절점 여부 확인 배열 ! 
	static int[] order = new int[10005]; // 방문 순서 기록 !! 
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		number =0; // 방문 순서 기록 할 숫자 
		for(int i=0; i<= V; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		int dx=0, dy=0;
		for(int i=1; i<= E; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		for(int i=1; i<= V; i++)
		{
			if(order[i] > 0) continue;
			dfs(i, true);
		}
		
		int cnt =0;
		for(int i=1; i<= V; i++)
		{
			if(cut[i]) cnt++;
		}
		bw.write(cnt+"\n");
		for(int i=1; i<= V; i++)
		{
			if(cut[i]) 
			{
				bw.write(i+" ");
			}
		}
		bw.flush();
	}
	public static int dfs(int cur, boolean root)
	{
		order[cur] = ++number; // 방문순서 지정 
		int ret = order[cur];
		int child = 0; // root 자식 수가 2개 확인하기 위함 
		for(int next : adj.get(cur))
		{
			if(order[next] > 0) // 이미 방문한 지점이라면 가장 작은 순서 찾아서 업데이트 
			{
				ret = min(ret, order[next]);
				continue;
			}
			
			child++;
			
			int prev = dfs(next, false);
			
			if(!root && prev >= order[cur]) {
				cut[cur] = true; // 단절점 
			}
			ret = min(ret, prev);
		}
		
		if(root && child >= 2) cut[cur] = true;
		
		return ret;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}






