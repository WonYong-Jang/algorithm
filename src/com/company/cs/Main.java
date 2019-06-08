package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] data = new int[45];
	static int[][] dp = new int[45][45];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		N = str.length();
		for(int i=1; i<= N; i++)
		{
			data[i] = str.charAt(i-1) - '0';
		}
		
		
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}



/**
5 4
2
1
2
1
2
 */



