package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baek2261 {

	static int N;
	static Point[] p = new Point[100005];
	static TreeSet<Point> set = new TreeSet<>(new treeSort());
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx = 0, dy = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Point(dx,dy);
		}
		Arrays.sort(p, 1,N+1, new xSort());
		int ans = dis(p[1], p[2]);
		set.add(p[1]);
		set.add(p[2]);
		
		int start = 1;
		for(int i=3; i<= N; i++)
		{
			Point now = p[i];
			
			while(start < i) {
				Point pivot = p[start];
				int x = pivot.dx - now.dx;
				
				if(x*x > ans) {
					set.remove(pivot);
					start += 1;
				}
				else break;
			}
			
			int d = (int)Math.sqrt((double)ans) +1;
			
			Point lower_point = new Point(now.dy-d, now.dy+d);
			SortedSet<Point> lower = set.tailSet(lower_point);
			Iterator<Point> it_lower = lower.iterator();
			
			while(it_lower.hasNext()) {
				Point temp = it_lower.next();
				d = dis(now, temp);
				if(d < ans) {
					ans = d;
				}
			}
			set.add(p[i]);
		}
		System.out.println(ans);
	}
	public static int dis(Point a, Point b)
	{
		return (a.dx-b.dx)*(a.dx-b.dx) + (a.dy-b.dy)*(a.dy-b.dy);
	}
	static class treeSort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			if(a.dy < b.dy) return -1;
			else if(a.dy > b.dy) return 1;
			else
			{
				if(a.dx < b.dx) return -1;
				else if(a.dx > b.dx) return 1;
				else return 0;
			}
		}
	}
	static class xSort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else return 0;
		}
	}
	static class Point implements Comparable<Point>{
		int dx, dy;
		Point(int a, int b) {
			dx=a; dy=b;
		}
		@Override
		public int compareTo(Point p) {
	        return dx < p.dy && dy > p.dy ? 1 : -1;
	    }
	}
}
