package com.company.hackerRank;

public class hRank_IceCreamParlor {
    
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

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int len = cost.length;
        for(int i=1; i<=len; i++) {
            map.put(cost[i-1], i);
        }

        for(int i=0; i< len; i++) {
            int target = money - cost[i];
            if(map.containsKey(target)) {
                int val = map.get(target);
                if(i+1 == val) continue;
                int val2 = i+1;
                if(val2 > val) System.out.println(val+" "+val2);
                else System.out.println(val2+" "+val);

                return;
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
 
 */
