package com.company.cs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 특정한 최단 경로 
 *
 */
public class baek1504 {
	public static class Point implements Comparable<Point>{
		int index, cost;
		Point(int x, int y) {
			index =x; cost =y;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return o.cost - cost;
		}
	}
	public static int N ,E, pointStart, pointEnd, pointMid1, pointMid2, result1, result2, totalResult;
	public static int[] dist = new int[801]; // 2 ~ 800
	public static int[] direction1 = new int[4];
	public static int[] direction2 = new int[4];
	public static ArrayList<ArrayList<Point>> arr = new ArrayList<ArrayList<Point>>(); 
	public static void init() {
		for(int i=1; i<= N; i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
	}
	public static void dijkstra(int start) {
		PriorityQueue<Point> que = new PriorityQueue<Point>();
		dist[start] = 0;
		que.offer(new Point(start,0));
		while(!que.isEmpty()) {
			int index = que.peek().index;
			int cost = que.peek().cost;
			que.poll();
			if(cost > dist[index]) continue;
			for(Point point : arr.get(index)) {
				if( dist[point.index] > dist[index] + point.cost) {
					dist[point.index] = dist[index] + point.cost;
					que.offer(point);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int start, end, cost, flag=0;
		result1 = 0; result2=0; totalResult=0;
		N = scanner.nextInt();
		E = scanner.nextInt();
		for(int i=0; i<=N; i++)
		{
			arr.add(new ArrayList<Point>());
		}
		for(int i=0; i< E; i++)
		{
			start = scanner.nextInt();
			end = scanner.nextInt();
			cost = scanner.nextInt();
			arr.get(start).add(new Point(end,cost));
			arr.get(end).add(new Point(start,cost)); // bidirection
		}
		pointMid1 = scanner.nextInt();
		pointMid2 = scanner.nextInt();
		direction1[0] = 1;
		direction1[1] = pointMid1;
		direction1[2] = pointMid2;
		direction1[3] = N;
		
		direction2[0] = 1;
		direction2[1] = pointMid2;
		direction2[2] = pointMid1;
		direction2[3] = N;
		
		for(int i=0; i<3; i++)
		{
			init();
			dijkstra(direction1[i]);
			if(dist[direction1[i+1]] == Integer.MAX_VALUE) 
			{
				flag =1;
				break;
			}
			result1 += dist[direction1[i+1]];
		}
		
		for(int i=0; i<3; i++)
		{
			init();
			dijkstra(direction2[i]);
			if(dist[direction2[i+1]] == Integer.MAX_VALUE) 
			{
				
				flag =1;
				break;
			}
			result2 += dist[direction2[i+1]];
		}
		totalResult = Integer.min(result1, result2);
		if(flag == 0) System.out.println(result1);
		else System.out.println(-1);
	}
}





