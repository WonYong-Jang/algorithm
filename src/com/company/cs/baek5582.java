package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 공통 부분 문자열 
 */
public class baek5582 {

	static String s, t;
	static int sLen, tLen;
	static int[][] L = new int[4005][4005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		sLen = s.length();
		tLen = t.length();
	
		int result = 0;
		for(int i=1; i<= sLen; i++)
		{
			for(int j=1; j<= tLen; j++)
			{
				if(s.charAt(i-1) == t.charAt(j-1)) {
					L[i][j] = L[i-1][j-1] + 1;
					result = max(result, L[i][j]);
				}
			}
		}
		System.out.println(result);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
