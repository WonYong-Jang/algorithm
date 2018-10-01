package com.company.sds;

import java.util.StringTokenizer;

class Street11_test2 {
    public int solution(String S) {
        // write your code in Java SE 8
    	int answer =0, sum = 0;
    	
    	StringTokenizer st = new StringTokenizer(S,".|!|?");
    	StringTokenizer temp;
    	while(st.hasMoreTokens())
    	{
    		temp = new StringTokenizer(st.nextToken()); // 공백기준으로 자르고 최대 단어 갯수 찾기
    		sum = temp.countTokens();
    		answer = max(answer, sum);
    	}
    	
    	return answer;
    }
    public static int max(int a, int b)
    {
    	return a > b ? a : b;
    }
}