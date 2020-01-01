package com.company.leetcode;

public class leetcode1 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}

/**
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int start = 0, end = nums.length-1;
        Node[] node = new Node[end+1];
        for(int i=0; i<= end; i++)
        {
            node[i] = new Node(nums[i], i);
        }
        
        Arrays.sort(node, new mySort());
        
        int sum = node[start].num + node[end].num;
        
        while(start < end)
        {   
            if(sum == target) break;
            
            if(sum > target) {
                sum -= node[end--].num;
                sum += node[end].num;
                
            }
            else {
                sum -= node[start++].num;
                sum += node[start].num;
            }
            
        }
        
        return new int[]{node[start].index, node[end].index};
    }
    public class mySort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.num < b.num) return -1;
            else if(a.num > b.num) return 1;
            else return 0;
        }
    }
    public class Node {
        int num, index;
        Node(int a, int b) {
            num = a; index = b;
        }
    }
}
 */
