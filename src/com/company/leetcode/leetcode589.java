package com.company.leetcode;

public class leetcode589 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
class Solution {
    public List<Integer> ans;
    public List<Integer> preorder(Node root) {
        
        
        ans = new ArrayList<>();
        search(root);
        return ans;
    }
    public void search(Node root) {
        if(root == null) return ;
        
        ans.add(root.val);
        
        for(Node next : root.children) {
            search(next);
        }
    }
} 
 */
