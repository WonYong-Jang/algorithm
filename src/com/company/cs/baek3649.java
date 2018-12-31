package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 로봇 프로젝트 
 */
public class baek3649 {

	static final int nano = 10000000;
	static int N, target, num1, num2, result;
	static int[] data = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str = "";
		while( (str = br.readLine())!= null)
		{
			num1= 0; num2 = 0; result = -1;
			target = Integer.parseInt(str) * nano;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				data[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(data, 1, N+1);
			
			int num = 0;
			for(int i=1; i<= N; i++)
			{
				num = target - data[i];
				
				int idx = search(1, N, num, i);
				if(idx > 0) {
					abs(data[i], data[idx]);
				}
			}
			if(result == -1) System.out.println("danger");
			else System.out.println("yes "+num1+" "+num2);
		}
		
	}
	public static int search(int left, int right, int target, int idx)
	{
		int mid = 0;
		while(left <= right)
		{
			mid = ( left + right ) / 2;
			if(data[mid] == target && mid != idx) { // 조건을 만족하고 자기 자신이 아닐 때 ! 
				return mid;
			}
			else if(data[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return 0;
	}
	public static void abs(int a, int b) 
	{ 
		 int tmp = 0;
		 if(a > b ) {
			 tmp  = a - b;
			 if(tmp > result) {
				 result = tmp;
				 num1 = b; num2 = a;
			 }
		 }
		 else {
			 tmp = b - a;
			 if(tmp > result) {
				 result = tmp;
				 num1 = a; num2 = b;
			 }
		 }
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}









