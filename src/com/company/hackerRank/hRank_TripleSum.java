package com.company.hackerRank;

public class hRank_TripleSum {
    
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

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

        HashSet<Integer> set = new HashSet<>();
        int len1 = a.length;
        int len2 = b.length;
        int len3 = c.length;

        for(int i=0; i< len1; i++) set.add(a[i]);
        len1 = set.size();
        int[] arr1 = new int[len1];
        int idx = 0;
        for(int cur : set) arr1[idx++] = cur;
        set.clear(); idx = 0;
        
        for(int i=0; i< len2; i++) set.add(b[i]);
        len2 = set.size();
        int[] arr2 = new int[len2];
        for(int cur : set) arr2[idx++] = cur;
        set.clear(); idx = 0;

        for(int i=0; i< len3; i++) set.add(c[i]);
        len3 = set.size();
        int[] arr3 = new int[len3];
        for(int cur : set) arr3[idx++] = cur;
        set.clear();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        long ans = 0;
        for(int i=0; i< len2; i++) {
            
            int num1 = upper_bound(0, len1, arr2[i], arr1);
            int num2 = upper_bound(0, len3, arr2[i], arr3);
            if(num1 >= 0 && num2 >= 0) {
                ans += (long)num1*(long)num2;
            }
        }

        return ans;
    }
    static int upper_bound(int s, int e, int target, int[] data) {
        int mid = 0;
        while(s < e) {
            mid = (s + e) / 2;
            if(data[mid] <= target) s = mid + 1;
            else e = mid;
        }
        return e;
    }
    
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
 
 */
