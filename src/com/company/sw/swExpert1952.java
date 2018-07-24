package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수영장 ( 모의 sw 역량 테스트 )
 */
public class swExpert1952 {

	static int[] map = new int[13]; // 1 ~ 12 월 
	static int[] cost = new int[5]; // 1 ~ 4 인덱스 사용  
	static int result;
	static int[] month = {0, 1, 1, 3 }; // 인덱스 1 ~ 3 사용 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= 4; i++) // 1일 부터 1년 까지 이용 요금 
			{
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= 12; i++) // input 
			{
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			result = cost[4]; // 가장 최대로 초기화 ( 최소값 찾기 위해서 ) // 1년 이용권 !
			
			int cSum =0;
			if(map[1] == 0 ) solve(2 , 0); // 2월로 이동 
			else {
				for(int j=1; j<=3; j++) // 1일 부터 1년 이용권 까지 검사 
				{
					if(j == 1 ) cSum = cost[1] * map[1]; // 1월 부터 검사 시작 
					else cSum = cost[j];
					solve(1 + month[j], cSum);
				}
			}
				
			System.out.println("#" + k + " "+ result);
		}
	}
	public static void solve(int curMonth, int sum) // 현재 달, 총 합, 이용 기간
	{
		if(result < sum) return; // 최소 비용 구하기 ( 더이상 검사할 필요 없는 경우 )
		//System.out.println(curMonth+" "+sum);
		if(curMonth > 12) {
			result = Integer.min(result, sum);
			return; 
		}
		int cSum =0;
		
		if(map[curMonth] == 0 ) solve(curMonth+1 , sum); // 다음 월로 이동 
		else {
			for(int j=1; j<=3; j++) // 1일 부터 1년 이용권 까지 검사 
			{
				if(j == 1 ) cSum = cost[1] * map[curMonth]; // 1월 부터 검사 시작 
				else cSum = cost[j];
				solve(curMonth + month[j], cSum + sum);
			}
		}
	}
}
