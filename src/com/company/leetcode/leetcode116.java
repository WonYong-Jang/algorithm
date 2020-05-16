package com.company.leetcode;

public class leetcode116 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/**
class Solution {
    public Node connect(Node root) {
        
        Node ans = root;
        if(root == null) return ans;
        
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        
        while(!que.isEmpty()) {
            
            int size = que.size();
            
            for(int i=0; i< size; i++) {
                
                Node cur = que.poll();
                
                if(i < size - 1) {
                    cur.next = que.peek();
                }
                
                if(cur.left != null) que.offer(cur.left);
                
                if(cur.right != null) que.offer(cur.right);
                
            }
        }
        
        return ans;
    }
}
**/
