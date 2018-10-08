package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 거듭 제곱 ( 분할 정복 )
 */
public class swExpert1217 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int k= 1; k<= 10; k++)
		{
			st = new StringTokenizer(br.readLine());
			int testCase = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
					
			int result = solve(N, M);
			
			bw.write("#"+k+" "+result+"\n");
		}
		bw.flush();
	}
	public static int solve(int n, int m)
	{
		int k =0;
		if(m == 0) return 1;
		else if(m % 2 == 0) 
		{ // 짝수 
				k = solve(n, m/2);
				return k * k;
		}
		else 
		{
			k = solve(n, (m-1)/2);
			return n * k *k;
		}
		
	}
}
