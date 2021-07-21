package com.algorithm.week25;

import java.util.Scanner;

/*
 * N과 M (2)
 * */
public class Solution_15650 {
	static int N,M;
	static int[] ans;
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[M];
		nCm(0,0);
	}
	private static void nCm(int start, int cnt) {
		if(cnt==M) {
			print();
			return;
		}
		for(int i = start ; i < N ; i++) {
			ans[cnt] = i;
			nCm(i+1,cnt+1);
		}
	}
	private static void print() {
		for(int i = 0; i<M ; i++) {
			System.out.print(ans[i]+1 + " ");
		}
		System.out.println();
	}

}
