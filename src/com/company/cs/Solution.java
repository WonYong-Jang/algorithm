package com.company.cs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * 백
 * 1753	최단경로
 *
 */
public class Solution {
	public static int V, E;
	public static ArrayList<ArrayList<Point>> arr = new ArrayList<ArrayList<Point>>(); // 인접리스트
	public static int[] dist = new int[100];
	
	public static class Point implements Comparable<Point>{
		public int index,cost;
		Point(int x, int y) {
			index =x; cost= y;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return cost > o.cost ? 1 : -1;
		}
	}
	
	public static void dijkstra(int start)
	{
		PriorityQueue<Point> que = new PriorityQueue<>();
		dist[start] =0;
		que.offer(new Point(start,dist[start]));
		
		while(!que.isEmpty()) {
			int cost = que.peek().cost; //
			int index = que.peek().index; // current index
			que.poll();
			
			if(cost > dist[index]) continue;
			
			for(Point point : arr.get(index))
			{
				if(dist[point.index] > dist[index] + point.cost )
				{
					dist[point.index] = dist[index] + point.cost;
					que.offer(point);
				}
			}
		}
	}
	public static void init() {
		
		for(int i=0; i<V+1; i++) // 인접 리스트 초기
		{
			dist[i] = Integer.MAX_VALUE;
			arr.add(new ArrayList<Point>());
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int start=0, startX =0, startY=0, cost=0;
		V = scanner.nextInt();
		E = scanner.nextInt();
		start = scanner.nextInt();
		init();
		
		for(int i=0; i<E; i++)
		{
			startX = scanner.nextInt();
			startY = scanner.nextInt();
			cost = scanner.nextInt();
			arr.get(startX).add(new Point(startY,cost));
		}
		dijkstra(start);
		
		for(int i=1; i< V+1; i++)
		{
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
}










