package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 
 */
public class baek2581 {

	static final int max_node = 10000;
	static int M, N;
	static int[] data = new int[max_node+1];
	static int[] prime = new int[max_node+1];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int index = 0;
		
		for(int i=2; i<= max_node; i++) data[i] = i;
		
		for(int i=2; i<= max_node; i++)
		{
			if(data[i] == 0) continue;
			prime[++index] = i;
			for(int j= i + i; j<= max_node; j += i)
			{
				if(data[j] == 0) continue;
				data[j] = 0;
			}
		}
		
		int sdx = lower_bound(1, index+1,M);
		int edx = lower_bound(1, index+1,N);
		int sum =0, minValue = -1;
		for(int i=sdx; i<= edx; i++)
		{
			if(prime[i] >= M && prime[i] <= N)
			{
				sum += prime[i];
				if(i == sdx) minValue = prime[i];
			}
		}
		if(minValue == -1) System.out.println(-1);
		else {
			System.out.println(sum+"\n"+minValue+"\n");
		}
	}
	public static int lower_bound(int s, int e, int target)
	{
		int mid = 0;
		while(s < e)
		{
			mid = (s + e) / 2;
			if(prime[mid] < target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
}
