package com.algorithm.week21.common;

import java.util.*;

public class Solution_입국심사 {
	
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7,10};
		System.out.print(solution(n,times));	
	}
	
	public static long solution(int n, int[] times) {
	        long answer = 0;
	        Arrays.sort(times);
	        int size = times.length;
	        long start = 1;               // 1초 부터 
	        long end = (long)times[size-1] * n; // 최대 시간 까지 : 가장 오래걸리는 시간 * n 
	        long mid = 0, ans = end;
	        while(start <= end) {
	        	 long sum = 0;
	        	 mid = (start + end)/2;
//	        	 if(start > end) break;
	        	 for(int i = 0 ; i < size; i++) {
	        		 sum += mid/times[i];
	        	 }
	        	 if(sum >= n) {  // 범위 내에서 가능한 경우
	        		 if(ans>=mid) ans = mid;
	        		 end = mid - 1;  
	        	 }
	        	 if(sum < n) {  // 범위 내에서 불가능한 경우 
	        		 start = mid + 1;
	        	 }
	        }
	        return ans;
	}

}
