package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 공유기 설치 
 */
public class baek2110 {

	static int N, C;
	static int[] data = new int[200005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data, 1, N+1);
		
		int s =0, e =0, m =0, pos = 0, cnt = 0;
		s = data[1]; e = data[N] - data[1];
		int ans = 0;
		while(s <= e)
		{
			m = (s + e) / 2;
			pos = data[1];
			cnt = 1;
			
			for(int i=2; i<= N; i++)
			{
				if(data[i] - pos >= m)
				{
					cnt++;
					pos = data[i];
				}
			}
			
			if(cnt >= C) {
				ans = m;
				s = m + 1;
			}
			else {
				e = m - 1;
			}
		}
		System.out.println(ans);
	}

}
