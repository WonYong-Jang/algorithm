package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 교차점 
 */
public class baek10255 {

	static int N;
	static Line[] line = new Line[4];
	static Line target;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			long dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
			st = new StringTokenizer(br.readLine());
			dx1 = Long.parseLong(st.nextToken()); 
			dy1 = Long.parseLong(st.nextToken()); 
			dx2 = Long.parseLong(st.nextToken()); 
			dy2 = Long.parseLong(st.nextToken()); 
			
			line[0] = new Line(dx1, dy1, dx2, dy1);
			line[1] = new Line(dx1, dy1, dx1, dy2);
			line[2] = new Line(dx2, dy1, dx2, dy2);
			line[3] = new Line(dx1, dy2, dx2, dy2);
			
			st = new StringTokenizer(br.readLine());
			dx1 = Long.parseLong(st.nextToken()); 
			dy1 = Long.parseLong(st.nextToken()); 
			dx2 = Long.parseLong(st.nextToken()); 
			dy2 = Long.parseLong(st.nextToken());
			//target = new Line(-1, -1, 8, 4);
			target = new Line(dx1, dy1, dx2, dy2);
			
			int result = 0;
			double cnt = 0;
			for(int i=0; i<4; i++)
			{
				result = isCross(target, line[i]);
				System.out.println(result);
				if(result == 4)
				{
					cnt = result;
					break;
				}
				else if(result == 2) cnt += 0.5;
				else if(result == 1) cnt += 1;
			}
			result = (int)cnt;
			bw.write(result+"\n");
		}
		bw.flush();
	}
	public static int isCross(Line a, Line b)
	{
		int ap1 = ccw(a.p1, a.p2, b.p1) * ccw(a.p1, a.p2, b.p2);
		int ap2 = ccw(b.p1, b.p2, a.p1) * ccw(b.p1, b.p2, a.p2);
		
		if(ap1 == 0 && ap2 == 0)
		{
			if(a.p_max.dx < b.p_min.dx ||
				a.p_max.dy < b.p_min.dy ||
				b.p_max.dx < a.p_min.dx ||
				b.p_max.dy < a.p_min.dy) return 0;
		}
		if(ap1 == 0 && ap2 == 0) return 4;
		
		else if(ap1 <= 0 && ap2 <= 0) return 1;
		else return 0;
	}
	public static boolean search(Point a, Point b, Point t)
	{
		long op1 = (t.dy- a.dy)*(b.dx-a.dy);
		long op2 = (b.dy - a.dy)*(t.dx-a.dx);
		if(op1 == op2) return true;
		else return false;
	}
	public static int ccw(Point a, Point b, Point c)
	{
		long op = ( (a.dx*b.dy)+(b.dx*c.dy)+(c.dx*a.dy) ) - ( (a.dy*b.dx)+(b.dy*c.dx)+(c.dy*a.dx) );
		if(op > 0 ) return 1;
		else if(op < 0) return -1;
		else return 0;
	}
	static class Line {
		Point p1, p2, p_min, p_max;
		Line(long dx1, long dy1, long dx2, long dy2) {
			p1 = new Point(dx1, dy1);
			p2 = new Point(dx2, dy2);
			p_min = new Point(min(dx1, dx2), min(dy1, dy2));
			p_max = new Point(max(dx1, dx2), max(dy1, dy2));
		}
	}
	static class Point {
		long dx, dy;
		Point (long a, long b) {
			dx=a; dy=b;
		}
	}
	public static long max(long a, long b) { return a > b ? a : b; }
	public static long min(long a, long b) { return a > b ? b : a; }
}
