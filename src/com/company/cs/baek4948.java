package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 베트르랑 공준 
 */
public class baek4948 {

	static int N, index;
	static final int max_node = 123456 * 2;
	static int[] data = new int[max_node + 5];
	static int[] prime = new int[max_node + 5];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int i=2; i<= max_node; i++) data[i] = i;
		
		index = 0;
		for(int i=2; i<= max_node; i++)
		{
			if(data[i] == 0) continue;
			prime[++index] = i;
			for(int j = i+i; j<= max_node; j += i)
			{
				if(data[j] == 0 ) continue;
				data[j] = 0;
			}
		}
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			int cnt = upper_bound(1,index+1, N*2) - upper_bound(1,index+1, N); 
			System.out.println(cnt);
		}
	}
	public static int upper_bound(int s, int e, int target)
	{
		int mid =0;
		while( s < e)
		{
			mid = (s + e) / 2;
			if(prime[mid] <= target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
}
