package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2 x N 타일링 ( D P )
 */
public class baek11726 {
	
	static int[] map = new int[1001];
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map[1] = 1; // base case N == 1 
		map[2] = 2; // base case N == 2
		
		for(int i=3; i<= N; i++)
		{
			map[i] = (map[i-1] + map[i-2]) % 10007;
		}
		System.out.println(map[N]);
	}
}
