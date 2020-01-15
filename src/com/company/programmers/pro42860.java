package com.company.programmers;

public class pro42860 {
    public static int len, answer;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        
        String str = "AAABAAC";
        len = str.length();
        System.out.println(solution(str));
        
        
    }
    public static int solution(String name) {
        
        len = name.length();
        answer += minAlpa(0, name);
        
        for(int i = 0; i < len; i++) sb.append("A");
        sb.replace(0,1,Character.toString(name.charAt(0)));
        
        int index = 0;
        while(true)
        {
            if(name.equals(sb.toString())) break;
            
            int next = find(index, name);
            System.out.println("next: "+ next);
            if(next == -1) {
                
                break;
            }
            
            sb.replace(next,next+1,Character.toString(name.charAt(next)));
            answer += minAlpa(next,name);
            index = next;
        }
        
        
        return answer;
    }
    public static int find(int i, String name)
    {
        int right = i, cnt1 = 0 , cnt2 = 0, left = i;
        right++;
        while(true)
        {
            System.out.println(sb.toString());
            
            if(i == right) return -1;
            else if(right >= len) right = 0;
            cnt1++;
            if(sb.charAt(right) != name.charAt(right)) break;
            right++;
        }
        
        left--;
        while(true)
        {
            if(i == left) return -1;
            else if(left < 0) left = len-1;
            cnt2++;
            if(sb.charAt(left) != name.charAt(left)) break;
            left--;
        }
        if(cnt1 < cnt2) {
            answer += cnt1;
            return right;
        }
        else {
            answer += cnt2;
            return left;
        }
        
    }
    public static int minAlpa(int i, String name)
    {
        int num = name.charAt(i) - 'A';
        return min(num, 26 - num);
    }
    public static int min(int a, int b) { return a > b ? b : a;}
}
