package com.algorithm.week29;
import java.io.*;
/*
 * 칸토어 집합 
 * 
 * 
 * */
public class Solution_4779 {
	static char[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		String kanto;
		
		while((kanto = br.readLine())!=null) {
			int N = (int)Math.pow(3, Integer.parseInt(kanto));
			ans = new char[N];
			
			for(int i = 0; i < N; i++) {
				ans[i] = ' ';
			}
			makeString(0,N-1,N);
			
			for(char text : ans) {
				sb.append(text);
			}
			sb.append("\n");
			
		}
		System.out.print(sb.toString());
	}
	private static void makeString(int start, int end, int len) {
		if(len==1) {
			ans[start] = '-';
			return;
		}
		int temp = len/3;
		makeString(start, start + temp -1 , temp);
		makeString(end-temp+1, end , temp);
	}

}
