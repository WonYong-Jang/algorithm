package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 큐 ( 직접 구현 )
 */
public class baek10845 {

	static int N, end=0, start=1;
	static int[] que = new int[100002];
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
			else if(str.equals("pop")) pop();
			else if(str.equals("front")) front();
			else if(str.equals("back")) back();
			else if(str.equals("size")) size();
			else if(str.equals("empty")) empty();
		}
	}
	public static void push(int num)
	{
		que[++end] = num;
	}
	public static void pop()
	{
		if(que[start] == 0) System.out.println(-1);
		else {
			System.out.println(que[start]);
			que[start++] =0; 
		}
	}
	public static void front()
	{
		if(que[start] == 0) System.out.println(-1);
		else System.out.println(que[start]);
	}
	public static void back()
	{
		if(que[end] == 0 ) System.out.println(-1);
		else System.out.println(que[end]);
	}
	public static void size()
	{
		if(que[start] ==0 ) System.out.println(0);
		else System.out.println(end-start+1);
	}
	public static void empty()
	{
		if(que[start] ==0) System.out.println(1);
		else System.out.println(0);
	}
}
