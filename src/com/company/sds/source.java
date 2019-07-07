package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {

	static Point p0;
	static int N, ldx, ldy;
	static Point[] p = new Point[500005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx = 0, dy = 0;
		ldx = 50005; ldy = 50005;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Point(dx, dy);
			if(ldy > dy)
			{
				ldx = dx; ldy = dy;
			}
			else if(ldy == dy && ldx > dx) {
				ldx = dx; ldy = dy;
			}
		}
		p0 = new Point(ldx, ldy);
		Arrays.sort(p, 0, N, new mySort());
		
		int start = 0, end = 0;
		long result = Integer.MAX_VALUE;
		for(int i=0; i< N; i++)
		{
			start = i;
			end = (i+1) % N;
			long tmp = dis(p[start], p[end]);
			if(result > tmp) {
				result = tmp;
			}
		}
		System.out.println(result);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
	public static int max(int a, int b) { return a > b ? a : b; }
	public static long dis(Point a, Point b)
	{
		return ((a.dx-b.dx)*(a.dx-b.dx)) + ((a.dy-b.dy)*(a.dy-b.dy));
	}
	public static int ccw(Point a, Point b, Point c)
	{
		long op = ( (a.dx*b.dy)+(b.dx*c.dy)+(c.dx*a.dy) )- ( (a.dy*b.dx)+(b.dy*c.dx)+(c.dy*a.dx) );
		if(op > 0 ) return 1;
		else if(op < 0) return -1;
		else return 0;
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
	static class Point {
		long dx, dy;
		Point(long a, long b) { 
			dx=a; dy =b;
		}
	}
}




