package com.algorithm.week15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 프로그래머스_튜플
public class Solution_64065 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"; 
		System.out.println(solution(s)[0]);
	}
	
	static public int[] solution(String s) {
		int[] answer;
		s = s.replace("},{", ",").replace("{{", "").replace("}}", "");
		String[] arr = s.split(",");
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {			
			int key = Integer.parseInt(arr[i]);
			if(!map.containsKey(key)) {				
				map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);
			}
		}
		List<Integer> keySet = new ArrayList<Integer>(map.keySet());
		keySet.sort((o1, o2)-> Integer.compare(map.get(o2),map.get(o1)));
		int idx = 0;
		answer = new int[keySet.size()];
		for (Integer key : keySet) {
			answer[idx++]=key;
		}
		
		return answer;
	}

}
