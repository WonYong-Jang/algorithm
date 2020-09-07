package com.company.leetcode;

public class leetcode341 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/**
public class NestedIterator implements Iterator<Integer> {

    public Queue<Integer> que;
    public NestedIterator(List<NestedInteger> nestedList) {
        
        que = new LinkedList<>();
        
        dfs(nestedList);
    }
    public void dfs(List<NestedInteger> nestedList) {
        
        
        for(NestedInteger target : nestedList) {
            
            if(target.isInteger()) que.add(target.getInteger());
            else {
                dfs(target.getList());   
            }
        }
        
    }
    @Override
    public Integer next() {
        return que.poll();
    }

    @Override
    public boolean hasNext() {
        return !que.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

