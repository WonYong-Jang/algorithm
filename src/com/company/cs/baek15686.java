package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/**
 * 치킨 배달   
 */
public class baek15686 {

	static int[][] map = new int[51][51];
	static Deque<Point> que = new ArrayDeque<>(); // 최대 M개의 치킨집 선택을 위한 큐  
	static int N, M, minDis = Integer.MAX_VALUE, cLen, hLen; // 치킨, 집 배열 size
	static ArrayList<Point> chicken = new ArrayList<>();
	static ArrayList<Point> home = new ArrayList<>();
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
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 1) home.add(new Point(i,j));
				else if(temp == 2) chicken.add(new Point(i,j));
			}
		}
		cLen = chicken.size(); // 치킨집 갯수(2) 
		hLen = home.size(); // 집 갯수 (1)
		
		for(int i=0; i<cLen; i++)
		{
			que.addLast(chicken.get(i));
			dfs(i, 1);
			que.pollLast();
		}
		System.out.println(minDis);
	}
	public static void dfs(int curIndex, int cnt)
	{	
		if(cnt == M) {
			int temp = calculate(); // 계산  
			minDis = Integer.min(minDis, temp);
			return;
		}
		for(int i=curIndex+1; i<cLen; i++)
		{
			que.addLast(chicken.get(i));
			dfs(i, cnt+1);
			que.pollLast();
		}
	}
	public static int calculate() // 집 기준으로 선택된 치킨집(deque)과의 거리를 구함 
	{
		ArrayList<Point> arr = new ArrayList<>();
		arr.addAll(que); // 선택된 치킨 집 
		int min, sum=0;
		for(int i=0; i<hLen; i++) // 집의 갯수만큼  
		{
			min = Integer.MAX_VALUE;
			for(int j=0; j<arr.size(); j++) // 선택된 치킨집  
			{
				int result = dis(arr.get(j),home.get(i));
				if( result < min) {
					min = result;
				}
			}
			sum += min; // 집에서 가장 가까운 치킨 집을 찾아내서 더함 
		}
		return sum;
	}
	public static int dis(Point p1, Point p2) // 거리 계산  
	{
		return Math.abs(p1.dx - p2.dx) + Math.abs(p1.dy - p2.dy);
	}
	public static class Point{
		int dx,dy;
		Point(int x, int y) {
			dx = x; dy =y;
		}
	}
}
