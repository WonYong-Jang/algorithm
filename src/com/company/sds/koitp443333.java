package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * 점의 위치 
 */
public class koitp443333 {

	static int N;
	static Point[] p = new Point[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long dx = 0, dy =0;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Long.parseLong(st.nextToken());
			dy = Long.parseLong(st.nextToken());
			p[i] = new Point(dx,dy);
		}
		
		for(int i=1; i<=2; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Long.parseLong(st.nextToken());
			dy = Long.parseLong(st.nextToken());
			
			if(isCross(dx,dy)) bw.write("in\n");
			else bw.write("out\n");
			
		}
		bw.flush();
	}
	public static boolean isCross(long tx, long ty)
	{
		int crossCnt = 0;
		long mindy =0, maxdy =0;
		for(int i=0; i< N; i++)
		{
			Point p1 = p[i];
			Point p2 = p[(i+1) % N];
			
			mindy = min(p1.dy, p2.dy);
			maxdy = max(p1.dy, p2.dy);
			
			if(mindy <= ty && maxdy >= ty) // 선분 y 좌표 사이에 있는지 확인 
			{
				 
				long tmp = p2.dy - p1.dy; // 분모가 0 일 경우 제외 
				if(tmp == 0) continue;
				// 점과 직선사이의 수선의 발 좌표 공식
				long target = (ty - p1.dy)*(p2.dx - p1.dx) / (p2.dy - p1.dy) + p1.dx;
				
				if(tx < target) crossCnt++;
			}
		}
		if(crossCnt % 2 != 0) return true;
		else return false;
	}
	public static long max(long a, long b) { return a > b ? a : b; }
	public static long min(long a, long b) { return a > b ? b : a; }
	static class Point {
		long dx, dy;
		Point(long a, long b) {
			dx=a; dy=b;
		}
	}
}
