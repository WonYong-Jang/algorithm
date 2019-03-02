package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] dp = new int[1002][1002];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int diagonal = 0; diagonal < N; diagonal++)
		{
			for(int i =1; i <= N - diagonal; i++)
			{
				int j = i + diagonal;
				if(i == j) {
					dp[i][j] = 0;
					continue;
				}
				
			}
		}
		
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}





