package com.algorithm.week20;

import java.io.*;
import java.util.*;
/*
 *  연산자 끼워넣기 
 * */
public class Solution_14888 {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] num;
	static char[] op, p;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		op = new char[N-1];
		p = new char[N-1];
		visited = new boolean[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 숫자 입력 
		for(int i = 0; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력 
		st = new StringTokenizer(br.readLine());
		String oper = "";
		for(int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j <cnt; j++) {
				if(i==0) oper += "+";
				else if(i==1) oper += "-";
				else if(i==2) oper += "*";
				else oper +="/";
			}
		}
		op = oper.toCharArray();
		// 로직
		nPn(0);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	// 연산자 정렬 
	private static void nPn(int cnt) {
		if(cnt == N-1) {
			int num = calculate();
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for(int i =0; i<N-1;i++) {
			if(visited[i])continue;
			p[cnt] = op[i];
			visited[i] = true;
			nPn(cnt+1);
			visited[i] = false;	
		}
	}

	private static int calculate() {
		int ans = num[0];
		for(int i = 0; i<N-1; i++) {
			if(p[i]=='+') ans += num[i+1];
			else if(p[i]=='-') ans -= num[i+1];
			else if(p[i]=='*') ans *= num[i+1];
			else if(ans<0)ans = -(Math.abs(ans)/ num[i+1]);
			else ans /= num[i+1];
		}
		return ans;
	}

}
