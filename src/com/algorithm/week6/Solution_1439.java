package com.algorithm.week6;

import java.util.Scanner;

public class Solution_1439 {
	static char[] input;
	
	public static void main(String[] args) { 
		Scanner sc= new Scanner(System.in);
		input = sc.next().toCharArray();
		sc.close();
		char cur = input[0];
		int cnt=1;
		for (int i = 1; i < input.length; i++) {
			if(cur!=input[i]) {
				cnt++;
				cur = Character.forDigit(1-(cur-'0'), 10) ;
			}
		}
		System.out.println(cnt/2);
	}

}
