package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 부분집합의 합 2   
 * 2^40 은 약 1조에 가깝기 때문에 절반으로 나눠서 계산  
 */
public class baek1208 {

	public static int[] arr = new int[41];
	public static int N, S, cnt, A, B;
	public static ArrayList<Integer> arr1 = new ArrayList<>();
	public static ArrayList<Integer> arr2 = new ArrayList<>();
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
		A = N/2;
		B = N-A;
		Collections.sort(arr1);
		Collections.sort(arr2);
		
		System.out.println(cnt);
	}
	public static void subSet(ArrayList<Integer> arr) {
		int len = arr.size(), sum=0;
		for(int i=1; i< (1<<len); i++)
		{
			sum =0;
			for(int j=0; j< len; j++)
			{
				if(  (i&(1<<j) ) != 0)
				{
					sum += arr.get(j);
				}
			}
			
		}
		
	}
}












