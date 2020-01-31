package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class leetcode406 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                if(a[0] != b[0]) return b[0] - a[0];
                else return a[1] - b[1];
            }
        });
        
        ArrayList<int[]> arr = new ArrayList<>();
        /*
        for(int i=0; i< people.length; i++)
        {
            int[] list = people[i];
            arr.add(list[1], list);
        }
        */
        
        arr.add(0, people[0]);
        arr.add(1, people[1]);
        arr.add(1, people[2]);
        arr.add(0, people[3]);
        arr.add(2, people[4]);
        arr.add(4, people[5]);
        
        for(int[] cur : arr)
        {
            System.out.println(cur[0] + " " + cur[1]);
        }
        
    }
}
/**
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
            
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int[] cur : people)
        {
            arr.add(cur[1], cur);
        }
        
        return arr.toArray(new int[people.length][2]);
    }
}
 */
