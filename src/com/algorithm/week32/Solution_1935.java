package com.algorithm.week32;

import java.io.*;
import java.util.*;

/*
 * 후위표기식 2 
 * 
 * */
public class Solution_1935 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String text = br.readLine();

		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		Stack<Double> operands = new Stack<>();
		int len = text.length();
		for (int i = 0; i < len; i++) {
			char c  = text.charAt(i);
			if ('A' <= c && c <= 'Z') { // 피 연산자 
				double operand = num[c - 'A'];
				operands.push(operand);
			} else { // 연산자 
				double one = operands.pop();
				double two = operands.pop();
				double result = 0.0;
				switch (c) {
				case '+':
					result = one + two;
					break;
				case '-':
					result = one - two;
					break;
				case '*':
					result = one * two;
					break;
				case '/':
					result = one / two;
					break;
				}
				operands.push(result);
			}
		}
		System.out.printf("%.2f", operands.pop());
	}
}
