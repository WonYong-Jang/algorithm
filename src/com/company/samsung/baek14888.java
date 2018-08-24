package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연산자 끼워 넣기 
 */
public class baek14888 {

	static int N, maxValue, minValue;
	static int[] data = new int[12]; // 1 ~ 11 수의 갯수 
	static int[] op = new int[4]; // + - x /   ==>  연산 
	static int[] visit = new int[4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		maxValue = Integer.MIN_VALUE;
		minValue = Integer.MAX_VALUE;
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< 4; i++)
		{
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(1, data[1]); // 첫번째 데이터부터 
		System.out.println(maxValue+"\n"+minValue);
	}
	public static void solve(int index, int sum)
	{
		if(index == N) 
		{
			minValue = min(minValue, sum); // 최대값 최소값 각각 찾기 
			maxValue = max(maxValue, sum);
			return;
		}
		
		for(int i=0; i<4; i++) 
		{
			if(op[i] ==0 ) continue; // 연산자 갯수 0 개면 continue 
			int calValue = cal(sum, data[index+1], i); // 각 연산값 
			op[i]--;
			solve(index+1, calValue);
			op[i]++;
		}
		
	}
	public static int cal(int num1, int num2, int op)
	{
		int result =0;
		
		switch(op)
		{
		case 0:result = num1 + num2; break;
		case 1:result = num1 - num2; break;
		case 2:result = num1 * num2; break;
		case 3:result = num1 / num2; break;
		}
		
		return result;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}
