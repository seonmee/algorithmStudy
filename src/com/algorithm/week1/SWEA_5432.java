package com.algorithm.week1;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432 {
	static Stack<Character> st;
	static int T;

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		T = sn.nextInt();
		st = new Stack<>();
		for (int t = 1; t <= T; t++) {
			int sum = 0, flag = 0;
			char[] line = sn.next().toCharArray();
			for (char c : line) {
				int count;
				// 1. ( 면 stack에 넣기
				if (c == '(') {
					st.push(c);
					flag = 0;
					continue;
				}
				// 닫는 괄호면
				st.pop();
				if (flag++ == 0) // 레이저 (앞에 여는 괄호가 왔다)
					sum += st.size();
				else // 막대의 끝
					sum += 1;

			}
			System.out.println("#" + t + " " + sum);
		}
	}

}
