package com.company.leetcode;
/**
 * Buddy String
 * 케이스 별로 나누기
 * 1) 길이가 다른경우 무조건 false
 * 2) 서로 스트링 같을 경우 같은 문자 2개이상만 존재하면 무조건 true 그렇지 않으면 false
 * 3) 서로 다른 문자 2개인 경우 서로 swap 했을 때 같으면 true 그렇지 않으면 false 
 */
public class leetcode859 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abc";
        
    }
    
}

/*
class Solution {
    public boolean buddyStrings(String A, String B) {
        int len1 = A.length(); 
        int len2 = B.length();
        if(len1 != len2) return false;
        
        int[] arr = new int[27];
        int target =0;
        if(A.equals(B))
        {
            for(int i=0; i< len1; i++)
            {
                arr[A.charAt(i) - 'a' + 1]++;
                if(arr[A.charAt(i) - 'a' + 1] > 1) return true;
            }
            return false;
        }
        else
        {
            int first = -1, second = -1;
            
            for(int i=0; i< len1; i++)
            {
                
                if(A.charAt(i) != B.charAt(i))
                {
                    if(first == -1)
                    {
                        first = i;
                    }
                    else if(second == -1)
                    {
                        second = i;
                    }
                    else return false;
                }
            }
            
            if(first != -1 && second != -1)
            {
                if(A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first)) return true;
            }
        }
        
        return false;
    }
}
*/