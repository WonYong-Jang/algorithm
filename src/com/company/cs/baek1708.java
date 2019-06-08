package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 볼록 껍질 
 */
public class baek1708 {

	static int N;
	static Point[] p = new Point[100005];
	static Point p0;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx =0, dy =0;
		p0 = new Point(40001,40001);
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Point(dx, dy);
			if(p0.dy > p[i].dy) {
				p0.dx = p[i].dx;
				p0.dy = p[i].dy;
			}
			if(p0.dy == p[i].dy && p0.dx > p[i].dx) {
				p0.dx = p[i].dx;
				p0.dy = p[i].dy;
			}
		}
		Arrays.sort(p, 1, N+1, new mySort()); // 각 정렬 ( 반시계 방향 기준 ) 
		
		stack.add(1);
		stack.add(2);
		int next = 3, second =0, first =0, op =0;
		while(next <= N)
		{
			while(stack.size() >= 2)
			{
				second = stack.pop();
				first = stack.peek();
				op = ccw(p[first], p[second], p[next]);
				if(op > 0) {
					stack.add(second);
					break;
				}
			}
			stack.push(next++);
		}
		System.out.println(stack.size());
	}
	public static int ccw(Point a, Point b, Point c)
	{
		long tmp = (long)(a.dx*b.dy + b.dx*c.dy + c.dx*a.dy) - (long)(a.dy*b.dx + b.dy*c.dx + c.dy*a.dx);
		if(tmp > 0) return 1;
		else if(tmp < 0) return -1;
		else return 0;
	}
	public static long dis(Point a, Point b)
	{
		return (long)(a.dx-b.dx)*(a.dx-b.dx) + (long)(a.dy-b.dy)*(a.dy-b.dy);	
	}
	static class mySort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			int t = ccw(p0, a, b);
			if(t == 0)
			{
				long d1 = dis(p0,a);
				long d2 = dis(p0,b);
				if(d1 < d2) return -1;
				else if(d1 > d2) return 1;
				else return 0;
			}
			return t > 0 ? -1 : 1;
		}
	}
	static class Point {
		int dx, dy;
		Point(int a, int b) { 
			dx=a; dy=b;
		}
	}
}
