package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 삽입 정렬 
 */
public class insertionSort {

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
		
		int j=0;
		for(int i=1; i< N; i++) // 두번째 인덱스 부터 시작 
		{
			j= i -1;
			int target = data[i]; // 삽입할 숫자 
			while(j >= 0 && data[j] > target) // target 위치 찾기 
			{
				data[j+1] = data[j]; // target 보다 큰 숫자 앞으로 한칸 씩 당기기 
				j--;
			}
			data[j+1] = target; // 자리 삽입 
		}
		
		for(int i=0 ; i< N; i++)
		{
			System.out.println(data[i]);
		}
	}
}










