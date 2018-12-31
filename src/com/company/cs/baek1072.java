package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 게임 
 */
public class baek1072 {

	static final int max = 1000000000;
	static int N, M;
	static long init;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init = ( (long) M * 100 ) / (long) N;
		
		int result = search(1, max + 1);
		if(result == max + 1) bw.write(-1+"\n");
		else bw.write(result+"\n");
		bw.flush();
	}
	public static long solve(int cnt)
	{
		return ( (long)(M + cnt) * 100 )  / (long)(N + cnt);
	}
	public static int search(int s, int e)
	{
		int mid = 0;
		while(s < e)
		{
			mid = (s + e) / 2;
			long tmp = solve(mid);
			if(init < tmp) { // 만족 한 경우 
				e = mid;
			}
			else {
				s = mid + 1;
			}
		}
		return e;
	}
}
