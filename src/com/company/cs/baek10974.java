package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 모든 순열 ( 정석 순열 )
 */
public class baek10974 {

	static int N;
	static int[] visit = new int[10];
	static int[] output = new int[10];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			visit[i] = 1;
			permutation(i, 1);
			visit[i] = 0;
		}
	}
	public static void permutation(int index , int depth)
	{
		output[depth] = index;
		
		if(depth == N)
		{
			for(int i=1; i<= N; i++)
			{
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<= N; i++)
		{
			if(visit[i]== 1) continue;
			visit[i] = 1;
			permutation(i, depth+1);
			visit[i] = 0;
		}
	}
	
}
