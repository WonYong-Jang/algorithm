package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PIZZA ALVOLOC
 */
public class baek12781 {

	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dx1 = 0, dy1 = 0, dx2= 0, dy2 = 0, dx3 = 0, dy3 = 0, dx4 = 0, dy4 = 0;
		dx1 = Integer.parseInt(st.nextToken());
		dy1 = Integer.parseInt(st.nextToken());
		
		dx2 = Integer.parseInt(st.nextToken());
		dy2 = Integer.parseInt(st.nextToken());
		
		dx3 = Integer.parseInt(st.nextToken());
		dy3 = Integer.parseInt(st.nextToken());
		
		dx4 = Integer.parseInt(st.nextToken());
		dy4 = Integer.parseInt(st.nextToken());
		
		int abc = ccw(dx1,dy1,dx2,dy2,dx3,dy3);
		int abd = ccw(dx1,dy1,dx2,dy2,dx4,dy4);
		int cda = ccw(dx3,dy3,dx4,dy4,dx1,dy1);
		int cdb = ccw(dx3,dy3,dx4,dy4,dx2,dy2);
		
		int ans = 0;
		
		if(abc*abd <0 && cda*cdb < 0) ans = 1;
		/*
		if(abc*abd ==0 && cda*cdb == 0) {	
			Line line1 = new Line(dx1,dy1,dx2,dy2);
			Line line2 = new Line(dx3,dy3,dx4,dy4);
			if(line1.p_max.dx < line2.p_min.dx||
		               line2.p_max.dx < line1.p_min.dx||
		               line1.p_max.dy < line2.p_min.dy||
		               line2.p_max.dy < line1.p_min.dy) ans = 0;
		}
		*/
		System.out.println(ans);
	}
	public static int ccw(int dx1, int dy1, int dx2, int dy2, int dx3, int dy3)
	{
		int op =( (dx1*dy2)+(dx2*dy3)+(dx3*dy1) ) - ( (dy1*dx2)+(dy2*dx3)+(dy3*dx1) );
		if(op < 0) return -1;
		else if(op > 0) return 1;
		else return 0;
		
	}
	static class Line {
		Point p1, p2, p_min, p_max;
		Line(int a, int b, int c, int d) {
			p1 = new Point(a,b);
			p2 = new Point(c,d);
			p_min = new Point(min(a,c), min(b,d));
			p_max = new Point(max(a,c), max(b,d));
		}
	}
	static class Point {
		int dx, dy;
		Point(int a, int b) { 
			dx=a; dy=b;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int min(int a, int b) { return a > b ? b : a; }
}
