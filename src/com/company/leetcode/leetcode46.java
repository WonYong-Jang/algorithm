package com.company.leetcode;

public class leetcode46 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    public List<List<Integer>> ans;
    public int[] data;
    public int[] visit;
    public int[] perm;
    public int N;
    public List<List<Integer>> permute(int[] nums) {
        
        ans = new ArrayList<>();
        N = nums.length;
        data = nums;
        visit = new int[N];
        perm = new int[N];
        search(0, 0);
        
        return ans;
    }
    public void search(int index, int len){
        if(len >= N) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i< N; i++) {
                temp.add(perm[i]);
            }
            ans.add(temp);
            return;
        }
        
        
        for(int i=0; i< N; i++) {
            
            if(visit[i] == 1) continue;
            visit[i] = 1;
            perm[len] = data[i];
            search(i, len+1);
            visit[i] = 0;
        }
    }
} 
 */
