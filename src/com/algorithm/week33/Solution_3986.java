package com.algorithm.week33;

import java.util.*;
import java.io.*;
/*
 * 좋은 단어 
 * */
public class Solution_3986 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int count = 0;
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();	
			int len = str.length();
			stack.push(str.charAt(0));
			
			for(int j = 1; j < len; j++) {
				char cur = str.charAt(j);
				if(!stack.isEmpty()) {
					char pre = stack.peek();
					if(pre == cur) {	
						stack.pop();
						continue;
					}
				}
				stack.push(cur);
			}
			
			if(stack.isEmpty()) {	// 좋은 단어
				count++;
			}
		}
		System.out.println(count);
	}

}
