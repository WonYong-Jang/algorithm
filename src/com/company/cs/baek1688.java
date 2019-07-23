package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 지민이의 테러 
 */
public class baek1688 {

	static final long INF = 1000000005;
	static int N;
	static Point[] p = new Point[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long dx =0, dy =0;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Long.parseLong(st.nextToken());
			dy = Long.parseLong(st.nextToken());
			p[i] = new Point(dx, dy);
		}
		
		for(int i=1; i<=3; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Long.parseLong(st.nextToken());
			dy = Long.parseLong(st.nextToken());
			double cnt = 0;
			
			Point pt = new Point(dx,dy);
			Point ptt = new Point(INF,dy+1);
			Line line1 = new Line(pt,ptt);
			
			for(int j = 0; j < N; j++)
			{
				Line line2 = new Line(p[j],p[( j + 1 ) % N]);
				
				if(isCross(line1, line2)==2)
				{
					cnt = 1;
					break;
				}
				
				if(isCross(line1, line2)==1)
				{
					if(search(line1, p[j]) || search(line1, p[(j+1)%N]))
					{
						cnt += 0.5;
					}
					else cnt += 1;
				}
				
				
			}
			int result = (int)cnt;
			
			if(result % 2 != 0) bw.write("1\n");
			else bw.write("0\n");
		}
		bw.flush();
	}
	public static int isCross(Line a, Line b)
	{
		int ap1 = ccw(a.p1, a.p2, b.p1);
		int ap2 = ccw(a.p1, a.p2, b.p2);
		int ap3 = ccw(b.p1, b.p2, a.p1);
		int ap4 = ccw(b.p1, b.p2, a.p2);
		
		if(search(b, a.p1))
		{
			return 2;
		}
		
		if(ap1 == 0 && ap2 == 0 && ap3 == 0 && ap4 == 0)
		{
			if(a.p_max.dx < b.p_min.dx || 
				a.p_max.dy < b.p_min.dy ||
				b.p_max.dx < a.p_min.dx || 
				b.p_max.dy < a.p_min.dy) return 0;
			
		}
		if(ap1*ap2 <=0 && ap3*ap4 <= 0) return 1;
		else return 0;
	}
	public static boolean search(Line a, Point b)
	{
		long ap1 = (b.dy - a.p1.dy)*(a.p2.dx-a.p1.dx);
		long ap2 = (a.p2.dy - a.p1.dy)*(b.dx - a.p1.dx);
		long rdx1 = min(a.p1.dx, a.p2.dx);
		long rdx2 = max(a.p1.dx, a.p2.dx);
		long rdy1 = min(a.p1.dy, a.p2.dy);
		long rdy2 = max(a.p1.dy, a.p2.dy);
		if(ap1 == ap2 && rdx1 <= b.dx && b.dx <= rdx2 && rdy1 <= b.dy && b.dy <= rdy2) return true;
		else return false;
	}
	public static int ccw(Point a, Point b, Point c)
	{
		long op = ( (a.dx*b.dy)+(b.dx*c.dy)+(c.dx*a.dy) ) - ( (a.dy*b.dx)+(b.dy*c.dx)+(c.dy*a.dx) );
		if(op > 0) return 1;
		else if(op < 0) return -1;
		else return 0;
	}
	static class Line {
		Point p1, p2, p_max, p_min;
		Line(Point a, Point b)
		{
			p1 = new Point(a.dx, a.dy);
			p2 = new Point(b.dx, b.dy);
			p_min = new Point(min(p1.dx, p2.dx), min(p1.dy, p2.dy));
			p_max = new Point(max(p1.dx, p2.dx), max(p1.dy, p2.dy));
		}
	}
	static class Point {
		long dx, dy;
		Point(long a, long b){
			dx=a; dy =b;
		}
	}
	public static long max(long a, long b) { return a > b ? a : b; }
	public static long min(long a, long b) { return a > b ? b : a; }
}


/*
4
0 0
0 2
2 2
2 0
1 1
1 1
1 1
 */
