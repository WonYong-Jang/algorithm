package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] data = new int[1000005];
	static int[] temp = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(1, N);
		
		for(int i=1; i<= N; i++)
		{
			bw.write(data[i]+"\n");
		}
		bw.flush();
	}
	public static void mergeSort(int s, int e)
	{
		if(s >= e) return;
		
		int mid = (s + e) / 2;
		
		mergeSort(s, mid);
		mergeSort(mid+1,e);
		mSort(s, e, mid);
		
	}
	public static void mSort(int s, int e, int mid)
	{
		for(int i = s; i <= e; i++)
		{
			temp[i] = data[i];
		}
		int i, j, k;
		i = k = s;
		j = mid + 1;
		while(i <= mid && j <= e)
		{
			if(temp[i] < temp[j]) data[k++] = temp[i++];
			else data[k++] = temp[j++];
		}
		
		while(i <= mid)
			data[k++] = temp[i++];
		while(j <= e)
			data[k++] = temp[j++];
		
	}
}

