package com.algorithm.week25;

import java.util.*;
/*
 * N과 M (1)
 * */
public class Solution_15649 {
	static int N,M;
	static boolean[] check;
	static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		check = new boolean[N];
		ans = new int[M];
		nPm(0);
	}
	
	private static void nPm(int cnt) {
		
		if(cnt == M) {
			print();
			return;
		}
		for(int i = 0; i < N ; i++) {
			if(check[i]) continue;
			ans[cnt] = i;
			check[i] = true;
			nPm(cnt+1);
			check[i] = false;
		}
		
	}
	
	private static void print() {
		for(int i = 0; i<M ; i++) {
			System.out.print(ans[i]+1 + " ");
		}
		System.out.println();
	}

}
