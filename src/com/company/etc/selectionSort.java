package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class selectionSort {

	static int N;
	static int[] data = new int[1001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i< N; i++) // input 
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		for(int i= 0; i< N-1; i++)
		{
			for(int j = i+ 1; j < N; j++)
			{
				if(data[i] > data[j])
				{
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
		for(int i=0; i< N; i++)
		{
			System.out.println(data[i]);
		}
	}

}
