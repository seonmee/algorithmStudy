package com.algorithm.week14;

import java.util.Scanner;
// 팰린드롬인지 확인하기
public class Solution_10988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int size = input.length();
		int len = (int)Math.ceil(size/2);
		int ans = 1;
		for(int i = 0; i<len ; i++) {
			if(input.charAt(i)!=input.charAt(size-1-i)) {
				ans = 0;
				break;
			}
		}
		System.out.println(ans);
	}

}
