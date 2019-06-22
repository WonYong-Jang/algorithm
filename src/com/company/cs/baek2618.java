package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 경찰차 
 */
public class baek2618 {
	
	static final int INF = 987654321;
	static int N, W, len, ldx, ldy, cnt;
	static int[][] dp = new int[1005][1005];
	static Node[][] tracking = new Node[1005][1005];
	static Point[] point = new Point[1005];
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken())+2;
		int dx = 0, dy =0;
		point[1] = new Point(1, 1);
		point[2] = new Point(N, N);
		for(int i=3; i<= W; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			point[i] = new Point(dx, dy);
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				dp[i][j] = INF;
				
			}
		}
		dp[1][2] = 0;
		for(int i=1; i< W; i++)
		{
			for(int j=i+1; j< W; j++)
			{
				int k = j+1;
				if(dp[j][k] > dp[i][j] + dis(i,k))
				{
					dp[j][k] = dp[i][j] + dis(i,k);
					tracking[j][k] = new Node(i,j, 1);
					
				}
				if(dp[i][k] > dp[i][j] + dis(j,k))
				{
					dp[i][k] = dp[i][j] + dis(j,k);
					tracking[i][k] = new Node(i,j, 2);
				}
			}
		}
		int result = INF;
		ldx =0; ldy =0; cnt = W-2;
		for(int i=1; i<= W; i++)
		{
			if(dp[i][W] == INF) continue;
			
			if(result > dp[i][W])
			{
				result = dp[i][W];
				ldx = i; ldy = W;
			}
		}
		bw.write(result+"\n");
		while(cnt > 0)
		{
			Node n = tracking[ldx][ldy];
			
			stack.add(n.flag);
			ldx = n.dx;
			ldy = n.dy;
			
			cnt--;
		}
		while(!stack.isEmpty())
		{
			int n = stack.pop();
			bw.write(n+"\n");
		}
		
		bw.flush();
	}
	public static int min(int a, int b) { return a > b ? b :a; }
	public static int dis(int a, int b)
	{
		return abs(point[a].dx,point[b].dx) + abs(point[a].dy,point[b].dy); 
	}
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a;
	}
	static class Node {
		int dx, dy, flag;
		Node(int a, int b, int c) {
			dx=a; dy=b; flag=c;
		}
	}
	static class Point {
		int dx, dy;
		Point(int a, int b) {
			dx=a; dy=b;
		}
	}
}
