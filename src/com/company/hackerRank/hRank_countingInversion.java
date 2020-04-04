package com.company.hackerRank;

public class hRank_countingInversion {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long ans;
    static int[] temp, data;
    static int N;
    static long countInversions(int[] arr) {
        ans = 0;
        N = arr.length;
        data = arr;
        temp = new int[N];
        divide(0, N-1);

        return ans;
    }
    static void divide(int s, int e) {
        if(s >= e) return;

        int mid = (s + e) / 2;
        divide(s, mid);
        divide(mid+1, e);
        merge(s, e);
    }
    static void merge(int s, int e) {

        for(int i=s; i<= e; i++) temp[i] = data[i];
        int mid = (s + e) / 2;
        int i = s, j = mid+1, k = s;
        
        while(i <= mid && j <= e) {
            if(temp[i] > temp[j]) {
                data[k++] = temp[j++];
                ans += (long)(mid - i + 1);
            }
            else data[k++] = temp[i++];
        }

        while(i <= mid) data[k++] = temp[i++];
        while(j <= e) data[k++] = temp[j++];
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

 */
