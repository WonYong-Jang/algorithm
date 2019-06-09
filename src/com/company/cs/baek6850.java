package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * cows
 */
public class baek6850 {

	static int N, len;
	static Point[] p = new Point[10005];
	static Point p0;
	static Stack<Integer> stack = new Stack<>();
	static int[] ans = new int[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx = 0, dy = 0;
		p0 = new Point(1005,1005);
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Point(dx,dy);
			if(p0.dy > p[i].dy) {
				p0.dx = p[i].dx;
				p0.dy = p[i].dy;
			}
			if(p0.dy == p[i].dy && p0.dx > p[i].dx) {
				p0.dx = p[i].dx;
				p0.dy = p[i].dy;
			}
		}
		
		Arrays.sort(p, 0, N, new mySort());
		
		stack.add(0);
		stack.add(1);
		int next = 2, first = 0, second = 0;
		while(next < N)
		{
			while(stack.size() >= 2)
			{
				second = stack.pop();
				first = stack.peek();
				int op = ccw(p[first], p[second], p[next]);
				if(op > 0) {
					stack.add(second);
					break;
				}
			}
			stack.add(next++);
		}
		
		len = stack.size();
		next = 0;
		while(!stack.isEmpty())
		{
			int num = stack.pop();
			ans[next++] = num;
		}
		int result = 0;
		for(int i=0; i< len; i++)
		{
			result += ((p[ans[i]].dx*p[ans[(i+1)%len]].dy) - (p[ans[i]].dy*p[ans[(i+1)%len]].dx));
		}
		if(result < 0) result *= -1;
		result /=2;
		System.out.println(result/50);
	}
	public static int ccw(Point a, Point b, Point c)
	{
		int op = (a.dx*b.dy + b.dx*c.dy + c.dx*a.dy) - (a.dy*b.dx + b.dy*c.dx + c.dy*a.dx);
		if(op > 0) return 1;
		else if(op < 0 ) return -1;
		else return 0;
	}
	public static int dis(int dx1, int dy1, int dx2, int dy2)
	{
		return (dx1-dx2)*(dx1-dx2) + (dy1- dy2)*(dy1- dy2);
	}
	static class mySort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			// TODO Auto-generated method stub
			int t = ccw(p0, a, b);
			if(t == 0)
			{
				int d1 = dis(p0.dx, p0.dy, a.dx, a.dy);
				int d2 = dis(p0.dx, p0.dy, b.dx, b.dy);
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
