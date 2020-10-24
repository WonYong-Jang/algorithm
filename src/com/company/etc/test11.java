package com.company.etc;

public class test11 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        if(n == 0) return result;
        int k = 0, maximal = 0;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            }
            else
                k = 0;
            i = i - 1;
        }
        if (A[i] == 1 && k + 1 >= maximal)
            result = 0;
        return result;
    }
}
