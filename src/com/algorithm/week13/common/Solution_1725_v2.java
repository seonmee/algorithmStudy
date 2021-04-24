package com.algorithm.week13.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

// 히스토그램
public class Solution_1725_v2 {
// 4 * 100,000 byte = 400,000byte = 0.4 MB 
// ArrayList 100,000 * 100,000 * 4 = 4,000,000,000 byte = 4,000MB
	public static void main(String[] args) throws Exception {
		int N;
		int[] heights;
		TreeSet<Integer> wides = new TreeSet<>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		heights = new int[N];
		for (int n = 0; n < N; n++) {
			heights[n] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < N; i++) {
				int height = heights[i];
				int width = 0;
			for (int j = 0; j < N; j++) {
				
				if(height<=heights[j]) width++;
				else {
					wides.add(width * height);
					width = 0;
				}
				if(j==N-1)wides.add(width * height);
			}
		} 
		
		System.out.println(wides.last());
	}

}
