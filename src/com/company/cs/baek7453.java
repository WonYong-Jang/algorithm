package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 합이 0인 네 정수 
 */
public class baek7453 {

	static final int max_node = 4001*4002;
	static int N;
	static long result;
	static long[][] data = new long[4005][5];
	static long[] A = new long[max_node];
	static long[] B = new long[max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= 4; j++)
			{
				data[i][j] = Long.parseLong(st.nextToken());
			}
		}

		result = 0;
		int index = 1;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				A[index] = data[i][1] + data[j][2];
				B[index] = data[i][3] + data[j][4];
				index++;
			}
		}
		Arrays.sort(B, 1, index);
		
		long target =0, cnt =0;
		for(int i=1; i< index; i++)
		{
			target = A[i] * -1;
			cnt = upper_bound(1, index, target) - lower_bound(1, index, target);
			result += cnt;
		}
		
		System.out.println(result);
	}
	public static int lower_bound(int s, int e, long target)
	{
		int mid = 0;
		while(s < e)
		{
			mid = (s + e) / 2;
			if(B[mid] < target) {
				s = mid + 1;
			}
			else e = mid;
		}
		return e;
	}
	public static int upper_bound(int s, int e, long target)
	{
		int mid = 0;
		while(s < e)
		{
			mid = (s + e) / 2;
			if(B[mid] <= target) {
				s = mid + 1;
			}
			else e = mid;
		}
		return e;
	}
}
