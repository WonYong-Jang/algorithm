package com.company.programmers;

public class pro1 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}


class Solution_targetNumbers {
    public int[] arr;
    public int len;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        len = numbers.length;
        arr = numbers;
        
        answer += dfs(0, arr[0]*-1, target);
        answer += dfs(0, arr[0], target);
        
        return answer;
    }
    public int dfs(int cur, int sum, int target)
    {
        if(cur == len-1)
        {
            if(sum == target) return 1;
            else return 0;
        }
        int ret = 0;
        ret += dfs(cur+1, sum + (arr[cur+1]*-1) , target);
        ret += dfs(cur+1, sum + arr[cur+1], target);
        
        return ret;
    }
}