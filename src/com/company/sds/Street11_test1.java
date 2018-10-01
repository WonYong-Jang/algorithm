package com.company.sds;

class Street11_test1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	int answer = 1;
        int len = A.length;
        
        int curIndex = 0; // 현재 인덱스 / 초기값 0 
        
        while(curIndex != -1)
        {
        	int next = A[curIndex];
        	answer++;
        	curIndex = next;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}