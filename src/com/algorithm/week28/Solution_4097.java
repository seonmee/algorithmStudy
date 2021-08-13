package com.algorithm.week28;

import java.util.*;
import java.io.*;

/*
 * 수익 
 * N개 (1 ≤ N ≤ 250,000) 
 * 수익 (-10,000 ≤ P ≤ 10,000) 
 * */
public class Solution_4097 {
	static int N, P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)break;
			int max = Integer.MIN_VALUE;
			P = 0;
			for (int i = 0; i < N; i++) {
				P += Integer.parseInt(br.readLine());
				max = Math.max(max, P);
				if(P < 0) P = 0;
			}
			System.out.println(max);
		}
	}

}
