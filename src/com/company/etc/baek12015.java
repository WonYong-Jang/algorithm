package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 2
 */
public class baek12015 {

	static int N, size;
	static int[] data = new int[1000005];
	static int[] dp = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		size = 1;
		dp[1] = data[1];
		for(int i=2; i<= N; i++)
		{
			if(data[i] > dp[size]) // dp 맨뒤에 있는 자리와 비교하여 더 큰값이면 이어 붙이기  
			{
				dp[++size] = data[i];
			}
			else if(data[i] < dp[size])
			{
				int tdx = lower_bound(1,size,data[i]);
				dp[tdx] = data[i];
			}
		}
		System.out.println(size);
	}
	public static int lower_bound(int s, int e, int target) // target 보다 같거나 큰 값을 찾는 과정
	{ 
		int mid =0, result = 0;
		while(s <= e)
		{
			mid = (s + e) / 2;
			if(dp[mid] < target) // 찾고자 하는 값보다 작다면 
			{
				s = mid+1;
			}
			else { // target 보다 크거나 같으므로 정답 가능성 
				e = mid-1;
				result = mid;
			}
		}
		return result;
	}
}






