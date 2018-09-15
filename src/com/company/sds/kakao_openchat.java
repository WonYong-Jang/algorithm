package com.company.sds;

import java.util.HashMap;
import java.util.StringTokenizer;

class openchat {
	
	static HashMap<String, String> map = new HashMap<>();
    public String[] solution(String[] record) {
    	int len = record.length;
    	String[] idArr = new String[len];
    	String[] printArr = new String[len];
  
        StringTokenizer st; 
        String cmd, id, name;
        int idx =0;
        for(int i=0; i<len; i++)
        {
        	st = new StringTokenizer(record[i]);
        	cmd = st.nextToken(); // 명령
        	if(cmd.equals("Enter"))
        	{
        		id = st.nextToken();
        		name = st.nextToken();
        		map.put(id, name);
        		printArr[idx] = "님이 들어왔습니다.";
        		idArr[idx] = id;
        		idx +=1;
        		
        	}
        	else if(cmd.equals("Leave"))
        	{
        		id = st.nextToken();
        		printArr[idx] = "님이 나갔습니다.";
        		idArr[idx] = id;
        		idx+=1;
        	}
        	else if(cmd.equals("Change"))
        	{
        		id = st.nextToken();
        		name = st.nextToken();
        		map.replace(id, name);
        	}
        }
        String[] answer = new String[idx];
        
        for(int i=0; i< idx; i++)
        {
        	answer[i] = (map.get(idArr[i])+printArr[i]);
        }
        
        return answer;
    } 
}