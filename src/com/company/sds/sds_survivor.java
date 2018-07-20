package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 마지막 생존자 
 */
public class sds_survivor {

	static int[][] map = new int[12][12]; // 1~ N
	static int[] check = new int[3]; // 불모지를 제외한 나머지가 있는지 확인   
	static int[] dxArr = {1,-1, 0, 0, 1, -1, 1, -1}; // 8방향 확인 
	static int[] dyArr = {0, 0, 1, -1, 1, -1, -1, 1};
	static int N, result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			for(int i=1; i<=N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					init(); // check 배열 초기화 
					boolean chk = solve(i,j);
					if(chk) result++;
				}
			}
			
			System.out.println("#"+k+" "+ result);
		}
	}
	public static boolean solve(int dx, int dy) // 0이 하나 이상 있거나 1,2,3이 하나라도 빠져있다면 false
	{
		boolean flag = true;
		
		if(map[dx][dy] == 0) return false;
		else check[map[dx][dy]-1]++;
		
		for(int i=0; i<8; i++) // 8방향 체크 
		{
			int rDx = dxArr[i] + dx;
			int rDy = dyArr[i] + dy;
			if(rDx <= 0 ||  rDy <= 0 || rDx > N || rDy > N) continue;
			if(map[rDx][rDy] ==0 ) return false;
			check[map[rDx][rDy]-1]++;
		}
		
		for(int i=0; i<3; i++) // check 함수 확인  
		{
			if(check[i] == 0) {
				flag = false; // 하나라도 비어 있다면 
			}
		}

		return flag;
	}
	public static void init()
	{
		for(int i=0; i<3; i++)
			check[i] =0;
	}
}










