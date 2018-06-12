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
	public static final int INF = 800001; // 최대값 정할때 주의 !!! 
	public static int N ,E, pointMid1, pointMid2, result,result2;
	public static int[] dist = new int[801]; // 2 ~ 800
	
	public static ArrayList<ArrayList<Point>> arr = new ArrayList<ArrayList<Point>>(); 
	public static void init() {
		for(int i=1; i<= N; i++)
		{
			dist[i] = INF;
		}
	}
	public static int dijkstra(int start, int end) {
		int result =0;
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
		result = dist[end];
		init();
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int start, end, cost;
		result = 0; result2=0;
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
		init();
		result = dijkstra(1, pointMid1) + dijkstra(pointMid1, pointMid2) + dijkstra(pointMid2, N);
		// INF 를 Integer.max_value 값으로 주었을때 int 의 최대값이 넘어가기 때문에 문제에 주어진 적절한 최대값을 넣어둘 것!!
		result2 = dijkstra(1, pointMid2) + dijkstra(pointMid2, pointMid1) + dijkstra(pointMid1, N);
		
		if(result >= INF && result2 >= INF) System.out.println(-1);
		else if(result > result2) System.out.println(result2);
		else System.out.println(result);
	}
}





