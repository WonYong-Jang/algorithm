package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 고장 난 시계
0 0 0 0 1 1 0   1 1 1 1 1 1 1   1 1 1 1 1 1 0   1 1 1 1 1 1 1
1 1 1 1 1 1 0   1 1 1 1 1 1 1   1 0 1 1 0 1 1   1 1 1 1 1 0 1
0 0 0 0 1 1 0   1 1 0 1 1 1 1   1 0 0 1 1 1 1   0 0 1 1 0 1 0 
 */
public class sds_clock {
	
	// 0 ~ 9 번 숫자 각각 7 세그멘트로 구성 되어 있음  int[10][7]
	static int[] number = {126 ,6 ,91, 79, 39, 109, 125, 70, 127, 111};
	static int[] arr = new int[128]; // 1 ~ 127// 0 ~ 9 숫자 정보 기록 
	static int[] reverse = {1 , 0}; // 1 -> 0 // 0 -> 1
	static final int N = 28, K =7;
	static int[] clock = new int[N+1]; // input
	static int[] disit = {600 , 60 ,10 , 1};
	static int min;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		init(); // setting 
		
		for(int k=1; k<= testCase; k++)
		{
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= N; i++)
			{
				clock[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Math.min(calculate(), min); // 0번 세그먼트 
			for(int i=1; i<= N; i++) // 1번 세그먼트 
			{
				clock[i] = reverse[clock[i]]; // 바꾸기 
				min = Math.min(calculate(), min); // 0번 세그먼트
				clock[i] = reverse[clock[i]]; // 원래대로 
			}
			
			for(int i=1; i<= N-1; i++)
			{
				for(int j= i+1 ;j <= N; j++)
				{
					clock[i] = reverse[clock[i]];
					clock[j] = reverse[clock[j]];
					min = Math.min(calculate(), min); // 0번 세그먼트
					clock[i] = reverse[clock[i]];
					clock[j] = reverse[clock[j]];
				}
			}
			int r1= min / 60;
			int r2 = min % 60;
			System.out.println("#"+k+" "+r1+" "+r2);
			
		}
	}
	public static int calculate() // 전체 계산 
	{
		int checkNum =0, total =0, index =1; 
		for(int i=0; i< 4; i++)
		{
			for(int j=0; j< K; j++)
			{
				if( clock[index] == 1) 
				{
					checkNum += (64 >> j);
				}
				index++;
			}
			if(arr[checkNum] == 1 ) 
			{
				for(int j=0; j< 10; j++)
				{
					if( number[j] == checkNum) total += ( j* disit[i]);
				}
			}
			else return Integer.MAX_VALUE; // 잘못된 숫자 정보
			 
			checkNum = 0;
		}
		return total;
	}
	public static void init() // 처음 초기화 비트 마스크 이용 ! 
	{
		for(int i=0; i<10; i++)
		{
			arr[number[i]]++;
		}
	}
}



/**
	static int[][] clocks = {{1, 1, 1, 1, 1, 1, 0}, // 0   
							 {0, 0, 0, 0, 1, 1, 0}, // 1
							 {1, 0, 1, 1, 0, 1, 1}, // 2
							 {1, 0, 0, 1, 1, 1, 1}, // 3
							 {0, 1, 0, 0, 1, 1, 1}, // 4
							 {1, 1, 0, 1, 1, 0, 1}, // 5
							 {1, 1, 1, 1, 1, 0, 1}, // 6
							 {1, 0, 0 ,0, 1, 1, 0}, // 7
							 {1, 1, 1, 1, 1, 1, 1}, // 8
							 {1, 1, 0, 1, 1, 1, 1} }; // 9
 */







