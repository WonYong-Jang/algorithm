package com.company.leetcode;

public class leetcode354 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/***

class Solution {
    
    public Node[] node;
    public int maxEnvelopes(int[][] envelopes) {
        
        int len = envelopes.length;
        int[] dp = new int[len+1];
        node = new Node[len+1];
        int answer = 0;
        for(int i=1; i<= len; i++)
        {
            node[i] = new Node(envelopes[i-1][0], envelopes[i-1][1]);
        }
        Arrays.sort(node, 1, len+1, new mySort());
        
        for(int i = 1; i <= len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(check(j, i))
                {
                    dp[i] = max(dp[i], dp[j] + 1);
                    answer = max(answer, dp[i]);
                }
            }
        }
        
        return answer;
            
    }
    public boolean check(int idx1, int idx2) {
        if(idx1 == 0) return true;
        else return node[idx1].weight < node[idx2].weight && node[idx1].height < node[idx2].height;
    }
    public int max(int a, int b) { return a > b ? a : b;}
    public class Node {
        int weight, height;
        Node(int a, int b) {
            weight = a; height = b;
        }
    }
    public class mySort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            
            if(a.weight < b.weight ) return -1;
            else if(a.weight > b.weight) return 1;
            else {
                if(a.height < b.height) return -1;
                else if(a.height > b.height) return 1;
                else return 0;
            }
        }
    }
} 
 */
