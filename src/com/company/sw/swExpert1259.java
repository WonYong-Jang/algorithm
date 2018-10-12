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

	static int N, check;
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
			check = 0;
			st = new StringTokenizer(br.readLine());
			int dx = 0, dy = 0;
			for(int i=0; i< N; i++)
			{
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				arr.add(new Node(dx, dy));
				
				visit[i] = -1;
				output[i] = -1;
				ans[i] = -1;
			}
			
			for(int i=0; i< N; i++)
			{
				visit[i] = 1;
				solve(0, i);
				visit[i] = -1;
			}
			
			System.out.print("#"+k+" ");
			for(int i=0; i< N; i++)
			{
				int n = ans[i];
				int rx = arr.get(n).dx;
				int ry = arr.get(n).dy;
				System.out.print(rx + " "+ ry+" ");
			}
			System.out.println();
		}
	}
	public static void solve(int depth, int index)
	{
		output[depth] = index;
		
		if(depth == N-1)
		{
			int sdx = 0, sdy =0, edx =0, edy =0, cnt =0;
			for(int i=0; i< N; i++)
			{
				int num = output[i];
				if(i == 0) {
					sdx = arr.get(num).dx;
					sdy = arr.get(num).dy;
				}
				else { // 비교 
					edx = arr.get(num).dx;
					edy = arr.get(num).dy;
					
					if( sdy == edx) cnt++;
					
					sdx = edx; sdy = edy;
				}
			}
			if(check < cnt)
			{
				for(int i=0; i< N; i++)
				{
					ans[i] = output[i];
				}
				check = cnt;
			}
			
			
			return;
		}
		
		for(int i=0; i< N; i++)
		{
			if(visit[i] == 1) continue;
			visit[i] = 1;
			solve(depth + 1, i);
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
