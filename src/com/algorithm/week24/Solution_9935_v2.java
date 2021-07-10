package com.algorithm.week24;

import java.util.*;
import java.io.*;
/*
 * 문자열 폭발 
 * 
 * 문자열 길이 <= 1,000,000
 * 
 * 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
 * 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
 * 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
 * */
public class Solution_9935_v2 {
	// mirkovC4nizCC44
	// C4
	
	// 1 12ab 2ab 
	// 12ab112ab2ab
	// 12ab
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String expWord = br.readLine();
		
		br.close();
		
		Stack<Character> ans = new Stack<>();
		
		int idx = 0;                   // 폭발문자열의 인덱스 
		int eLen = expWord.length();   // 폭발문자열 길이 
		for(int i = 0, len = word.length(); i < len; i++ ) {
			char c = word.charAt(i);
			
			if(c==expWord.charAt(eLen-1)) { // 폭발문자열의 마지막문자와 같으면  
				if(ans.size() < eLen-1) {
					ans.push(c);
				}else {
					// 일치하는지 확인 
					boolean isEqual = true;
					for(int j = 0; j < eLen-1 ; j++) {
						if(ans.get(ans.size()-(eLen-1) + j)!=expWord.charAt(j)) {
							isEqual = false;
							break;
						}
					}
					if(isEqual) { // 일치하면 
						for(int j = 0; j < eLen-1; j++) {
							ans.pop();
						}
				
					}else {
						ans.push(c);
					}
				}
			}else {
				ans.push(c);
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		if(ans.isEmpty()) {
			System.out.print("FRULA");
		}else {
			for(Character c : ans) {
				sb.append(c);
			}
			System.out.print(sb.toString());
		}
		
		
		
	}

}
