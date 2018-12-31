package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 달리기 
 */
public class baek2517 {

	static int N;
	static long result;
	static final int max_node = 1000005;
	static Node[] data = new Node[max_node];
	static Node[] temp = new Node[max_node];
	static int[] ans = new int[max_node];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int num =0, rank =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			data[i] = new Node(num, i);
			ans[i] = 1;
		}
		mergeSort(1, N);
		
		for(int i=1; i<= N; i++)
		{
			bw.write(ans[i]+"\n");
		}
		bw.flush();
		
	}
	public static void merge(int left, int mid, int right)
	{
		for(int i=left; i<= right; i++) temp[i] = data[i];
		int i, j, k;
		i = k = left;
		j = mid+1;
		
		while(i<= mid && j <= right)
		{
			if(temp[i].num <= temp[j].num) data[k++] = temp[i++];
			else
			{
				int cnt = mid- i + 1;
				ans[temp[j].rank] += cnt;
				data[k++] = temp[j++]; 
			}
		}
		
		while(i <= mid) data[k++] = temp[i++];
		while(j <= right) data[k++] = temp[j++];
	}
	public static void mergeSort(int left, int right)
	{
		int mid =0;
		if(left < right)
		{
			mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	static class Node {
		int num, rank;
		Node(int a, int b) {
			num=a; rank=b;
		}
	}
}
