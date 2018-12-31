package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Counting Inversions
 */
public class baek10090 {

	static int N;
	static long result;
	static int[] data = new int[1000005];
	static int[] temp = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result =0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(1, N);
		
		System.out.println(result);
	}
	public static void merge(int left, int mid, int right)
	{
		for(int i=left; i<= right; i++) temp[i] = data[i];
		
		int i=0, j=0, k=0;
		i = k = left;
		j = mid+1;
		
		while(i <= mid && j <= right)
		{
			if(temp[i] <= temp[j]) data[k++] = temp[i++];
			else // Inversions 발생 
			{
				data[k++] = temp[j++];
				result += ( mid-i+1 );
			}
		}
		
		while(i <= mid) data[k++] = temp[i++];
		while(j <= right) data[k++] = temp[j++];
	}
	public static void mergeSort(int left, int right)
	{
		int mid = 0;
		if(left < right)
		{
			mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
}
