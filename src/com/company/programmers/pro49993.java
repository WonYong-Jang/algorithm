package com.company.programmers;

public class pro49993 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] origin = new int[27];
        int[] data = new int[27];
        for(int i=0; i< skill.length(); i++) origin[skill.charAt(i) - 'A'] = 1;
        
        int len = skill_trees.length;
        for(int i=0; i< len; i++) {
            
            String target = skill_trees[i];
            int index =0;
            boolean flag = true;
            
            for(int j=0; j< 27; j++) data[j] = origin[j];
            
            for(int j=0; j< target.length(); j++) {
                
                if(index >= skill.length()) break;
                
                data[skill.charAt(index)- 'A'] = 0;
                if(data[target.charAt(j) - 'A'] == 1 ) {
                    flag = false;
                    break;
                }
                if(target.charAt(j) == skill.charAt(index)) {
                    index++;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
} 
 */
