package com.algorithm.week28;
import java.util.*;
import java.io.*;
/*
 * 랜선 자르기 
 * */
public class Solution_1654 {	
	static int K, N;
	static int[] lines;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		lines = new int[K];
		
		for(int i = 0; i < K ; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lines);
		
		long end = lines[K-1];
		long start = 1;
		long middle;
		
		while(end >= start) {
			middle = (start+end)/2;
			long cnt = 0;
			
			for(int j = 0; j < lines.length; j++) {
				cnt += lines[j]/middle;
			}
			
			if(cnt >= N) start = middle + 1;
			else end = middle - 1;
		}
		
		System.out.print(end);
	}

}
