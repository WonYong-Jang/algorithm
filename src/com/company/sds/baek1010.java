package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다리 놓기 ( 문제는 복잡하지만 mCn 으로 간단하게 풀수 있는 문제 , 숫자가 타입 범위를 넘어 가기 때문에
 * 모든 팩토리얼 숫자를 소인수분해 하여 미리 지워주고 계산 
 */
public class baek1010 {

	static int N, M;
	static int[][] arr = new int[2][100]; // 0 번 인덱스 분모 , 1번 인덱스 분자 소인수 분해 
	static int a_index, b_index;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			a_index = b_index = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			fac(M-N, 0);
			fac(N, 0);
			fac(M, 1);
			
			int result =0;
			for(int i=0; i < a_index; i++)
			{
				for(int j=0; j < b_index; j++)
				{
					if(arr[0][i] > arr[1][j]) result = gcd(arr[0][i] , arr[1][j]);
					else result = gcd(arr[1][j] , arr[0][i]);
					arr[0][i]/=result; arr[1][j]/=result;
				}
			}
			int a=1, b=1;
			for(int i=0; i<a_index; i++)
			{
				
				a *= arr[0][i];
			}
			for(int i=0; i<b_index; i++)
			{
				b *= arr[1][i];
			}
			System.out.println(b/a);
		}
	}
	public static void fac(int n, int set)
	{
		if(n <= 1) {
			if(set ==0) arr[set][a_index++] = 1;
			else arr[set][b_index++] = 1;
			return;
		}
		else {
			if(set ==0) arr[set][a_index++] = n;
			else arr[set][b_index++] = n;
			fac(n-1, set);
		}
	}
	public static int gcd(int a, int b) // 유클리드 호제 
	{
		if( b==0 ) return a;
		else return gcd(b, a % b);
	}
}









