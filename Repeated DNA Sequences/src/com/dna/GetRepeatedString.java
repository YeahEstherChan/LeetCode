package com.dna;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */

public class GetRepeatedString {//���ں��ڴ���������ַ�����ʽ�Ƚϣ���ת����bit
	public static List<String> getRepeated(String s)
	{
		List<String> result=new LinkedList<String>();
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		int begin=0;
		int size=s.length();
		while(begin+10<=size-1)
		{
			String sub=s.substring(begin,begin+10);
			begin++;
			if(map.containsKey(sub))
			{
				int count=map.get(sub);
				map.put(sub, count+1);
				result.add(sub);
			}
			else
			{
				map.put(sub, 1);
			}
		}
		return result;
	}

	public static void main(String args[])
	{
		
		Scanner input=new Scanner(System.in);
		String s=input.next();
		List<String> show=getRepeated(s);
		for(String tmp:show)
		{
			System.out.println(tmp);
		}
	}

}
/**
 * ��������������ڴ�������⣬����������뵽��Ӧ������CS��һ����Ҫ��֧������ϢBioinformatics�о������ݣ�
 * �о�DNA������������Ҫ������Ȼ���ö�˵�����Ƕ������ǹ����ũ��˵������רע���㷨�ɣ����⻹����λ����Bit Operation�����
 * �����������������ƴ洢���ص���Ժ�����Ľ��һЩ���⣬��֮ǰ��Single Number ���������ֺ�Single Number 
 * II ����������֮�����Ǻ���������λ��������⡣�������ڹ��������ַ������ַ�ֻ�����֣��ֱ���A, C, G, T�������������������ǵ�ASCII���ö���������ʾ��

A: 0100 0001����C: 0100 0011����G: 0100 0111����T: 0101 0100

�������ǵ�Ŀ��������λ�������ַ�����Ȼ��Խ��λԽ�ã�ͨ���۲췢�֣�ÿ���ַ��ĺ���λ������ͬ���ʶ����ǿ�����ĩβ��λ���������ĸ��ַ�������ĿҪ����10��
�ַ����ȵĴ���ÿ���ַ�����λ�����֣�10���ַ���Ҫ30λ����32λ����ҲOK��Ϊ����ȡ����30λ�����ǻ���Ҫ�ø�mask��ȡֵΪ0x7ffffff���ô�mask��ȡ����27λ����
����ƽ����λ���ɡ��㷨��˼���ǣ���ȡ����ʮ���ַ�ʱ��������ڹ�ϣ����͸��ַ�������Ƶ��ӳ�䣬֮��ÿ��������λ�滻һ���ַ����������ַ����ڹ�ϣ������ִ��������֮ǰ�պó���
��һ�Σ��򽫵�ǰ�ַ������뷵��ֵ�����鲢������ִ�����һ�������δ���ֹ�������ӳ�䵽1.

 * public class Solution {  
    public List<String> findRepeatedDnaSequences(String s) {  
        List<String> list = new ArrayList<String>();  
        if(s == null || s.length()<=10) return list;  
          
        int mask = 0x7FFFFFF;  
        int i=0;  
        int cur = 0;  
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();  
        while(i<9){  //whileѭ������ͷ���Ǹ��ַ�ת��Ϊ27bit��01��(ֻ��ǰ9���ַ�)
            cur = ((cur<<3) | s.charAt(i) & 7);  
            i++;  
        }  
          
        while(i<s.length()){  
            cur = ((cur & mask)<<3 | s.charAt(i) & 7); //��27bit���ڴ� ��9���ַ� ������λ�����10���ַ����л��������ӣ�
            i++;  
            if(hashmap.containsKey(cur)){  ����ô�֮ǰû�г��֡���HashMap��û�У������´�������List������������ӳ��+1
                int count = hashmap.get(cur);  
                if(count == 1){  
                    list.add(s.substring(i-10,i));  
                }  
                hashmap.put(cur, count+1);  
            }else{  
                hashmap.put(cur,1);  
            }  
        } //ִ��while��䣬ʵ�������ڱ�������String s cur���� �α� <<3�ܻ�ѵ�һ���ַ��Ƶ���|���������һ���ַ�
        return list;  
    }  
}  
 */
