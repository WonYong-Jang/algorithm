package com.company.leetcode;

public class leetcode93 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }   
}

/**
class Solution {
    
    ArrayList<String> ans;
    int len;
    int[] idxArr;
    public List<String> restoreIpAddresses(String s) {
        
        len = s.length();
        ans = new ArrayList<>();
        idxArr = new int[4];
        
        search(0, 0, s);
        
        return ans;
    }
    public void search(int cur, int index, String s) {
        
        if(cur == 3) {
            
            String str1 = s.substring(0, idxArr[0]);
            String str2 = s.substring(idxArr[0], idxArr[1]);
            String str3 = s.substring(idxArr[1], idxArr[2]);
            String str4 = s.substring(idxArr[2], len);
            if(isCheck(str1) && isCheck(str2) && isCheck(str3) && isCheck(str4)) {
                StringBuilder sb = new StringBuilder();    
                sb.append(str1);
                sb.append(".");
                sb.append(str2);
                sb.append(".");
                sb.append(str3);
                sb.append(".");
                sb.append(str4);
                ans.add(sb.toString());
                
            }
            
            return;
        }
        
        for(int i=index+1; i< len; i++) {
            if(i - index > 3) return;
            idxArr[cur] = i;
            search(cur+1, i, s);
        }
        
    }
    public boolean isCheck(String str) {
        int len = str.length();
        if(len == 0 || len > 3) return false;
        
        if(len > 1 && str.startsWith("0")) return false;
        
        int num = Integer.parseInt(str);
        return num >=0 && num <= 255;
    }
    
}


/**
for(int i=0; i< len ; i++) {
            if(i-0 >= 3 ) continue;
            for(int j=i+1; j< len; j++) {
                if(j-i-1 >= 3) continue;
                for(int k= j+1; k< len; k++) {
                    if(len - k - 1 > 3) continue;
                    String str1 = s.substring(0, i+1);
                    String str2 = s.substring(i+1, j+1);
                    String str3 = s.substring(j+1, k+1);
                    String str4 = s.substring(k+1, len);
                    if(isCheck(str1)&&isCheck(str2)&&isCheck(str3)&&isCheck(str4)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(str1);
                        sb.append(".");
                        sb.append(str2);
                        sb.append(".");
                        sb.append(str3);
                        sb.append(".");
                        sb.append(str4);
                        ans.add(sb.toString());
                    }
                }
            }
        }
**/
 */

/**
class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        
        int len = s.length();
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i=0; i< len ; i++) {
            if(i-0 >= 3 ) continue;
            for(int j=i+1; j< len; j++) {
                if(j-i-1 >= 3) continue;
                for(int k= j+1; k< len; k++) {
                    if(len - k - 1 > 3) continue;
                    String str1 = s.substring(0, i+1);
                    String str2 = s.substring(i+1, j+1);
                    String str3 = s.substring(j+1, k+1);
                    String str4 = s.substring(k+1, len);
                    if(isCheck(str1)&&isCheck(str2)&&isCheck(str3)&&isCheck(str4)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(str1);
                        sb.append(".");
                        sb.append(str2);
                        sb.append(".");
                        sb.append(str3);
                        sb.append(".");
                        sb.append(str4);
                        ans.add(sb.toString());
                    }
                }
            }
        }
        
        
        return ans;
    }
    public boolean isCheck(String str) {
        int len = str.length();
        if(len == 0 || len > 3) return false;
        
        if(len > 1 && str.startsWith("0")) return false;
        
        int num = Integer.parseInt(str);
        return num >=0 && num <= 255;
    }
    
} 
 */
