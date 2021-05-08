package com.algorithm.week15.common;

import java.util.ArrayList;

// 수식 최대화
public class Solution_67257 {
	static char[] op = {'+','-','*'};
	static char[] p;
	static boolean[] visited;
	static ArrayList<Long> num;
	static ArrayList<Character> oper;
	static Long max = Long.MIN_VALUE;
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}
	static public long solution(String expression) {
        p = new char[3];
        visited = new boolean[3];
        num = new ArrayList<Long>();
        oper = new ArrayList<Character>();
        String n ="";
        for (int i = 0,size = expression.length(); i < size; i++) {
			if(expression.charAt(i)>= '0' && expression.charAt(i)<= '9') {
				n+=expression.charAt(i);
			}else {
				num.add(Long.parseLong(n));
				oper.add(expression.charAt(i));
				n = "";
			}
		}
        num.add(Long.parseLong(n));
        nPr(0);
        return max;
    }
	// 1. 우선순위 선정
	private static void nPr(int cnt) {
		if(cnt==3) {
			// 2. 
			max = Math.max(Math.abs(calc()),max);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if(visited[i]) continue;
			p[cnt] = op[i];
			visited[i] = true;
			nPr(cnt+1);
			visited[i] = false;
		}
	}
	private static long calc() {
		ArrayList<Character> temp = new ArrayList<>();
		ArrayList<Long> temp_n = new ArrayList<>();
		temp.addAll(oper);
		temp_n.addAll(num);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < temp.size(); j++) {
				if(temp.get(j)==p[i]) {
					temp_n.add(j,calculation(temp_n.remove(j), temp_n.remove(j),temp.remove(j)));
					j=-1;
				}
			}
		}
		return temp_n.get(0);
	}
	private static long calculation(long n1, long n2, char op) {
		long ans = 0;
		switch(op) {
		case '+' : 
			ans = n1 + n2;
			break;
		case '-' : 
			ans = n1 - n2;
			break;
		case '*' : 
			ans = n1 * n2;
			break;
			
		}
		return ans;
	}

}
