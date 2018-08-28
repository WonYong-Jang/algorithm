package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 병합 정렬 
 */
public class mergeSort {

	static int N;
	static int[] data = new int[1000005];
	static int[] temp = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i< N; i++) // input 
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		mSort(0, N-1);
		for(int i=0; i< N; i++)
		{
			bw.write(data[i]+"\n");
		}
		bw.flush();
	}
	public static void mSort(int left, int right)
	{
		if(left == right) return;
		
		int mid = (left + right) / 2;
		mSort(left, mid);
		mSort(mid+1, right);
		merge(left, mid, right);
	}
	public static void merge(int left,int mid, int right)
	{
		for(int i= left; i<= right; i++)
			temp[i] = data[i];
		
		int i, j, k; 
		i = k = left; //temp 첫번째  시작 인덱스 i, data 시작 인덱스 k 
		j= mid+1; // temp 두번째 시작 인덱스 k
		
		while(i<= mid && j <= right)
		{
			if(temp[i] <= temp[j]) data[k++] = temp[i++];
			else data[k++] = temp[j++];
		}
		
		// 남은 배열은 그대로 넣기 
		while(i<= mid)
			data[k++] = temp[i++];
		while(j <= right)
			data[k++] = temp[j++];
		
	}
}








