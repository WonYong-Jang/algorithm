package com.company.leetcode;

public class leetcode1086 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[][] highFive(int[][] items) {
        
        
        return solve(items);
    }
    public int[][] solve(int[][] items) {
        
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int[] num : items) {
            
            int key = num[0];
            int value = num[1];
            
            PriorityQueue<Integer> que = map.getOrDefault(key, new PriorityQueue<>());
            que.add(-num[1]);
            map.put(key, que);    
        }
        
        int[][] answer = new int[map.size()][2];
        int idx = 0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            PriorityQueue<Integer> temp = entry.getValue();
            
            int sum = 0;
            int cnt = 0;
            while(!temp.isEmpty()) {
                if(cnt >= 5) break;
                
                sum += (-temp.poll());
                
                cnt++;
            }
            
            
            answer[idx][0] = key;
            answer[idx][1] = sum/cnt;
            idx++;
        }
        
        
        return answer;
    }
} 
 */
