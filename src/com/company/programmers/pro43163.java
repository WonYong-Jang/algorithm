package com.company.programmers;

import java.util.*;

public class pro43163 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
    }
}
/*
import java.util.*;

class Solution {
    public int[] visit;
    public int len, result;
    public String[] wordList;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        len = words.length; result = 0;
        visit = new int[len];
        wordList = words;
        
        for(int i=0; i< len; i++)
        {
            if(isFun(begin, words[i]))
            {
                visit[i] = 1;
                dfs(i, 1, target);
                visit[i] = 0;
            }
        }
        answer = result;
        return answer;
    }
    public void dfs(int cur,int cnt, String target)
    {
        if(wordList[cur].equals(target))
        {
            if(result == 0) result = cnt;
            else result = min(result, cnt);
            
            return;
        }
        
        for(int i=0; i< len; i++)
        {
            if(visit[i] == 1 || i == cur) continue;
            if(isFun(wordList[cur], wordList[i]))
            {
                visit[i] = 1;
                dfs(i, cnt+1, target);
                visit[i] = 0;
            }
        }
    }
    public boolean isFun(String str1, String str2)
    {
        int cnt = 0;   
        for(int i=0; i< str1.length(); i++)
        {
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        if(cnt == 1) return true;
        else return false;
    }
    public int min(int a, int b) { return a > b ? b : a;}
}
*/