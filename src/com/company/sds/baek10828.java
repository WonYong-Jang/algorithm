package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스택 ( 직접 구현 ) 
 */
public class baek10828 {

	static int N, index=0;
	static int[] stack = new int[100002];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int num =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				push(num);
			}
			else if(str.equals("top")) top();
			else if(str.equals("size")) size();
			else if(str.equals("empty")) empty();
			else if(str.equals("pop")) pop();
		}
	}
	public static void push(int num) // push 
	{
		stack[++index] = num;
	}
	public static void top()
	{
		if(index == 0) System.out.println(-1);
		else System.out.println(stack[index]);
	}
	public static void size()
	{
		System.out.println(index);
	}
	public static void empty()
	{
		if(index ==0) System.out.println(1);
		else System.out.println(0);
	}
	public static void pop()
	{
		if(index ==0) System.out.println(-1);
		else {
			System.out.println(stack[index--]);
		}
	}
}






