package com.company.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pro42579 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
    }
}
/**
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        int len = genres.length;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, PriorityQueue<Node>> que = new HashMap<>();
        for(int i=0; i< len; i++) {
            String target = genres[i];
            map.put(target, map.getOrDefault(target, 0) + plays[i]);
            
            PriorityQueue<Node> list = 
                que.getOrDefault(target, new PriorityQueue<>(new sortNode()));
            list.add(new Node(plays[i], i));
            que.put(target, list);
        }
        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Comparator<String> mySort = new Comparator<String>() {
            public int compare(String a, String b) {
                return map.get(b) - map.get(a);
            }
        };
        Collections.sort(arr, mySort);
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(String next: arr) {
            PriorityQueue<Node> tmp = que.get(next);
            int cnt = 0;
            while(!tmp.isEmpty()) {
                Node n = tmp.poll();
                cnt++;
                ans.add(n.index);
                
                if(cnt == 2) break;
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0; i< ans.size(); i++) answer[i] = ans.get(i);
        
        return answer;
    }
    class sortNode implements Comparator<Node> {
        public int compare(Node a, Node b){
            if(a.num != b.num) return b.num - a.num;
            else return a.index - b.index;
        }
    }
    class Node {
        int num, index;
        Node(int a, int b) {
            num = a; index = b;
        }
    }
}
*/
