package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * 힙 정렬 ( maxheap -> 오름 차순 ! ) 
 */
public class heapSort {

	static int N;
	static int[] data = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++) // input   1 ~ N 
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		hSort(N);
		
		for(int i=1; i<= N; i++)
		{
			bw.write(data[i]+"\n");
		}
		bw.flush();
	}
	public static void hSort(int n)
	{
		for(int i = n/2; i >=1; i--) // 자식을 가진 부모를 뒤에서 부터 업데이트 ! 
		{
			heapify(n, i);
		}
		
		for(int i= n; i>=2 ; i--)
		{
			swap(1, i); // 정렬된 가장 큰 값을 맨뒤 요소와 swap 
			heapify(i-1, 1); // 1 번부터 다시 힙 정렬 / 이때 전체 n 범위를 하나씩 줄여나감 ! 
		}
		
	}
	public static void heapify(int n, int i) // 힙 속성에 맞게 구성 
	{
		int p, left, right;
		p = i; // 노드의 자식노드들 중 큰 값을 올리기 위한 부모노드 인덱스 설정 
		left = i*2; // 왼쪽 자식
		right = i*2 +1; // 오른쪽 자식
		
		if(left <= n && data[p] < data[left]) p = left; // 두 자식들 중 큰 값 찾기 
		if(right <= n && data[p] < data[right]) p = right;
		
		if(p != i) // 값이 다르다는 얘기는 두 자식들 중 부모노드보다 큰값이 있어서 업데이트 필요하단 얘기 
		{
			swap(p, i);
			heapify(n, p); // 바뀐 값 자식들도 내려가면서 확인하기 위해 재귀 
		}
	}
	public static void swap(int a, int b)
	{
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
		
	}
}



