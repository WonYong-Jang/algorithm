package com.company.leetcode;

import java.util.HashSet;

public class leetcode36 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int row = board.length;
        if(row == 0) return false;
        int col = board[0].length;
        
        return solve(board, row, col);
    }
    public boolean solve(char[][] board, int row, int col) {
        
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();        
        
        for(int i=0; i< row; i++) {
            rowSet.clear();
            colSet.clear();
            for(int j=0; j< col; j++) {
                
                char ch1 = board[i][j]; // row
                char ch2 = board[j][i]; // col
                if(ch1 != '.' ) {
                    
                    if(rowSet.contains(ch1)) return false;
                    rowSet.add(ch1);
                }
                if(ch2 != '.') {
                    if(colSet.contains(ch2)) return false;
                    colSet.add(ch2);
                }
                
            }
        }
        
        for(int i=0; i< row; i += 3) {
            for(int j=0; j< col; j+=3) {
                
                if(!boxSearch(i, j, board)) return false;
            }
        }
        
        
        return true;
    }
    public boolean boxSearch(int dx, int dy, char[][] board) {
        
        HashSet<Character> box = new HashSet<>();
        
        for(int i=dx; i< dx+3; i++) {
            for(int j=dy; j< dy+3; j++) {
            
                char ch = board[i][j];
                if(ch != '.') {
                    
                    if(box.contains(ch)) return false;
                    box.add(ch);
                }
            }
        }
        
        return true;
    }
}







 
 */
