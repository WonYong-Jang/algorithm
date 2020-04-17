package com.company.programmers;

public class pro64061 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int row = board.length;
        int col = board[0].length;
        int answer = 0;
        ArrayList<Integer>[] adj = new ArrayList[col];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< col; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] cntArr = new int[col];
        for(int i=0; i< col; i++) {
            for(int j=0; j< row; j++) {
                if(board[j][i] > 0) {
                    adj[i].add(board[j][i]);
                    cntArr[i]++;
                }
            }
        }
        
        for(int i=0; i< moves.length; i++) {
            
            int idx = moves[i] -1;
            if(cntArr[idx] == 0) continue;
            
            int targetIdx = adj[idx].size() - cntArr[idx];
            int target = adj[idx].get(targetIdx);
            cntArr[idx]--;
            
            if(stack.isEmpty()) stack.add(target);
            else {
                if(stack.peek() == target) {
                    stack.pop();
                    answer += 2;
                }
                else stack.add(target);
            }
        }
        
        return answer;
    }
} 
 */
