package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class leetcode895 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Integer> st = new Stack<>();
        List<Double> temperature = new ArrayList<>(Arrays.asList(new Double[] { 20.0, 22.0, 22.5 })); 
        temperature.forEach(s -> System.out.println(s)); 
        
        temperature.forEach(System.out::println);
        
        HashMap<String, Integer> map = new HashMap<>();
        //map.put("A", 5);
        map.computeIfAbsent("A", z -> 10);
        System.out.println(map.get("A"));
        
    }
}
/**
class FreqStack {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxNum;
    public FreqStack() {
        maxNum = 0;
        freq = new HashMap<>();
        group = new HashMap<>();
    }
    
    public void push(int x) {
        int num = freq.getOrDefault(x,0)+1;
        freq.put(x, num);
        
        maxNum = max(maxNum, num);
        
        group.computeIfAbsent(num, z -> new Stack<>()).push(x);
    }
    
    public int pop() {
        
        int answer;
        
        if( group.get(maxNum).isEmpty() ) maxNum--;
        
        answer = group.get(maxNum).pop();
        
        freq.put(answer, freq.get(answer)-1);
        
        return answer;
    }
    public int max(int a, int b) { return a > b ? a : b;}
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
 




