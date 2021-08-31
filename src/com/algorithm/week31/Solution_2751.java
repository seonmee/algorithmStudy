package com.algorithm.week31;
import java.io.*;
import java.util.*;
/*
 * 수 정렬하기 2 
 * */
public class Solution_2751 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.print(sb.toString());
		
	}

}
