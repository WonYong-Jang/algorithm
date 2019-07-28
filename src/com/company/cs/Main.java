package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	static int N;
	static Point[] p = new Point[500005];
	static ArrayList<Point> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx=0, dy =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Point(dx,dy);
		}
		Arrays.sort(p, 1, N+1, new xSort());
		int result = solve(1, N);
		bw.write(result+"\n");
		bw.flush();
	}
	public static int solve(int start, int end)
	{
		int mid = (start + end) / 2, result = INF;
		
		if( (end-start+1) <= 2)
		{
			result = dis(p[start], p[end]);
			
			return result;
		}
		if( (end-start+1) <= 3)
		{
			result = min(dis(p[start], p[mid]) ,min( dis(p[mid], p[end]), dis(p[start], p[end])) );
			return result;
		}
		
		int d = min( solve(start, mid), solve(mid+1, end) );
		
		arr.clear();
		int t = 0;
		for(int i=start; i<= end; i++)
		{
			t = (p[mid].dx-p[i].dx)*(p[mid].dx-p[i].dx);
			if(t < d)
			{
				arr.add(p[i]);
			}
		}
		
		Collections.sort(arr, new ySort());
		result = d;
		for(int i=0; i< arr.size()-1; i++)
		{
			for(int j=i+1; j< arr.size() && (arr.get(j).dy - arr.get(i).dy) < result; j++)
			{
				d = dis(arr.get(j), arr.get(i));
				if(d < result)
				{
					result = d;
				}
			}
		}
		
		return result;
	}
	public static int dis(Point a, Point b)
	{
		return (a.dx-b.dx)*(a.dx-b.dx) + (a.dy-b.dy)*(a.dy-b.dy);
	}
	static class xSort implements Comparator<Point>
	{
		@Override
		public int compare(Point a, Point b) {
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else return 0;
		}	
	}
	static class ySort implements Comparator<Point>
	{
		@Override
		public int compare(Point a, Point b) {
			// TODO Auto-generated method stub
			if(a.dy < b.dy) return -1;
			else if(a.dy > b.dy) return 1;
			else return 0;
		}	
	}
	public static int max(int a, int b) { return a > b ? a: b; }
	public static int min(int a, int b) { return a > b ? b : a; }
	static class Point {
		int dx, dy;
		Point(int a, int b) {
			dx=a; dy=b;
		}
	}
}