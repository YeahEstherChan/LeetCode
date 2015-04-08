package com.eco;
/*
*以链表的形式实现归并排序空间复杂度固定
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class MergeSortByLinkedList {
	public ListNode sortList(ListNode head) {//head不带头结点
        int length;
        int mid;
        ListNode cur;
        ListNode righthead,right;
        ListNode lefthead,left;
        ListNode result;
        
        cur=head;
        lefthead=head;
        if(head==null)//head中不存在节点
        return head;
        else if(head.next==null)//head中只有一个节点不需要进行排序
        return head;
        else
        {
        length=0;
        while(cur!=null)//计算链表的长度
         {
             cur=cur.next;
             length++;
         }
         mid=length/2;//从0开始计数
         cur=head;
         for(int i=1;i<mid;i++)//找到右端的有序队列的开头,分隔成两个链表必须把左端链表的尾部指向null否则递归时左右混淆
         {
             cur=cur.next;
         }
         righthead=cur.next;
         cur.next=null;
         left=sortList(lefthead);
         right=sortList(righthead);
         result=merge(left,right);
        }
        return result;
    }
    
    public ListNode merge(ListNode left,ListNode right)//不带头结点
    {
     ListNode result;
     ListNode rp,lp,sp;
     
     rp=right;
     lp=left;
     if(rp.val<lp.val)
     {
         result=right;
         sp=right;
         rp=rp.next;
     }
     else
     {
         result=left;
         sp=left;
         lp=lp.next;
     }
     while(lp!=null&&rp!=null)
     {
         if(lp.val<rp.val)
         {
             sp.next=lp;
             sp=lp;
             lp=lp.next;
         }
         else
         {
             sp.next=rp;
             sp=rp;
             rp=rp.next;
         }
     }
     if(lp!=null)
     sp.next=lp;
     else if(rp!=null)
     sp.next=rp;
     return result;
    }

}
