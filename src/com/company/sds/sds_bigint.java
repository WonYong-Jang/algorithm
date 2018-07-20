package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class sds_bigint {

	static long[] arr, inputArr;
	static int[] op = new int[2], opArr;
	static int N; // 입력 갯수 
	static long result; // 가장 큰 수 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			op[0] = plus; op[1] = minus; // set input
			arr = new long[N];
			inputArr = new long[N];
			opArr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< N; i++)
			{
				long tmp = Long.parseLong(st.nextToken());
				arr[i] = tmp;
				inputArr[i] = tmp;
			}
			
			Arrays.sort(arr);
			
			result = inputArr[0];
			for(int i=1; i< N; i++)
			{
				if(op[1] > 0) {
					opArr[i] = 1;
					op[1]--;
				}
				else {
					opArr[i] = 0;
				}
			}
			for(int i=1; i< N; i++)
			{
				System.out.print(opArr[i]+" ");
			}
			for(int i=1; i< N; i++)
			{
				int index = Arrays.binarySearch(arr, inputArr[i]);
				int np = opArr[index];
				if(np == 0) {
					result += inputArr[i];
				}
				else {
					result -= inputArr[i];
				}
				System.out.println(result);
			}
			
			System.out.println("#"+k+" "+result);
		}
	}
	
}

/**
 * 큰수 구하기 
 
public class sds_bigint {

	static long[] arr = new long[100000];
	static int[] op = new int[2];
	static int N; // 입력 갯수 
	static long result; // 가장 큰 수 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			op[0] = plus; op[1] = minus; // set input
			
			result = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< N; i++)
			{
				arr[i] = Long.parseLong(st.nextToken());
			}
			
			for(int i=0; i<2; i++) // 나올수 있는 경우의 수 모두 확인 
			{
				if(op[i] == 0) continue;
				op[i]--;
				solve(i, 1, arr[0] );
				op[i]++;
			}
			System.out.println("#"+k+" "+result);
		}
	}
	public static void solve(int opType, int index, long sum)
	{
		long rSum = sum;
		if(opType == 0) // 플러스일때 
			rSum += arr[index];
		else if(opType == 1) // 마이너스 일때 
			rSum -= arr[index];
		
		if(index == N-1) {
			result = Math.max(result, rSum);
			return;
		}
		
		for(int i=0; i<2; i++)
		{
			if(op[i] == 0) continue;
			op[i]--;
			solve(i, index+1, rSum );
			op[i]++;
		}
		
	}
}

*/






