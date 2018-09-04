package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 입국 심사 ( 이분 탐색 ) 
 */
public class baek3079 {

	static int N, M;
	static long ans =0;
	static long[] data = new long[100005];
	static long[] temp = new long[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Long.parseLong(st.nextToken());
		}
		mSort(1, N);
		binarySearch(1, data[N]* M);
		System.out.println(ans);
	}
	public static void binarySearch(long left, long right)
	{
		if(left > right) return;
		long mid = (left + right) / 2;
		long sum =0;
		
		for(int i = 1; i<= N; i++)
		{
			long temp = mid / data[i];
			if(temp == 0) break;
			sum += temp;
		}
		
		if(sum > M)  {
			ans = mid; // 답 가능성 
			binarySearch(left,mid-1);
		}
		else if(sum < M) {
			binarySearch(mid+1, right);
		}
		else if(sum == M) {
			ans = mid;
			binarySearch(left,mid-1);
		}
		
	}
	public static void mSort(int left, int right)
	{
		if(left >= right) return;
		int mid = (left + right) / 2;
		
		mSort(left, mid);
		mSort(mid+1, right);
		merge(left,mid,right);
	}
	public static void merge(int left, int mid, int right)
	{
		for(int i=left; i<= right; i++) temp[i] = data[i];
		
		int i =0, j =0, k = 0;
		i = k = left;
		j = mid+1;
		
		while(i <= mid && j <= right)
		{
			if(temp[i] < temp[j]) data[k++] = temp[i++];
			else data[k++] = temp[j++];
		}
		
		while(i <= mid) data[k++] = temp[i++];
		while(j <= right) data[k++] = temp[j++];
		
	}
}





