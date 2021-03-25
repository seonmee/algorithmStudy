package com.algorithm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1219_dfs {
	static int N, ans;
	static int[] one, two;
	static boolean[] ch;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			N = Integer.parseInt(st.nextToken());
			one = new int[100];
			two = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(one[from]==0) {
					one[from]= to;
				}else {
					two[from]= to;
				}
			}
			ans = 0;
			ch = new boolean[100];
			dfs(0);
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void dfs(int from) {
		if(from==99) {
			ans =1;
		}
		if(!ch[from]) {			
			if(one[from]!=0) {
				ch[from] = true;
				dfs(one[from]);
				ch[from] = false;
				
			}
			if(two[from]!=0) {
				ch[from] = true;
				dfs(two[from]);
				ch[from] = false;
				
			}
		}
		
	}

}
