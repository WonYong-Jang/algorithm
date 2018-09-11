package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 거듭제곱 계산하기 
 */
public class baek2074 {

	static long N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		long index = 0, sum = 1, temp = 1, cnt = 1;
		
		while( N > (1 << index) )
		{
			if(index ==0) temp = 2;
			else temp *= temp;
			cnt++;
			if( (N & (1 << index)) > 0)
			{
				sum *= temp;
			}
			index++;
		}
	
		System.out.println(sum+" "+cnt);
	}

}
