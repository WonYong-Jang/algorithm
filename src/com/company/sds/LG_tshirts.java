package com.company.sds;

import java.util.Arrays;

class LG_tshirts {
	
    public int solution(int[] people, int[] tshirts) {
    	int tLen = tshirts.length;
    	int sLen = people.length;
        int answer = 0, tIndex =0, sIndex =0;
        
        Arrays.sort(tshirts);
        Arrays.sort(people);
        
        while(true)
        {
        	if(tIndex >= tLen || sIndex >=sLen) break; // 종료 
        	
        	if(tshirts[tIndex] == people[sIndex])
        	{
        		tIndex++; sIndex++;
        		answer++;
        	}
        	else if(tshirts[tIndex] > people[sIndex]) sIndex++;
        	else if(tshirts[tIndex] < people[sIndex] ) tIndex++;
        }
        
        
        return answer;
    }
}