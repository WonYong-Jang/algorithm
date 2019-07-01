package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 컨벡스 헐 
 */
public class koitp443404 {

	static Point p0;
	static int N, ldx, ldy;
	static Point[] p = new Point[100005];
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx = 0, dy = 0;
		ldx = 40005; ldy = 40005;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Point(dx, dy);
			if(ldy > dy) {
				ldx = dx;
				ldy = dy;
			}
			if(ldy == dy && ldx > dx) {
				ldx = dx;
				ldy = dy;
			}
		}
		p0 = new Point(ldx, ldy);
		Arrays.sort(p, 1, N+1, new mySort());
		
		stack.add(1);
		stack.add(2);
		int next = 3;
		while(next <= N)
		{
			while(stack.size() >= 2)
			{
				int second = stack.pop();
				int first = stack.peek();
				
				int op = ccw(p[first], p[second], p[next]);
				if(op > 0)
				{
					stack.push(second);
					break;
				}
			}
			stack.push(next++);
		}
		System.out.println(stack.size());
	}
	static class mySort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			int op = ccw(p0, a, b);
			if(op == 0) 
			{
				long d1 = dis(p0, a);
				long d2 = dis(p0, b);
				if(d1 < d2) return -1;
				else if(d1 > d2) return 1;
				else return 0;
			}
			return op > 0 ? -1 : 1;
		}
	}
	public static long dis(Point a, Point b)
	{
		return (a.dx-b.dx)*(a.dx-b.dx) + (a.dy - b.dy)*(a.dy - b.dy);
	}
	public static int ccw(Point a, Point b, Point c)
	{
		long op = ( (a.dx*b.dy)+(b.dx*c.dy)+(c.dx*a.dy) ) - ( (a.dy*b.dx)+(b.dy*c.dx)+(c.dy*a.dx)  );
		if(op > 0) return 1;
		else if(op < 0) return -1;
		else return 0;
	}
	static class Point {
		long dx,dy;
		Point(long a, long b) {
			dx=a; dy=b;
		}
	}
}
