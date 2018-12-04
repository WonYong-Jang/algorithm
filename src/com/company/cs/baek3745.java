package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오름세 
 */
public class baek3745 {

	static int N;
	static int[] data = new int[100005];
	static int[] dp = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = "";
		while((str = br.readLine()) != null)
		{
			
			N = Integer.parseInt(str.trim());
			st = new StringTokenizer(br.readLine().trim());
			
			for(int i=1; i<= N; i++)
			{
				data[i] = Integer.parseInt(st.nextToken());
				dp[i] = 0;
			}
			
			int size = 1;
			dp[1] = data[1];
			for(int i=2; i<= N; i++)
			{
				if(dp[size] < data[i])
				{
					dp[++size] = data[i];
				}
				else 
				{
					int idx = lower_bound(1, size, data[i]);
					dp[idx] = data[i];
				}
			}
			System.out.println(size);
		}
		
	}
	public static int lower_bound(int low, int high, int target)
	{
		int mid=0, result =0;
		
		while(low <= high)
		{
			mid = ( low + high ) / 2;
			
			if(dp[mid] < target)
			{
				low = mid + 1;
			}
			else {
				high = mid - 1;
				result = mid;
			}
		}
		
		return result;
	}
}




