package com.company.etc;
// ma
public class test12 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
public int solution(int[][] A) {
        
        int N = A.length;
        if(N == 0) return 0;
        int answer = 1;
        int M = A[0].length;
        
        for(int k=2; k<= 20; k++) {
            
            for(int i=0; i< N; i++) {
                for(int j=0; j< M; j++) {
                    
                    int dx = i + k - 1;
                    int dy = j + k - 1;
                    
                    if(dx >= N || dy >= M) continue;
                    
                    if(check( A, i, j, k)) {
                        answer = Math.max(answer, k);
                    }
                    
                }
                
            }
            
        }
        
        return answer;
    }
    public boolean check(int[][] A, int dx, int dy, int size) {
        
        int target = 0; // 비교 대상  
        
        int left = dx-1, right = dx + size;
        int leftDiagonal = 0, rightDiagonal = 0; 
        for(int i= dx; i< dx + size; i++) {
            int rowSum = 0, colSum = 0;
            for(int j = dy; j< dy + size; j++) {
                rowSum += A[i][j];
                colSum += A[j][i];
                
                if(i == j) { // 대각선 
                    leftDiagonal += A[i][j];
                    left++;
                    right--;
            
                    rightDiagonal += A[left][right];
                }
                
            }
            if(target == 0) target = rowSum;
            
            if(target != rowSum) return false;
            if(target != colSum) return false;
        }
        if(target != leftDiagonal) return false;
        if(target != rightDiagonal) return false;
        
        return true;
    }

}










