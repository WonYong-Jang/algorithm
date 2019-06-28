package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 공장 
 */
public class baek7578 {

	static long result;
	static final int max_value = 500001;
	static int N;
	static int[] map = new int[max_value];
	static int[] temp = new int[max_value];
	static HashMap<Integer, Integer> set = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		result = 0;
		int num = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			set.put(num, i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			map[i] = set.get(num);
		}
		mSort(1, N);
		System.out.println(result);
	}
	public static void mSort(int s, int e)
	{
		if(s == e) return;
		
		int mid = (s+e)/2;
		mSort(s, mid);
		mSort(mid+1, e);
		merge(s,e);
	}
	public static void merge(int s, int e)
	{
		for(int i=s; i<=e; i++)
		{
			temp[i] = map[i];
		}
		int i =0, j=0, k=0, mid =0;
		
		mid = (s + e) / 2;
		i = k = s;
		j = mid+1;
		
		while(i <= mid && j <= e)
		{
			if(temp[i] <= temp[j]) map[k++] = temp[i++];
			else {
				result += (mid-i+1);
				map[k++] = temp[j++];
			}
		}
		
		while(i <= mid) map[k++] = temp[i++];
		while(j <= e) map[k++] = temp[j++];
	}
}
