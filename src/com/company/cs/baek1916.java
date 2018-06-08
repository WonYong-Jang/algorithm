package com.company.cs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 백준 1916번 
 * 최소비용 구하기 
 *
 */
public class baek1916 {
	public static int n, m, start, end;
	public static int[] dist = new int[1001];
	public static class Point implements Comparable<Point>{
		int index, cost;
		Point(int x, int y) {
			index = x; cost = y;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return cost > o.cost ? 1 : -1;
		}
	}
	public static ArrayList<ArrayList<Point>> arr = new ArrayList<ArrayList<Point>>();
	
	public static void init() {
		for(int i=0; i<n+1; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			arr.add(new ArrayList<Point>());
		}
	}
	public static void dijkstra(int start) {
		dist[start] =0;
		PriorityQueue<Point> que = new PriorityQueue<Point>();
		que.offer(new Point(start,0));
		
		while(!que.isEmpty()) {
			int index = que.peek().index;
			int cost = que.peek().cost;
			que.poll();
			
			if(cost > dist[index]) continue; // already changed to smaller cost !
			
			for(Point point : arr.get(index))
			{
				if( dist[point.index] > dist[index] + point.cost)
				{
					dist[point.index] = dist[index] + point.cost;
					que.offer(point);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int pStart=0, pEnd=0, cost=0;
		n = scanner.nextInt();
		m = scanner.nextInt();
		init();
		for(int i = 0; i< m; i++)
		{
			pStart = scanner.nextInt();
			pEnd = scanner.nextInt();
			cost = scanner.nextInt();
			arr.get(pStart).add(new Point(pEnd,cost));
		}
		start = scanner.nextInt();
		end = scanner.nextInt();
		dijkstra(start);
		System.out.println(dist[end]);
	}
}






