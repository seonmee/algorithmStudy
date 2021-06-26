package com.algorithm.week22.common;
import java.util.*;
import java.io.*;
/*
 * 내일 할거야
 * n개의 과제 10^6
 * 소요시간 d일 10^9
 * 마감시간 t일 10^9
 * */


public class Solution_7983 {

	static class homework implements Comparable<homework>{
		int d;
		int t;
		public homework(int d, int t) {
			this.d = d;
			this.t = t;
		}
		@Override
		public int compareTo(homework h) {
			return Integer.compare(h.t, this.t);
		}
		
	}
	static ArrayList<homework> hwList = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			hwList.add(new homework(d,t));
		}
		
		Collections.sort(hwList);
		
		int time = hwList.get(0).t;
		for(homework hw : hwList) {
			// 마감 시간 조정 
			if(time < hw.t)hw.t = time;
			time = hw.t - hw.d;
		}
		
		System.out.println(time);
	}
}
