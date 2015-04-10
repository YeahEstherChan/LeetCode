package com.eco;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        TreeNode cur;
	        List<List<Integer>> list=new LinkedList<List<Integer>>();
	        Queue<TreeNode> queue=new LinkedList<TreeNode>();
	        Stack<List<Integer>> stack=new Stack<List<Integer>>();
	        
	        if(root==null)
	        return list;
	        
	        cur=root;
	        queue.offer(cur);
	        while(!queue.isEmpty())
	        {
	            List<Integer> listline=new LinkedList<Integer>();
	            int size=queue.size();
	            for(int i=0;i<size;i++)
	            {
	                TreeNode tmp=queue.poll();
	                listline.add(tmp.val);
	                if(tmp.left!=null)
	                {
	                    queue.offer(tmp.left);
	                }
	                if(tmp.right!=null)
	                {
	                    queue.offer(tmp.right);
	                }
	            }
	            stack.push(listline);
	        }
	        while(!stack.isEmpty())
	        {
	            list.add(stack.peek());
	            stack.pop();
	        }
	        return list;
	    }

}

/*
 * µÝ¹é½â·¨
 */

public class Solution {
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (root == null) return list;

    List<TreeNode> cur = new ArrayList<TreeNode>();
    cur.add(root);
    traverse(cur, list);
    return list;
}

private void traverse(List<TreeNode> cur, List<List<Integer>> list) {
    if (cur.size() == 0) return;

    List<TreeNode> next = new ArrayList<TreeNode>();
    for (TreeNode i : cur) {
        if (i.left != null) next.add(i.left);
        if (i.right != null) next.add(i.right);
    }

    traverse(next, list);

    List<Integer> curLevel = new ArrayList<Integer>();
    for (TreeNode i : cur)
        curLevel.add(i.val);
    list.add(curLevel);
}
}
