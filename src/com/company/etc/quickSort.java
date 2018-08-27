package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 퀵 소트 ( pivot 개선된 퀵소트  ) 
 */
public class quickSort {

	static int N;
	static int[] data = new int[1000005];
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
		qSort(0, N-1);
		
		for(int i=0; i< N; i++)
		{
			bw.write(data[i]+"\n");
		}
		bw.flush();
	}
	public static void qSort(int left, int right)
	{
		if(left >= right) return;
		
		int pivot = partition(left, right);
		qSort(left, pivot-1);
		qSort(pivot+1, right);
	}
	public static int partition(int left, int right) // pivot 
	{
		int mid = (left + right) / 2;
	    int temp = data[mid];
	    data[mid] = data[left];
	    data[left] = temp;
		
		int j = left ; // 처음은 pivot 의 위치 ! 
		int pivot = data[left];
		for(int i= left+1; i<= right; i++)
		{
			if(data[i] < pivot) 
			{
				j++; // 왼쪽에는 pivot 보다 작은 값들로 바뀌게 됨 !
				temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		temp = data[j];
		data[j] = data[left];
		data[left] = temp;
		
		return j;
	}
}






