package com.company.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class leetcode36 {
    
    public static int[] data = new int[1005];
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i]= Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i< N-1; i++) {
            
            for(int j=0; j < N-1- i; j++) {
                
                if(data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        
        
        for(int i=0; i< N; i++) {
            bw.write(data[i] + "\n");
        }
        bw.flush();
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
