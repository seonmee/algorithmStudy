package com.algorithm.week25;

import java.io.*;
import java.util.*;
/**
 * 과제 안내신분..?
 * */
public class Solution_5597 {
	static final int COUNT = 28;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		check = new boolean[30];
		for(int i = 0; i < COUNT; i++) {
			int idx = Integer.parseInt(br.readLine());
			check[idx-1] = true;
		}
		for(int i = 0; i < 30; i++) {
			if(!check[i])System.out.println(i+1);
		}
	
	}
}
