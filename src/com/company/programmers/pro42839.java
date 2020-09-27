package com.company.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pro42839 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringTokenizer st = new StringTokenizer("");
        String str = "abc";
        
    }
}
/**
import java.util.*;

class Solution {
    public int LEN = 10000000;
    public int[] prime = new int[LEN]; 
    public char[] ch;
    public int[] flag;
    public HashSet<Integer> set;
    public int solution(String numbers) {
        
        set = new HashSet<>();
        
        prime[0] = 1; prime[1] = 1;
        for(int i=2; i< LEN; i++) {
            if(prime[i] == 1) continue;
            for(int j= i+i; j < LEN; j += i) {
                if(prime[j] == 1) continue;
                prime[j] = 1;
            }
        }
        
        ch = numbers.toCharArray();
        int size = ch.length;
        flag = new int[size];
        
        for(int i=0; i< size; i++) {
            flag[i] = 1;
            search(new StringBuilder(), i, 0, size);
            flag[i] = 0;
        }
        
        return set.size();
    }
    public void search(StringBuilder sb, int index, int curSize ,int size) {
        
        sb.append(ch[index]);
        if(sb.toString().startsWith("0")) return;
        
        int num = Integer.parseInt(sb.toString());
        
        if(prime[num] == 0 && !set.contains(num)) {
            set.add(num);
        }
        
        if(curSize >= size -1) return;
        
        for(int i = 0; i< size; i++) {
            if(i == index) continue;
            if(flag[i] == 1) continue;
            
            flag[i] = 1;
            search(sb, i, curSize + 1, size);
            sb.deleteCharAt(sb.length()-1);
            flag[i] = 0;
        }
        
    }
} 
 */
