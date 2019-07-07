package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 선 긋기 
 */
public class baek2170 {

	static int N;
	static Point[] p = new Point[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx =0, dy =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Point((long)dx,(long)dy);
		}
		Arrays.sort(p, 1, N+1, new mySort());
		long result = 0;
		long start = 0, end = 0, target = 0;
		start = p[1].dx;
		end = p[1].dy;
		for(int i=2; i<= N; i++)
		{
			target = p[i].dx;
			if(start <= target && target <= end)
			{
				end = end > p[i].dy ? end : p[i].dy;
			}
			else
			{
				result += (end - start);
				start = p[i].dx;
				end = p[i].dy;
			}
		}
		result += (end - start);
		System.out.println(result);
	}
	static class mySort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else return 0;
		}
	}
	static class Point {
		long dx, dy;
		Point(long a, long b) {
			dx=a; dy=b;
		}
	}
}	
