package com.eco;
/*
 * ���������ʽʵ�ֶ�����,����󶥶ѵõ������list
 */

public class HeadSort {
	public void  HeadAdjust(int[] list,int adjust,int end)//adjustΪ�������ڵ���±�
	{
		int j;
		for(j=2*adjust;j<=end;j=j*2)
		{ 
			if(j<end&&list[j]<list[j+1])//j<end˵��adjust�ڵ㻹�������ӣ���Ҫ�������ӱȽ�ȡ���ֵ
				j++;
			if(list[adjust]>list[j]) break;
			else
			{
				int val=list[adjust];
				list[adjust]=list[j];
				list[j]=val;
				adjust=j;
			}
		}
		
	}
	public void HeadSortFun(int[] list)
	{
		
		int begin=(list.length-1)/2;
		for(int i=begin;i>0;i--)//��ʼ���������������ɶѣ������һ����Ҷ�ӽڵ㿪ʼ
		{
			HeadAdjust(list,i,list.length-1);
		}
		
		for(int j:list)
		{
			System.out.print(j+" ");
		}
		System.out.println();
		
		for(int i=list.length-1;i>0;i--)//ÿ�ν���������Ϊlist[n]�����list[1- n-1]����
		{
			int tmp;
			tmp=list[i];
			list[i]=list[1];
			list[1]=tmp;
			HeadAdjust(list,1,i-1);
		}
	}
	
	public static void main(String args[])
	{
		int [] list={0,16,5,7,21,46,89,3,100,345,1,9};
		HeadSort hs=new HeadSort();
		hs.HeadSortFun(list);
		for(int i:list)
		{
			System.out.print(i+" ");
		}
	}
	

}
