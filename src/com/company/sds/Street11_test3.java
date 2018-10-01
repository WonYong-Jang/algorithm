package com.company.sds;

class Street11_test3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	int answer = 0;
    	
    	int len = A.length;
    	int zeroCnt =0, oneCnt =0; // 0, 1 적은 수 가 가장 적게 뒤집을수 있는 수 
    	for(int i=0; i< len; i++) //  시간 복잡도 O(N)
    	{
    		if(A[i] == 0) zeroCnt++; // 갯수 카운트 
    		else oneCnt++;
    	}
    	answer = min(zeroCnt, oneCnt); // 적은 수 확인 
    	
    	return answer;
    }
    public static int min(int a, int b)
    {
    	return a > b ? b : a;
    }
}
