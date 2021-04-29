package com.algorithm.week14;

import java.util.Scanner;
// 그룹 단어 체커
public class Solution_1316 {
	static int N;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ans = 0;
		for(int i = 0; i<N ; i++) {
			String word = sc.next();
			check = new boolean[26];
			check[word.charAt(0)-'a'] = true;
			boolean flag = true;
			for (int j = 1, size = word.length(); j < size; j++) {
				if(!check[word.charAt(j)-'a']) {
					check[word.charAt(j)-'a'] = true;
				}else {
					if(word.charAt(j)!=word.charAt(j-1)) { 
						flag = false;
						continue;
					}
				}
				
			}
			if(flag) ans++;
		}
		System.out.println(ans);
	}

}
