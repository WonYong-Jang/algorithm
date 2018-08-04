package com.company.sds;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 카카오 예선 (상금 ) 
 *
 */
public class Kakao_reward {

	static int[][] past = new int[7][2]; // 0 상금 , 1은 인원 
	static int[][] year = new int[6][2];
	static int T, N, M; // 과거 ,현재 등수 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		past[1][0] = 5000000; past[1][1] = 1; // 상금 기준 셋팅 
		past[2][0] = 3000000; past[2][1] = 3;
		past[3][0] = 2000000; past[3][1] = 6;
		past[4][0] = 500000; past[4][1] = 10;
		past[5][0] = 300000; past[5][1] = 15;
		past[6][0] = 100000; past[6][1] = 21;
		
		year[1][0] = 5120000; year[1][1] = 1; // 현재 상금 기준 
		year[2][0] = 2560000; year[2][1] = 3;
		year[3][0] = 1280000; year[3][1] = 7;
		year[4][0] = 640000; year[4][1] = 15;
		year[5][0] = 320000; year[5][1] = 31;
		
		for(int k=1; k <= T; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int pastSum =0, yearSum=0;
			for(int i=1; i<=6; i++) // 과거 등수 계산 
			{
				if(past[i][1] < N  || N == 0) continue;
				pastSum = past[i][0];
				break;
			}
			
			for(int i=1; i<=5; i++) // 현재  등수 계산 
			{
				if(year[i][1] < M || M ==0) continue;
				yearSum = year[i][0];
				break;
			}
			
			System.out.println(pastSum+yearSum);
		}
	}

}


