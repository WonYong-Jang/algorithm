package com.company.programmers;

public class pro60057 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
class Solution {
    
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        
        if(len == 1) return 1;
        
        int size = len / 2;
        StringBuilder sb;
        
        for(int i=1; i<= size; i++)
        {
            sb = new StringBuilder();
            int preIdx = i, sufIdx = i+i, cnt = 1;
            String str = s.substring(0, i), nextStr = "";
            while(sufIdx <= len)
            {
                nextStr = s.substring(preIdx, sufIdx);
                if(str.equals(nextStr))
                {
                    cnt++;
                }
                else {
                    if(cnt > 1) {
                        sb.append(cnt);
                    }
                    cnt = 1;
                    sb.append(str);
                    str = nextStr;
                }
                
                preIdx += i;
                sufIdx += i;
            }
            if(!nextStr.equals(""))
            {
                if(cnt > 1) sb.append(cnt);
                sb.append(nextStr);
            }
            sb.append(s.substring(preIdx, len));
            if(sb.length() == 0) continue;
            if(answer > sb.length())
            {
                answer = sb.length();
            }
        }
        
        return answer;
    }
    public int min(int a, int b) { return a > b ? b : a ;}
}
*/