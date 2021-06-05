package com.algorithm.week19.common;

import java.util.*;
/*
 * 성냥개비 
 * 
 * */
public class Solution_3687 {
	static int T;
	static long[] min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		min = new long[101];
		
		min[2] = 1;
		min[3] = 7;
		min[4] = 4;
		min[5] = 2;
		min[6] = 6;
		min[7] = 8;
		min[8] = 10;
		
		for(int i = 9; i<=100 ; i++) {
			min[i] = Long.MAX_VALUE;
			long right = 0;
			for(int j = 2; j <= i-2;j++) {
				if(j!=6) right = min[j];
				else right = 0;
				int length = 1;
				if(right!=0) {
					length = (int)(Math.log10(right)+1);
				}
				min[i] = Math.min(min[i], (long)(min[i-j] * Math.pow(10, length)) +right);		
			}
		}
		int num = 0;
		
		
		for(int t = 0; t < T; t++) {
			num = sc.nextInt();
			String max = "";
			if(num%2==0) { // 짝수 
				for(int i = 0 ; i < num/2; i++) {
					max += "1";
				}
			}else {
				max+="7";
				for(int i =0; i<num/2-1; i++) {
					max+="1";
				}
			}
			System.out.println(min[num] + " " + max);
		}
	}

}