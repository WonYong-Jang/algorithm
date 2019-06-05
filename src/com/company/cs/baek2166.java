package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다각형의 면적 
 */
public class baek2166 {

	static int N;
	static Point[] point = new Point[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int dx = 0, dy = 0;
		for(int i = 0; i < 4; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			point[i] = new Point(dx,dy);
		}
		long result = ccw();
		result = result > 0 ? result : -1*result;
		System.out.print(result/2);
		if(result % 2 == 0) System.out.println(".0");
		else System.out.println(".5");
	}
	public static long ccw()
	{
		long op = 0;
		
		for(int i=0; i< N; i++)
		{
			op += (point[i].dx*point[(i+1)%N].dy)-(point[i].dy*point[(i+1)%N].dx);
		}
		
		return op;
	}
	static class Point {
		int dx, dy;
		Point(int a, int b) {
			dx=a; dy=b;
		}
	}
}
