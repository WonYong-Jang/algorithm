package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baek11004 {

	static int N, K;
	static final int max_node = 5000005;
	static int[] data = new int[max_node];
	static int[] temp = new int[max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(1, N);
		
		System.out.println(data[K]);
	}
	public static void mergeSort(int s, int e)
	{
		if(s == e) return;
		
		int mid = (s + e) / 2;
		mergeSort(s, mid);
		mergeSort(mid+1, e);
		merge(s,e, mid);
	}
	public static void merge(int left, int right, int m)
	{
		for(int i=left; i<= right; i++) temp[i] = data[i];
		
		int i=0,j=0,k=0;
		i = k= left;
		j= m+1;
		
		while(i <= m && j <= right)
		{
			if(temp[i] < temp[j]) data[k++] = temp[i++];
			else data[k++] = temp[j++];
		}
		
		while(i <= m) data[k++] = temp[i++];
		while(j <=right) data[k++] = temp[j++];
	}
}






