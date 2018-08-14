package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * M x N 보드 완주하기 
 */
public class baek9944 {

	static int[][] map = new int[31][31];
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		while((st = new StringTokenizer(br.readLine())) != null)
		{
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i= 1; i<= N; i++)
			{
				str = br.readLine();
				for(int j=1; j<= M; j++)
				{
					if(str.charAt(j-1) == '*') map[i][j] = 1; // 벽을 1로 설정 
					else map[i][j] = 0; // 지나갈수 있는 길 0 으로 설정 
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= M; j++)
				{
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
