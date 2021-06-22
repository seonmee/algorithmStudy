package com.algorithm.week22;
import java.util.*;
/*
 * 단어 정렬 
 * */
public class Solution_1181 {
	static int N;
	static List<String> words;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		words = new ArrayList<>();
		
		N = sc.nextInt();
		for(int i =0; i < N ; i++) {
			String word = sc.next();
            // 중복 제거 
			if(!words.contains(word))words.add(word);
		}
        // 정렬 
		Collections.sort(words, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				int dif = Integer.compare(s1.length(),s2.length());    // 1) 길이 
				return dif == 0 ? s1.compareTo(s2) : dif ;             // 2) 사전순 
			}
			
		});
		for(String w : words) {
			System.out.println(w);
		}
	}

}