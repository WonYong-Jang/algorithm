package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 시험 감독 
 */
public class baek13458 {

	static int N, B, C, result; 
	static final int MAX = 1000002;
	static int[] map = new int[MAX]; // 각 방마다 응시자 수 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			map[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken()); // 총감독  
		C = Integer.parseInt(st.nextToken()); // 부감독 
		int num =0;
		setting(); // 미리 총감독 수 제외하고 확인 
		result = N;
		for(int i=1; i<= N; i++)
		{
			if(map[i] > 0 )
			{
				if(map[i] % C !=0) {
					result++;
				}
				result += ( map[i] / C ) ;
				
			}
		}
		System.out.println(result);
	}
	
	public static void setting()
	{
		for(int i=1; i<= N; i++)
		{
			map[i] -= B;
		}
	}
}
