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

	static int N, M, dx, dy, nx, ny; // 배열 크기, 시작점, 끝점 위치, 최소 거리  
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
			
			int rDx = Math.abs(dx - nx);
			int rDy = Math.abs(dy - ny);
			
			int temp =0;
			if(dx > nx) {
				temp = (N-dx) + nx;
			}
			else if(dx < nx) {
				temp = (N-nx) + dx;
			}
			else temp =0;
			rDx = Math.min(rDx, temp);
			
			if(dy > ny) {
				temp = (M-dy) + ny;
			}
			else if(dy < ny) {
				temp = (M-ny) + dy;
			}
			else temp =0;
			
			rDy = Math.min(rDy, temp);
			
			System.out.println("#"+k+" "+ (rDx+rDy) );
		}
	}
	
}
