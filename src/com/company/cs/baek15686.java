package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치킨 배달  
 *
 */
public class baek15686 {
	
	public static Deque<Point> deque = new ArrayDeque<>();
	public static ArrayList<Point> totalChicken = new ArrayList<>(); 
	public static int[] visited = new int[14];
	public static ArrayList<Point> home = new ArrayList<>();
	public static int[][] map = new int[51][51];
	public static int N, M;
	public static int minValue = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 2) totalChicken.add(new Point(i,j));
				else if(num ==1) home.add(new Point(i,j)); 
			}
		}
		for(int i=0; i<totalChicken.size(); i++) {
			visited[i] = 1;
			deque.add(totalChicken.get(i));
			dfs(1, i);
			visited[i] = 0;
			deque.pollLast();
		}
		System.out.println(minValue);
	}
	public static int bfs(Point home) {
		Queue<Point> que = new LinkedList<>();
		que.addAll(deque);
		int result = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			Point chicken = que.poll();
			
			int temp = calDistance(chicken, home);
			result = Integer.min(temp,result);
		}
		
		return result;
	}
	public static void dfs(int cnt, int v) {
		if(cnt == M) {
			int result =0;
			for(Point point : home)
			{
				result += bfs(point);
			}
			minValue = Integer.min(minValue, result);
			return;
		}
		for(int i=v; i<totalChicken.size(); i++) {
			if(visited[i] == 1) continue;
			deque.add(totalChicken.get(i));
			visited[i] = 1;
			dfs(cnt+1, i);
			visited[i] = 0;
			deque.pollLast();
		}
	}
	public static int calDistance(Point a, Point b) 
	{
		int result = Math.abs(a.dx - b.dx) + Math.abs(a.dy - b.dy); 
		return result;
	}
	public static class Point {
		int dx,dy;
		Point(int x,int y) {
			dx =x; dy =y;
		}
	}
}
