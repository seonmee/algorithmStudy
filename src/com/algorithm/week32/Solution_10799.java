package com.algorithm.week32;

import java.io.*;
import java.util.*;

/*
 * 쇠막대기 
 * 
 * */
public class Solution_10799 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();

		int result = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				stack.push('(');
				continue;
			}
			if (input.charAt(i) == ')') {
				stack.pop();

				if (input.charAt(i - 1) == '(') { // 레이저
					result += stack.size(); // stack의 사이즈만큼 +
				} else { // 레이저 x
					result++; // 1 +
				}
			}
		}
		System.out.print(result);

	}

}
