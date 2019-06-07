package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 선분 그룹 
 */
public class baek2162 {

	static int N;
	static Line[] line = new Line[3005];
	static int[] par = new int[3005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx1=0, dy1=0, dx2 =0, dy2 =0;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx1= Integer.parseInt(st.nextToken());
			dy1= Integer.parseInt(st.nextToken());
			dx2= Integer.parseInt(st.nextToken());
			dy2= Integer.parseInt(st.nextToken());
			line[i] = new Line(dx1,dy1,dx2,dy2);
			par[i] = i;
		}
		
		for(int i=0; i< N-1; i++)
		{
			for(int j=i+1; j< N; j++)
			{
				if(isCross(line[i], line[j]))
				{
					union(i,j);
				}
			}
		}
		
		for(int i=0; i< N; i++)
		{
			find(i);
		}
		
		Arrays.sort(par,0,N);
		int num = par[0], maxCnt = 1, resultCnt =1, group = 1;
		
		for(int i=1; i< N; i++)
		{
			if(num != par[i])
			{
				maxCnt = 1;
				num = par[i];
				group++;
			}
			else if(num == par[i])
			{
				maxCnt++;
				resultCnt = max(resultCnt, maxCnt);
			}
		}
		
		bw.write(group+"\n");
		bw.write(resultCnt+"\n");
		bw.flush();
	}
	public static void union(int a, int b)
	{
		int ap = find(a);
		int bp = find(b);
		if(ap != bp) par[ap] = bp;
	}
	public static int find(int a)
	{
		if(par[a] == a) return a;
		else return par[a] = find(par[a]);
	}
	public static boolean isCross(Line a, Line b)
	{	
		int ab = ccw(a.p1, a.p2, b.p1)*ccw(a.p1, a.p2, b.p2);
		int cd = ccw(b.p1, b.p2, a.p1)*ccw(b.p1, b.p2, a.p2);
		
		if(ab == 0 & cd == 0)
		{
			if(a.p_max.dx < b.p_min.dx || 
				a.p_max.dy < b.p_min.dy ||
				b.p_max.dx < a.p_min.dx ||
				b.p_max.dy < a.p_min.dy) return false;
		}
		
		return (ab <= 0 && cd <= 0);
	}
	public static int ccw(Point a, Point b, Point c)
	{
		int op = ( ((a.dx*b.dy) + (b.dx*c.dy) + (c.dx*a.dy)) - ((a.dy*b.dx) + (b.dy*c.dx) + (c.dy*a.dx)));
		if(op > 0 ) return 1;
		else if(op < 0) return -1;
		else return 0;
		
	}
	static class Line {
		Point p1, p2, p_max, p_min;
		Line(int dx1, int dy1, int dx2, int dy2) {
			p1 = new Point(dx1,dy1);
			p2 = new Point(dx2, dy2);
			p_max = new Point(max(dx1,dx2), max(dy1,dy2));
			p_min = new Point(min(dx1,dx2), min(dy1,dy2));
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

