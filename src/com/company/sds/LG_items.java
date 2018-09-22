package com.company.sds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

class LG_items {
	
	static int[] visit = new int[10005]; // 체력 길이 방문 체크 
	static int maxValue = 0;
	static int hLen, iLen;
	static int[] hArr;
	static int[][] iArr;
	static Deque<Integer> temp = new ArrayDeque<>();
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void solve(int index, int sum)
	{
		if(maxValue < sum)
		{
			arr.clear();
			maxValue = sum;
			arr.addAll(temp);
		}
		
		for(int i= index+1; i<hLen; i++)
		{
			for(int j=0; j < iLen; j++)
			{
				if(visit[j] == 1) continue;
				if(hArr[i] - iArr[j][1] < 100) continue;
				temp.addLast(j);
				visit[j] = 1;
				solve(i, iArr[j][0] + sum);
				visit[j] =0;
				temp.pollLast();
			}
		}
	}
    public int[] solution(int[] healths, int[][] items) {
        int[] answer;
        hArr = healths;
        iArr = items;
        hLen = hArr.length; // 체력 배열 
        iLen = iArr.length; // 아이템 배열 길이 
        
        solve(-1, 0);
        
        
        Collections.sort(arr);
        answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++)
        {
        	answer[i] = arr.get(i) + 1;
        }
        
        return answer;
    }
}