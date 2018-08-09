package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 보물 
 */
public class baek1026 {

	static final int INF = 50 * 105;
	static int ans = INF;
	static int[] A = new int[51];
	static int[] B = new int[51];
	static int[] visited= new int[51];
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); // A 배열 input
		for(int i=1; i<= N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); // B 배열 input 
		for(int i=1; i<= N; i++) B[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A, 1, N+1);
		Arrays.sort(B, 1, N+1);
		
		int temp =0;
		for(int i=1; i<= N; i++)
		{
			temp += (A[i]* B[N-i+1]);
		}
		System.out.println(temp);
	}
	
	public static int min(int a, int b)
	{
		return a>b?b:a;
	}
}
