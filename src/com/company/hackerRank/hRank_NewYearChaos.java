package com.company.hackerRank;

public class hRank_NewYearChaos {
    
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

    // Complete the minimumBribes function below.
    static int[] data, temp;
    static int ans;
    static void minimumBribes(int[] q) {

        data = q;
        ans = 0;
        int len = q.length;
        boolean flag = true;
        for(int i=1; i<= len; i++) {
            if(q[i-1] - i> 2) {
                flag = false;
                break;
            } 
        }
        if(!flag) {
            System.out.println("Too chaotic");
        }
        else {
            temp = new int[len];
            divide(0, len-1);

            System.out.println(ans);
        }
        
    }
    static void divide(int s, int e) {
        if(s >= e) return;
        int mid = (s+e)/2;
        divide(s, mid);
        divide(mid+1, e);
        merge(s, e);
    }
    static void merge(int s, int e) {
        for(int i=s; i<= e; i++) temp[i] = data[i];

        int mid = (s+e)/2;
        int i = s, k = s, j = mid+1;
        while(i <= mid && j <= e) {
            if(temp[i] > temp[j]) {
                ans+= (mid - i + 1);
                data[k++] = temp[j++];
            }
            else {
                data[k++] = temp[i++];
            }
        }

        while(i <= mid) data[k++] = temp[i++];
        while(j <= e) data[k++] = temp[j++];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
 
 */
