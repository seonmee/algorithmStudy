package com.algorithm.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// 오큰수
public class Solution_17299_v3 {
	static int N;
	static int[] num, stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N];   
		stack = new int[N];// 오큰수를 찾을 후보들을 담을 자료구조
		int top = -1; // stack의 맨 위를 가르키는 변수
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		// 로직
		for (int n = 0; n < N; n++) {
			/*
			 *  1) stack이 비지 않고
			 *  2) 현재 값이 stack에 top의 index에 해당하는 값(오큰수를 찾지 못한 값)보다 큰경우
			 *  >> 오큰수가 존재할때 까지
			 * */
			while(top!=-1 && num[stack[top]] < num[n]) {
				num[stack[top]] = num[n];   // 현재 값이 해당 index의 오큰수
				top--;
			}
			top++;
			stack[top] = n;
		}
		/* stack에 존재하는 index(오큰수를 찾지 못한 index)에 해당하는 값을 -1로 초기화 */
		for (int i = top; i>=0; i--) {
			num[stack[i]] = -1;
		}
		// 출력
		StringBuilder sb = new StringBuilder("");
		for (int n = 0; n < N; n++) {			
			sb.append(num[n]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
