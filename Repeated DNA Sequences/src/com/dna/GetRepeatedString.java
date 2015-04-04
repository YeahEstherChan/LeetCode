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

public class GetRepeatedString {//不在乎内存溢出，以字符串形式比较，不转换成bit
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
 * 题意分析：由于内存溢出问题，看到这道题想到这应该属于CS的一个重要分支生物信息Bioinformatics研究的内容，
 * 研究DNA序列特征的重要意义自然不用多说，但是对于我们广大码农来说，还是专注于算法吧，此题还是用位操作Bit Operation来求解
 * ，计算机由于其二进制存储的特点可以很巧妙的解决一些问题，像之前的Single Number 单独的数字和Single Number 
 * II 单独的数字之二都是很巧妙利用位操作来求解。此题由于构成输入字符串的字符只有四种，分别是A, C, G, T，下面我们来看下它们的ASCII码用二进制来表示：

A: 0100 0001　　C: 0100 0011　　G: 0100 0111　　T: 0101 0100

由于我们的目的是利用位来区分字符，当然是越少位越好，通过观察发现，每个字符的后三位都不相同，故而我们可以用末尾三位来区分这四个字符。而题目要求是10个
字符长度的串，每个字符用三位来区分，10个字符需要30位，在32位机上也OK。为了提取出后30位，我们还需要用个mask，取值为0x7ffffff，用此mask可取出后27位，再
向左平移三位即可。算法的思想是，当取出第十个字符时，将其存在哈希表里，和该字符串出现频率映射，之后每向左移三位替换一个字符，查找新字符串在哈希表里出现次数，如果之前刚好出现
过一次，则将当前字符串存入返回值的数组并将其出现次数加一，如果从未出现过，则将其映射到1.

 * public class Solution {  
    public List<String> findRepeatedDnaSequences(String s) {  
        List<String> list = new ArrayList<String>();  
        if(s == null || s.length()<=10) return list;  
          
        int mask = 0x7FFFFFF;  
        int i=0;  
        int cur = 0;  
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();  
        while(i<9){  //while循环将开头的是个字符转换为27bit的01串(只有前9个字符)
            cur = ((cur<<3) | s.charAt(i) & 7);  
            i++;  
        }  
          
        while(i<s.length()){  
            cur = ((cur & mask)<<3 | s.charAt(i) & 7); //将27bit的在串 即9个字符 左移三位，与第10个字符进行或运算连接，
            i++;  
            if(hashmap.containsKey(cur)){  如果该串之前没有出现、即HashMap中没有，即是新串，放入List里，如果存在则将其映射+1
                int count = hashmap.get(cur);  
                if(count == 1){  
                    list.add(s.substring(i-10,i));  
                }  
                hashmap.put(cur, count+1);  
            }else{  
                hashmap.put(cur,1);  
            }  
        } //执行while语句，实际上是在遍历整个String s cur即是 游标 <<3总会把第一个字符移调，|后会连接下一个字符
        return list;  
    }  
}  
 */
