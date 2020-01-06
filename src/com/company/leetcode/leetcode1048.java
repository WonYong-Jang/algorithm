package com.company.leetcode;

import java.util.Arrays;

/**
 * 1048. Longest String Chain
 */
public class leetcode1048 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int longestStrChain(String[] words) {
        
        int len = words.length;
        int[] dp = new int[len+2];
        Node[] node = new Node[len+2];
        
        for(int i=1; i<= len; i++ )
        {
            node[i] = new Node(words[i-1], words[i-1].length());
        }
        Arrays.sort(node, 1, len+1, new mySort());
        
        dp[1] = 1;
        int answer = 1;
        for(int i=2; i<= len; i++)
        {
            dp[i] = 1;
            for(int j=1; j< i; j++)
            {
                if(check(node[j].word, node[i].word))
                {
                    dp[i] = max(dp[i], dp[j]+1);
                    answer = max(answer, dp[i]);
                }
            }
        }
        
        
        return answer;
    }
    public boolean check(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        
        if(len2 - len1 != 1) return false;
        
        int start = 0, end = 0, flag = 0;
        while(start < len1 && end < len2)
        {
            if(str1.charAt(start) == str2.charAt(end)) {
                start++; end++;
            }
            else {
                end++;
                flag++;
            }
        }
        if(flag <= 1) return true;
        else return false;
    }
    public class mySort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.cnt < b.cnt) return -1;
            else if(a.cnt > b.cnt) return 1;
            else return 0;
        }
    }
    public class Node {
        String word;
        int cnt;
        Node(String a, int b) { 
            word = a; cnt = b;
        }
    }
    public int max(int a, int b) { return a > b ? a : b; }
    public int min(int a, int b) { return a > b ? b : a;}
}
 */
