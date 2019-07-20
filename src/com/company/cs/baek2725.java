package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 보이는 점의 갯수 
 */
public class baek2725 {

	static int N;
	static long[] ans = new long[1005];
	static HashSet<Float> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= 1000; i++)
		{
			float value = 0;
			for(int j =0; j<= i; j++)
			{
				value = (float)j/(float)i;
				set.add(value);
			}
			for(int j=0; j< i; j++)
			{
				value = (float)i/(float)j;
				set.add(value);
			}
			
			ans[i] = set.size();
		}
		
		
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			System.out.println(ans[N]);
		}
	}

}
