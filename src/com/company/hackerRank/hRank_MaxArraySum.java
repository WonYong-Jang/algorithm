package com.company.hackerRank;

public class hRank_MaxArraySum {
    
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

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {

        int len = arr.length;
        int[] dp = new int[len];
        int INF = -100000;
        int ans = INF;
        
        for(int i=0; i< len; i++) {
            
            if(i - 2 < 0) {
                dp[i] = arr[i];
            }
            else {
                dp[i] = Math.max(arr[i], Math.max(dp[i-2], arr[i]+ dp[i-2]));
            }
            if(i - 3 < 0) {
                dp[i] = Math.max(arr[i], dp[i]);
            }
            else {
                int temp = Math.max(arr[i], Math.max(dp[i-3], arr[i]+ dp[i-3]));
                dp[i] = Math.max(dp[i], temp);
            }
            
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
 
 */
