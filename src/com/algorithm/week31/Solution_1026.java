package com.algorithm.week31;

import java.io.*;
import java.util.*;
/*
 * 보물 
 * */
public class Solution_1026 {
	static int[] A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	 
	        A = new int[n];
	        B = new int[n];
	 
	        for (int i = 0; i < n; i++) {
	            A[i] = Integer.parseInt(br.readLine());
	        }
	        for (int i = 0; i < n; i++) {
	            B[i] = Integer.parseInt(br.readLine());
	 
	        }
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        int sum = 0;
	        for (int i = 0; i < n; i++) {
	            sum += A[i] * B[n - 1 - i];
	        }
	        
	        System.out.println(sum);
	}

}
