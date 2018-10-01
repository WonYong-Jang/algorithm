package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 보호 필름 
 */
public class baek2112 {

	static int D, W, K, ans;
	static boolean flag;
	static int[][] pMap = new int[15][25];
	static int[][] originMap = new int[15][25];
	static int[] rowArr = new int[15];
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			flag = false; ans = 0;
			for(int i=1; i<= D; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= W; j++)
				{
					pMap[i][j] = originMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<= D; i++)
			{
				solve(0,0,i);
				if(flag) break;
			}
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int cnt, int row, int tCnt)
	{
		if(cnt == tCnt) {
			boolean result = check();
			if(result) 
			{
				flag = true;
				ans = cnt; // 정답 기록 
			}
			return;
		}
		else 
		{
			for(int i= row+1; i<= D; i++)
			{
				rowArr[i] = 1;
				solve(cnt+1, i, tCnt);
				rowArr[i] = 0;
				if(flag) return;
			}
		}
	}
	public static boolean check()
	{
		arr.clear();
		for(int i=1; i<=D; i++)
			if(rowArr[i] == 1) arr.add(i);
		int len = arr.size();
		
		if(len == 0 )
		{
			if(goTest()) return true;
		}
		
		for(int i=0; i< (1 << len) ; i++)
		{
			for(int j=0; j< len; j++)
			{
				if( (i & ( 1 << j) ) > 0) getDrug(arr.get(j) , 1);
				else getDrug(arr.get(j) , 0);
					
			}
			
			if(goTest()) return true;
			init(); // 원본맵 되돌리기 다음 검사를위해 
		}
		return false;
	}
	public static boolean goTest() // 테스트 통과 가능한지 확인 
	{
		
		for(int i=1; i<= W; i++)
		{
			boolean testFlag = false;
			int aNum = 0, bNum =0; // 0, 1 연속 카운팅 
			for(int j=1; j<= D; j++)
			{
				if(pMap[j][i] == 0) 
				{
					aNum++;
					bNum =0;
				}
				else if(pMap[j][i] == 1) 
				{
					bNum++;
					aNum = 0;
				}
				
				if(aNum >= K || bNum >= K ) {
					testFlag = true;
					break;
				}
			}
			if(!testFlag) return false;
		}
		
		return true;
	}
	public static void getDrug(int row, int type) // 약품 투여 
	{
		for(int i=1; i<= W; i++)
		{
			pMap[row][i] = type;
		}
	}
	public static void init()
	{
		for(int i=1; i<= D; i++)
		{
			for(int j=1; j<= W; j++)
			{
				pMap[i][j] = originMap[i][j];
			}
		}
	}
}

