package com.algorithm.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 오큰수 : 시간초과
public class Solution_17298 {
	static int N;
	static int[] num, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		ans = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		// 로직
		for (int c = 0; c < N; c++) {
			for (int n = c+1; n < N; n++) {
				if(num[c]<num[n]) {
					ans[c] = num[n];
					break;
				}
			}
			if(ans[c]==0) ans[c]=-1;
		}
		// 출력
		for (int n = 0; n < N; n++) {			
			if(n==N-1) System.out.println(ans[n]);
			else System.out.print(ans[n] + " ");
		}
	}

}
