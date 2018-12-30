package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 두 배열의 합 
 */
public class baek2143 {

	static int T, N, M;
	static long result;
	static int[] A = new int[1005];
	static int[] B = new int[1005];
	static ArrayList<Integer> arrA = new ArrayList<>();
	static ArrayList<Integer> arrB = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= M; i++)
		{
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum =0;
		for(int i=1; i<= N; i++)
		{
			arrA.add(A[i]);
			sum = A[i];
			for(int j= i+1; j<= N; j++)
			{
				sum += A[j];
				arrA.add(sum);
			}
		}
		
		for(int i=1; i<= M; i++)
		{
			arrB.add(B[i]);
			sum = B[i];
			for(int j= i+1; j<= M; j++)
			{
				sum += B[j];
				arrB.add(sum);
			}
		}
		Collections.sort(arrA);
		Collections.sort(arrB);
		result = 0;
		for(int i=0; i< arrA.size(); i++)
		{
			int diff = T - arrA.get(i);
			int cnt = upper_bound(0, arrB.size(), diff) - lower_bound(0, arrB.size(), diff);
			result += cnt;
		}
		System.out.println(result);
	}
	public static int lower_bound(int s, int e, int target)
	{
		int mid =0;
		while( s < e)
		{
			mid = (s + e) / 2;
			if(arrB.get(mid) < target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
	public static int upper_bound(int s, int e, int target)
	{
		int mid =0;
		while( s < e)
		{
			mid = (s + e) / 2;
			if(arrB.get(mid) <= target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
}
