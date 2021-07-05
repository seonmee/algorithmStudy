package com.algorithm.week24;
import java.util.*;
import java.io.*;
/*
 * 배열 합치기
 * */
public class Solution_11728 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[A];
		int[] arr2 = new int[B];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< A; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< B; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
				
		int i = 0, j = 0;
		StringBuilder ans = new StringBuilder("");
		while(i<A && j <B) {
			if(arr1[i]>arr2[j]) {
				ans.append(arr2[j++]).append(" ");
			}else {
				ans.append(arr1[i++]).append(" ");
			}
		}
		while(i<A) {
			ans.append(arr1[i++]).append(" ");
		}
		while(j<B) {
			ans.append(arr2[j++]).append(" ");
		}
		System.out.print(ans.toString());
		
	}

}
