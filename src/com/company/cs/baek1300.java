package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * k 번째 수 
 */
public class baek1300 {

	static int N;
	static long K;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Long.parseLong(st.nextToken());
		
		long s=1, e= K, mid =0, ans = 0;
		while( s <= e) // parametric search
		{
			mid = (s + e )/ 2;
			long cnt =0;
			
			for(int i=1; i<= N; i++)
			{
				cnt += min(N, mid / i);
			}
			if(cnt < K) s = mid + 1;
			else {
				e = mid-1;
				ans = mid;
			}
			
		}
		System.out.println(ans);
	}
	public static long min(long a, long b) { return a > b ? b : a; } 
}
