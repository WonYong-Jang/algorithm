package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분집합의 합  
 *
 */
public class baek1182 {

	public static int N, S, cnt;
	public static int[] arr = new int[21];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		subSet();
		System.out.println(cnt);
	}
	public static void subSet() 
	{
		cnt =0;
		int sum =0;
		for(int i=1; i< (1 << N); i++) // 1 ~ 31 공집합 제외 
		{
			sum =0;
			for(int j=0; j < N; j++)
			{
				if( (i & (1 << j)) != 0)
				{
					sum += arr[j];
				}
			}
			if(sum == S) cnt++;
		}
	}
}





