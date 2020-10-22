package com.company.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class leetcode706 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
    }
}

/**
class MyHashMap {

    public static final int size = 10000;
    
    public LinkedList<Node>[] bucket;
    public MyHashMap() {
        
        bucket = new LinkedList[size];
        
        for(int i=0; i< size; i++) {
            bucket[i] = new LinkedList<>();
        }
        
    }
    
    
    public void put(int key, int value) {
        
        int idx = key % size;
        int len = bucket[idx].size();
        
        if(len > 0) {
            
            for(int i=0; i< len; i++) {
                Node cur = bucket[idx].get(i);
                if(cur.key == key) {
                    bucket[idx].set(i, new Node(key, value));
                    return;
                }
            }
        }
        bucket[idx].add(new Node(key, value));
        
    }
    
    
    public int get(int key) {
        
        int idx = key % size;
        int len = bucket[idx].size();
        
        if(len == 0) return -1;
        else {
            
            for(Node cur : bucket[idx]) {
                if(cur.key == key) return cur.value;
            }
        }
        return -1;
    }
    
    
    public void remove(int key) {
        
        int idx = key % size;
        int len = bucket[idx].size();
        
        if(len > 0) {
            
            for(int i=0; i< len; i++) {
                
                if(bucket[idx].get(i).key == key) { 
                    bucket[idx].remove(i);
                    break;
                }
                
            }
            
        }
        
    }
    
    public class Node {
        int key, value;
        Node(int a, int b) { 
            key=a; value = b;
        }
    }
}

*/


