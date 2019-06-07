package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 교차 
 */
public class baek6439 {

	static long dx1, dy1, dx2, dy2;
	static Line line;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=0; k< testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			dx1 = Long.parseLong(st.nextToken());
			dy1 = Long.parseLong(st.nextToken());
			dx2 = Long.parseLong(st.nextToken());
			dy2 = Long.parseLong(st.nextToken());
			line = new Line(dx1, dy1, dx2, dy2);
			dx1 = Long.parseLong(st.nextToken());
			dy1 = Long.parseLong(st.nextToken());
			dx2 = Long.parseLong(st.nextToken());
			dy2 = Long.parseLong(st.nextToken());
			Line RectLine = new Line(min(dx1,dx2),min(dy1,dy2),max(dx1,dx2),max(dy1,dy2));
			
			if(isCross(dx1,dy1,dx2,dy1) || isCross(dx1,dy2,dx2,dy2) || isCross(dx2,dy2,dx2,dy1) || 
					isCross(dx1,dy1,dx1,dy2) || isRect(RectLine, line))
			{
				bw.write("T\n");
			}
			else
			{
				bw.write("F\n");
			}
		}
		bw.flush();
	}
	public static boolean isRect(Line rect, Line line)
	{
		if(rect.p_min.dx <= line.p_min.dx && rect.p_min.dy <= line.p_min.dy && 
				rect.p_max.dx >= line.p_max.dx && rect.p_max.dy >= line.p_max.dy) return true;
		else return false;
	}
	public static boolean isCross(long dx1, long dy1, long dx2, long dy2)
	{
		Line target = new Line(dx1, dy1, dx2, dy2);
		int ab = ccw(line.p1, line.p2, target.p1) * ccw(line.p1, line.p2, target.p2);
		int cd = ccw(target.p1, target.p2, line.p1) * ccw(target.p1, target.p2, line.p2);
		
		if(ab == 0 && cd == 0)
		{
			if(line.p_max.dx < target.p_min.dx ||
				line.p_max.dy < target.p_min.dy ||
				target.p_max.dx < line.p_min.dx ||
				target.p_max.dy < line.p_min.dy ) return false;
		}
		
		return (ab <= 0 && cd <= 0);
	}
	public static int ccw(Point a, Point b, Point c)
	{
		long op = (a.dx*b.dy + b.dx*c.dy + c.dx*a.dy) - (a.dy*b.dx + b.dy*c.dx + c.dy*a.dx);
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
			p_max = new Point(max(dx1, dx2), max(dx1, dy2));
		}
	}
	static class Point {
		long dx, dy;
		Point(long a, long b) {
			dx=a; dy=b;
		}
	}
	public static long max(long a, long b) { return a > b ? a : b; }
	public static long min(long a, long b) { return a > b ? b : a; }
}
