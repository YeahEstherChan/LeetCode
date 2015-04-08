package com.eco;
/*
*���������ʽʵ�ֹ鲢����ռ临�Ӷȹ̶�
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
	public ListNode sortList(ListNode head) {//head����ͷ���
        int length;
        int mid;
        ListNode cur;
        ListNode righthead,right;
        ListNode lefthead,left;
        ListNode result;
        
        cur=head;
        lefthead=head;
        if(head==null)//head�в����ڽڵ�
        return head;
        else if(head.next==null)//head��ֻ��һ���ڵ㲻��Ҫ��������
        return head;
        else
        {
        length=0;
        while(cur!=null)//��������ĳ���
         {
             cur=cur.next;
             length++;
         }
         mid=length/2;//��0��ʼ����
         cur=head;
         for(int i=1;i<mid;i++)//�ҵ��Ҷ˵�������еĿ�ͷ,�ָ�����������������������β��ָ��null����ݹ�ʱ���һ���
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
    
    public ListNode merge(ListNode left,ListNode right)//����ͷ���
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
