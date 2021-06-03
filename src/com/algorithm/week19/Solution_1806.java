package com.algorithm.week19;
import java.io.*;
import java.util.*;
/*
 * 부분합 
 * 
 * 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이
 * 
 *  N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)
 *  수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수
 *  
 * */
public class Solution_1806 {
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());   
		arr = new int[N];
		S = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = 0;
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		
		while(true) {
			if(sum>=S) {
				sum -= arr[start];
				ans = Math.min(ans, end-start);
				start++;
			}else if(end == N) {
				break;
			}else {
				sum += arr[end];
				end++;
			}
		}
		System.out.println(ans==Integer.MAX_VALUE?0:ans);
		
	}

}
