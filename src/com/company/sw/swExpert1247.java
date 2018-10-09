package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 최적 경로 
 */
public class swExpert1247 {

	static int N, ans;
	static int sdx, sdy, edx, edy;
	static int[][] data = new int[15][2]; 
	static int[] visit = new int[15]; 
	static int[] output = new int[15]; 
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
			ans = Integer.MAX_VALUE;
			
			for(int i=1; i<= N+2; i++) visit[i] = 0;
			
			st = new StringTokenizer(br.readLine());
			int dx = 0, dy =0;
			
			sdx = Integer.parseInt(st.nextToken());
			sdy = Integer.parseInt(st.nextToken());
			edx = Integer.parseInt(st.nextToken());
			edy = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<= N; i++)
			{
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				data[i][0] = dx; data[i][1] = dy; 
			}
			data[0][0] = sdx; data[0][1] = sdy; // 시작 
			data[N+1][0] = edx; data[N+1][1] = edy; // 끝 
			for(int i=1; i<= N; i++)
			{
				int tmp = dis(0, i); // 시작
				visit[i] = 1;
				solve(i, 1, tmp);
				visit[i] = 0;
			}
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int index, int depth, int sum)
	{
		if(depth == N)
		{
			ans = min(ans, sum + dis(index, N+1));
			return;
		}
		if(sum > ans) return;
		
		for(int i=1; i<= N; i++)
		{
			if(visit[i] == 1) continue;
			int tmp = dis(index, i); // 시작
			visit[i] = 1;
			solve(i, depth+1, sum + tmp);
			visit[i] = 0;
		}
	}
	public static int dis(int a, int b)
	{
		return abs(data[a][0], data[b][0]) + abs(data[a][1], data[b][1]);
	}
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a; 
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, cost;
		Node(int a, int b) {
			dx = a; cost = b; 
		}
	}
}
