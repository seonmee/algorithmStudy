package com.algorithm.week32;

import java.io.*;
import java.util.*;

/*
 * 괄호
 * */
public class Solution_9012 {
	static int T;
	static Stack<Character> check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			check = new Stack<>();
			String input = br.readLine();
			int len = input.length() - 1;
			boolean flag = true;
			for (int i = len; i >= 0; i--) {
				if (input.charAt(i) == ')')
					check.push(')');
				else {
					if(!check.isEmpty())check.pop();
					else {
						flag = false;
						break;
					}
				}
			}
			String ans = " ";
			if (check.size() == 0 && flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.print(sb.toString());
	}

}
