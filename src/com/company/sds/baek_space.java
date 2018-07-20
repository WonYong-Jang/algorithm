package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 순환 공간 
 */
public class baek_space {

	static int N, M, dx, dy, nx, ny, minDis; // 배열 크기, 시작점, 끝점 위치, 최소 거리  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase ; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			nx = Integer.parseInt(st.nextToken());
			ny = Integer.parseInt(st.nextToken());
			minDis = Integer.MAX_VALUE;
			
			int tempDis = Math.abs(dx - nx) + Math.abs(dy - ny); // 배열 범위를 넘어가지 않고 구한 거리 
			
			minDis = Integer.min(minDis, tempDis);
			
			
			
		}
	}
	
}
