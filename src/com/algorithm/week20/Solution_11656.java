package com.algorithm.week20;

import java.util.*;
/*
 * 접미사 배열
 */
public class Solution_11656 {
	static String[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int L = word.length();
		arr = new String[L];
		for(int i = 0; i < L; i++) {
			arr[i] = word.substring(i,L);
		}
		Arrays.sort(arr);
		for(int i = 0; i < L; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
