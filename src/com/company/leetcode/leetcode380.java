package com.company.leetcode;

import java.util.ArrayList;
import java.util.Random;

public class leetcode380 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/*
class RandomizedSet {

    
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    int size;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
        r = new Random();
    }
    
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,size++);
        list.add(val);
        
        return true;
    }
    
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val); 
        int num = list.get(size-1);
        map.put(num, idx);
        map.remove(val);
        list.set(idx, num);
        list.remove(--size);
        
        return true;
    }
    
    public int getRandom() {
        int idx = r.nextInt(size);
        return list.get(idx);
    }
}
**/
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */ 
 
