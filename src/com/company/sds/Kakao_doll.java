package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 인형들 (카카오 예선) 
 *
 */
public class Kakao_doll {

	static int[] data = new int[501]; // 인형이 일렬로 나열된 순서 대로 인형을 선호하는 사람의 수 
	static int N, K;
	static double result = Double.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = K; i<= N; i++) // K 는 3개 이상 
		{
			cal(i);
		}	
		System.out.println(result);
	}
	public static void cal(int K)
	{
		double sum =0.0, min = 0.0;
		int s =1, e=1, cnt =0; // 시작점 , 끝점 K개인지 확인 
		while(true) // K 에 대한 sum 구하기 
		{
			while(cnt < K && e <= N) // K개 더해나갈때 까지 
			{
				cnt++; sum += data[e++];
			}
			if(cnt < K) break; // 범위넘어가서 검사 종료 
			
			if( cnt == K) {
				min = sum / K; // 합에 대한 평균 구하기 
				double temp =0.0, output =0.0;
				for(int i= s; i< e ;i++) // 분산 구하기 
				{
					temp += (data[i] - min)*(data[i] - min);
				}
				//System.out.println(temp+" "+min+"// " + s+" "+ (e-1));
				//System.out.println("표준편차 "+Math.sqrt(temp/K));
				output = Math.sqrt(temp/K);
				result = min(output, result);
				sum -= data[s++];
				cnt--;
			}
		}
	}
	public static double min(double a, double b)
	{
		return a > b ? b : a;
	}
}







