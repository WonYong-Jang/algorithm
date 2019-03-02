package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 랜선 자르기 
 */
public class baek1654 {

	static int N, K;
	static int[] data = new int[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long s = 1, e = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
			e = max(e, data[i]);
		}
		long cnt = 0, mid =0; 
		long ans = 0;
		while( s <= e)
		{
			mid = (s + e) / 2;
			cnt = 0;
			for(int i=1; i<= N; i++)
			{
				cnt += (long)(data[i] / mid);
			}
			if(cnt < K) {
				e = mid - 1;
			}
			else {
				ans = mid;
				s = mid + 1;
			}
		}
		System.out.println(ans);
	}
	public static long max(long a, long b) { return a > b? a : b; }
}
