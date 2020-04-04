package com.company.hackerRank;

import java.util.Comparator;
import java.util.PriorityQueue;

public class hRank_FradulentActivityNotification {
    
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

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int len = expenditure.length, cnt = 0;
        int[] data = new int[205];

        for(int i=0; i< len-1; i++) {
            int target = expenditure[i];
            data[target]++;
            int sum = 0;
            if(i >= d-1) {
                
                int middle = 0, k = 0;
                for(int j=0; j <= 200; j++) {
                    sum += data[j];
                    if(sum > d/2) {
                        middle = j;
                        k = j;
                        break;
                    }
                }
                int second = 0;
                if(d % 2 == 0) {
                    for(int j = k; j >= 0; j--) {
                        sum -= data[j];
                        if(sum < d/2) {
                            second = j;
                            break;
                        }
                    }
                }
                
                if(d % 2 == 0) { 
                    if(middle + second <= expenditure[i+1]) cnt++;
                    
                }
                else {
                    
                    if(middle*2 <= expenditure[i+1]) cnt++;
                }
                data[expenditure[i-d+1]]--;
            }
        }

        return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

 */
