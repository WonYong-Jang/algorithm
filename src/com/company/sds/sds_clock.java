package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 고장 난 시계
0 0 0 0 1 1 0   1 1 1 1 1 1 1   1 1 1 1 1 1 0   1 1 1 1 1 1 1
1 1 1 1 1 1 0   1 1 1 1 1 1 1   1 0 1 1 0 1 1   1 1 1 1 1 0 1
0 0 0 0 1 1 0   1 1 0 1 1 1 1   1 0 0 1 1 1 1   0 0 1 1 0 1 0 
 */
public class sds_clock {

	// 0 ~ 9 번 숫자 각각 7 세그멘트로 구성 되어 있음  int[10][7]
	static int[][] clocks = {{1, 1, 1, 1, 1, 1, 0}, // 0   
							 {0, 0, 0, 0, 1, 1, 0}, // 1
							 {1, 0, 1, 1, 0, 1, 1}, // 2
							 {1, 0, 0, 1, 1, 1, 1}, // 3
							 {0, 1, 0, 0, 1, 1, 1}, // 4
							 {1, 1, 0, 1, 1, 0, 1}, // 5
							 {1, 1, 1, 1, 1, 0, 1}, // 6
							 {1, 0, 0 ,0, 1, 1, 0}, // 7
							 {1, 1, 1, 1, 1, 1, 1}, // 8
							 {1, 1, 0, 1, 1, 1, 1} }; // 9
	static int[][] map; // 입력 값 
	static int[] reverse = {1 , 0}; // 1 -> 0 // 0 -> 1
	static int result;
	static int[] disit = {600 , 60 ,10 , 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			map = new int[4][7]; // 각 자릿수 마다 7 세그멘트 위치 
			result = 500000; // 임의로 높은 값 설정 
			for(int i=0; i<4; i++)
			{
				for(int j=0; j<7; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<= 2; i++) // 0 부터 최대 2개 까지 고장난 세그 먼트 
			{
				dfs(i, 0, 0);
			}
			System.out.println(result);
		}
	}
	public static void dfs(int tarCnt, int curCnt, int index) // 목표 고장 갯수, 현재 갯수,  세그먼트 인덱스  
	{
		int nIndex = index, ncurCnt = curCnt;
		
		if(nIndex > 3) { // 4자리수 다 확인 한 경우  
			ncurCnt++;
			nIndex = 0; // 인덱스 다시 0 번으로 
		}
		if(tarCnt == ncurCnt || ncurCnt == 2)
		{
			// 시간 체크 확인 
			int sum =0, flag =0;
			ArrayList<Integer> arr= new ArrayList<>();
			for(int i=0; i< 4; i++)
			{
				for(int j=0; j<10; j++)
				{
					int target=0;
					for(int k=0; k<7; k++)
					{
						if( clocks[j][k] != map[i][k] ) break;
						target = k;
					}
					if(target == 6) 
					{
						if(j==0 && i==1) System.out.println("aa");
						sum += (j * disit[i]);
						flag++;
						arr.add(j);
						break;
					}
				}
			}
			if(flag == 4) { // 네 자릿수가 모두 숫자이면 
				
				if(result > sum) { // 최소 시간 계산 
					result = sum;
					for(int i=0; i<4; i++)
						System.out.print(arr.get(i)+" ");
					System.out.println();
					System.out.println(result);
				}
			} 
			arr.clear();
			return;
		}
		
		for(int i=0; i<7; i++)
		{
			map[nIndex][i] = reverse[map[nIndex][i]]; // 세그먼트 바꾸기 
			dfs(tarCnt, ncurCnt, nIndex+1);
			map[nIndex][i] = reverse[map[nIndex][i]]; // 원래대로 복귀 
		}
		
	}
}











