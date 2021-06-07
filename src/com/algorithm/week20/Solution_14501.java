package com.algorithm.week20;

import java.io.*;
import java.util.*;
/*
 * 퇴사 
 * */
public class Solution_14501 {
	static int N, ans;
	static ArrayList<consulting> consultings;
	static class consulting {
		int time;
		int price;
		public consulting(int time, int price) {
			this.time = time;
			this.price = price;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());      
		consultings = new ArrayList<consulting>();
		
		for(int n = 0 ; n < N ; n++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			consultings.add(new consulting(time, price));
		}
		
		chooseDay(0,0);
		
		System.out.println(ans);
	}
	
	
	private static void chooseDay(int start, int sum) {
		if(start >= N) {
			ans = Math.max(sum, ans);
			return;
		}
		for(int i = start ; i < N ; i++) {
			if(i + consultings.get(i).time>N)
				chooseDay(i + consultings.get(i).time,sum);
			else
				chooseDay(i + consultings.get(i).time, sum + consultings.get(i).price);
		}
	}

}
