package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 수의 합 
 */
public class baek3273 {

	static int N, K, result;
	static int[] data = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.sort(data, 1, N+1);
		
		int target = 0;
		for(int i=1; i<= N; i++)
		{
			target = K - data[i];
			if(target < 0 || i+1 > N) continue;
			if(search(i+1 , N, target)) result++;
		}
		System.out.println(result);
	}
	public static boolean search(int s, int e, int target)
	{
		int m = 0;
		
		while(s <= e)
		{
			m = (s + e) / 2;
			if(data[m] == target) return true;
			else if(data[m] < target) s = m + 1;
			else e = m - 1;
		}
		
		return false;
	}
}






