package com.company.cs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
/**
 * 재관이의 대량할인   
 *
 */
public class swExpert4050 {
     
    public static ArrayList<Integer> arr;
    public static int N;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int k=1; k<= testCase; k++)
        {
            int result =0;
            N = scanner.nextInt();
            arr = new  ArrayList<>();
            for(int i=0; i<N; i++)
            {
                arr.add(scanner.nextInt());
            }
            Collections.sort(arr);
            Collections.reverse(arr);
             
            for(int i=1; i<=N; i++)
            {
                if(i%3 !=0 ) {
                    result += arr.get(i-1);
                }
            }
            System.out.println("#"+k+" "+result);
        }
         
    }
}