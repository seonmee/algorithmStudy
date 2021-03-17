package com.algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_14889 {
	static int N;
	static int[] p;
	static ArrayList<Integer>sts, link;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		int ans = Integer.MAX_VALUE;
		p = new int[N];
		for (int i = N-1; i >= N/2; i--) {
			p[i]=1;
		}
		do {
			sts = new ArrayList<>();
			link = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(p[i]==1) {
					sts.add(i);
				}else {
					link.add(i);
				}
			}
			int sumS = 0, sumL = 0;
			for (Integer r : sts) {
				for (Integer c : sts) {
					if(r!=c) {
						sumS += map[r][c];
					}
				}
			}
			for (Integer r : link) {
				for (Integer c : link) {
					if(r!=c) {
						sumL += map[r][c];
					}
				}
			}
			ans = Math.min(ans, Math.abs(sumL-sumS));
		}while(np(p.length-1));
		System.out.println(ans);
	}
	private static boolean np(int size) {
		int i = size;
		while(i>0 &&p[i-1] >=p[i])i--;
		if(i==0)return false;
		int j = size;
		while(p[i-1]>=p[j])j--;
		swap(i-1,j);
		int k = size;
		while(i<k) {
			swap(i,k);
			i++;
			k--;
		}
		return true;
	}
	private static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
