package com.algorithm.week11.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// 행운의 문자열
public class Solution_1342 {
	static String input;
	static Map<Character,Integer> alpha; 
	static Set<Character> key;
	static int size, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		size = input.length();
		sc.close();
		/*  input : aaabbbaa
		 *  alpha : {a : 5, b : 4}
		 *  key : {a,b}
		 * **/
		alpha = new HashMap<Character, Integer>();
		key = new HashSet<>();
		for (int i = 0; i < size; i++) {
			key.add(input.charAt(i));
			if(!alpha.containsKey(input.charAt(i))) {
				alpha.put(input.charAt(i), 1);				
			}else {
				alpha.put(input.charAt(i), alpha.get(input.charAt(i))+1);				
			}
		}
		// 로직
		for (Character first : key) {
			alpha.put(first,alpha.get(first)-1);
			ncr(first, 1);
			alpha.put(first,alpha.get(first)+1);
		}
		// 출력
		System.out.println(ans);
	}
	
	private static void ncr(char cur,int cnt) {
		if(cnt == size) {
			// 행복
			ans++;
		}
		for (Character next : key) {
			// 이전 alpha와 같지 않은 것 중에서
			if(next!=cur) {
				// 사용할 알파벳이 남아있으면
				if(alpha.get(next)!=0) {
					alpha.put(next,alpha.get(next)-1);
					ncr(next, cnt+1);
					alpha.put(next,alpha.get(next)+1);
				}
			}
		}
	}

}
