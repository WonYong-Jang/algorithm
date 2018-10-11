package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 금속 막대 
 */
public class swExpert1259 {

	static int N;
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] output = new int[100];
	static int[] visit = new int[100];
	static int[] ans = new int[100];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr.clear();
			int dx = 0, dy = 0;
			for(int i=0; i< N; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				arr.add(new Node(dx, dy));
				
				visit[i] = -1;
				output[i] = -1;
				ans[i] = -1;
			}
		}
		
		for(int i=0; i< N; i++)
		{
			visit[i] = 1;
			solve(0, i);
			visit[i] = -1;
		}
	}
	public static void solve(int depth, int index)
	{
		output[depth] = index;
		
		if(depth == N)
		{
			for(int i=0; i< N; i++)
			{
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i< N; i++)
		{
			if(visit[i] == 1) continue;
			visit[i] = 1;
			solve(depth+1, i);
			visit[i] = -1;
		}
	}
	static class Node{
		int dx, dy;
		Node(int a, int b) {
			dx=a; dy=b;
		}
	}
}
