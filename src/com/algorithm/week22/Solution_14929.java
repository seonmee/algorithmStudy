package com.algorithm.week22;
import java.util.*;
/*
 * 거스름돈 
 * */
public class Solution_14929 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0, sum = 0;
		N = sc.nextInt();
		if( N == 1 || N == 3) {
			System.out.print(-1);
			System.exit(0);
		}
		if( N % 5 % 2 == 0) System.out.print(N/5 + N%5/2);
		else System.out.print(N/5-1 + (N%5+5)/2);
		
	}

}
