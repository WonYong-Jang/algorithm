package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 전화 상담 
 */
public class sds_consulting {

	static int N, K, L; // 고객의 수, 최소 상담 시간, 수진이의 근무 시간 
	static int[][] map; // 0 인덱스 : 고객이 원하는 상담 시간,  1인덱스 : 부족한 상담시간 1분당 불만족 지수 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][2]; // 0 ~ N-1 ; 
			for(int i=0; i< N; i++)
			{
				st = new StringTokenizer(br.readLine());
				int min = Integer.parseInt(st.nextToken());
				int lack = Integer.parseInt(st.nextToken());
				map[i][0] = min;
				map[i][1] = lack;
			}
			
		}
	}
	public static void solve(int curIdx, int curMin) // 현재 고객 상담 인덱스 ,남아있는 근무시간 
	{
		
	}
}
