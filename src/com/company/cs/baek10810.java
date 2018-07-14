package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 공 넣기 
 */
public class baek10810 {
	
	static int[] map = new int[101];
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int dx =0, dy=0, num=0;
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			for(int k=dx; k<=dy; k++)
			{
				map[k] = num;
			}
		}
		for(int i=1; i<= N; i++)
		{
			System.out.print(map[i]+" ");
		}
	}

}
