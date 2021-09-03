package com.algorithm.week31;

import java.util.*;
import java.io.*;

/*
 * 사과나무 
 * */
public class Solution_19539 {
	static int N, height, sum, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height = Integer.parseInt(st.nextToken()); 
			sum += height;
			if(height%2 == 1) num++;
		}
		
		if(sum%3 ==0 && num <= sum/3) System.out.println("YES");
		else System.out.println("NO");
	}

}
