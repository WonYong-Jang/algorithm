package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자열 
 */
public class baek1120 {

	static int bLen, aLen; // 각 각 문자열 길이 
	static String A, B; // A의 길이는 B보다 작거나 같다 
	static int result; // 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
		result = Integer.MAX_VALUE;
		bLen = B.length();
		aLen = A.length();
		int index =0, cnt =0, aIdx =0;
		while(index+aLen <= bLen) // index 변수를 하나씩 더하면서 B 문자열 이동 후 A 와 비교 
		{
			cnt = 0; aIdx =0;
			for(int i = index; i< index+aLen; i++)
			{
				if(A.charAt(aIdx) != B.charAt(i)) { // 문자열이 다를 경우 count 추가 
					cnt++;
				}
				aIdx++;
			}
			result = Math.min(result, cnt);
			index++;
		}
		
		System.out.println(result);
	}
	
}
