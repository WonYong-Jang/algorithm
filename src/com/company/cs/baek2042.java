package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 
 */
public class baek2042 {

	static final int max = 1000005;
	static int N, M, K, sIndex, eIndex;
	static long[] data = new long[max*4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sIndex = 1;
		while(sIndex < N) sIndex *= 2; // 시작점 구하기
		
		eIndex = sIndex + N - 1;
		for(int i = sIndex; i<= eIndex; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Long.parseLong(st.nextToken());
		}
		
		// 초기화
		for(int i= eIndex/2; i > 0; i--)
		{
			data[i] = data[i*2]+ data[i*2+1];
		}
		
		for(int i=0; i < M+K; i++)
		{
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd == 1) change(a,b);
			else if(cmd == 2) cal(a,b);
		}
		
	}
	public static void change(int a, int b)
	{
		int dx = sIndex + a - 1;
		data[dx] = b;
		while(dx / 2 > 0)
		{
			dx /=2;
			data[dx] = data[dx*2] + data[dx*2+1];
		}
		
	}
	public static void cal(int a, int b)
	{
		int left = sIndex + a - 1;
		int right = sIndex + b - 1;
		
		long sum =0;
		while(left <= right)
		{
			if(left % 2 !=0 ) sum += data[left];
			left = (left+1) / 2;
			
			if(right % 2 ==0) sum += data[right];
			right = (right-1) /2;
		}
		System.out.println(sum);
	}
}




