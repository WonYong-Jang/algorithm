package com.company.leetcode;

public class leetcode1365 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[] tree;
    public int size, len;
    public List<Node> list;
    public int start, end, N;
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        return solve(nums);
    }
    public int[] solve(int[] nums) {
        size = 500;
        N = 101;
        len = nums.length;
        int[] answer = new int[len];
        list = new ArrayList<>();
        
        for(int i=0; i< len; i++) {
            list.add(new Node(nums[i], i));
        }
        Collections.sort(list, new mySort());
        
        start = 1;
        while(N > start) start *= 2;
        end = start + N - 1;
        
        tree = new int[size*4];
        
        for(int i=0; i< len; i++) {
            
            int num = list.get(i).num;
            int index = list.get(i).index;
            
            int cnt = search(0, num-1);
            update(num);
            answer[index] = cnt;
        }
        
        
        return answer;
    }
    public void update(int dx) {
        
        int s = start + dx;
        
        while(s > 0) {
            
            tree[s]++;
            s /= 2;
            
        }
        
    }
    public int search(int dx, int dy) {
        
        int s = start + dx;
        int e = start + dy;
        
        int sum = 0;
        
        while(s <= e) {
            
            if(s % 2 != 0) sum += tree[s];
            if(e % 2 == 0) sum += tree[e];
            
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        
        return sum;
    }
    public class mySort implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if(a.num == b.num) return b.index - a.index;
            else return a.num - b.num;
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
