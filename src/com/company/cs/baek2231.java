package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분해합   
 */
public class baek2231 {

	static int N, result =0;
	static final int MAX = 1000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int digit =0, value =0, sum =0;
		for(int i=10; i<= MAX; i++)
		{
			sum=0;
			digit = i;
			while(digit > 0) // 각 자릿수 더하기   
			{
				value = digit % 10;
				digit /= 10;
				sum += value;
			}
			if(sum+i == N) { // 최소인경우 바로 break  
				result = i;
				break;
			}
		}
		System.out.println(result);
	}

}
