package com.cp.prework.jump.level;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.HashSet;
	import java.util.List;

public class Solution {
		/**
		 * Checkpoint Level 1: 
		 * O(n)
		 */
		
		/**
		 * Checkpoint Level 2: Pretty Print
		 * Follows the same pattern as spiral matrix. Print it in 2D matrix, go right, up, left, down.
		 * Add each row in 2D array to ArrayList<> then return. 
		 * @param a
		 * @return
		 */
		public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<>();
			Integer[][] matrix = new Integer[a*2-1][a*2-1];
			
		    int startX = 0;
		    int startY = 0;
		    int maxX = matrix[0].length-1;
		    int maxY = matrix.length-1;
		    int value = a;
		    while(startX<=maxX && startY<=maxY && value > 0) {
		    	for(int i=startX; i<=maxX; i++) {
		    		matrix[startY][i] = value;
		    	}
		    	startY++;
		    	for(int i=startY; i<=maxY; i++) {
		    		matrix[i][maxX] = value;
		    	}
		    	maxX--;
	    	    if(startY<=maxY) {
	    	    	for(int i=maxX; i>=startX; i--) {
	    	    		matrix[maxY][i] = value;
	    	    	}           
		    	}
		    	maxY--;
		    	if(startX<=maxX) {
			    	for(int i=maxY; i >= startY; i--) {
			    		matrix[i][startX] = value;
			    	}
		    	}
		    	startX++;
		    	value--;
		    }
			
		    for(int i=0; i<matrix.length; i++) {
		    	results.add(new ArrayList<Integer>( Arrays.asList(matrix[i])));
		    }
			return results;
		}
		
		/**
		 * Checkpoint Level 3: Kth Smallest Element in Array
		 * pretty straightforward: SORT, then return the kth value.
		 * @param a
		 * @param k
		 * @return
		 */
		public int kthsmallest(final List<Integer> a, int k) {
			if(a== null || a.size() < 1 || k > a.size()) {
				return 0;
			}
			Collections.sort(a);
			return a.get(k-1);
		}
		
		/**
		 * Checkpoint Level 4: Next Greater
		 * The idea is two loops, start at i and j=i, loop j to the right till we find the larger element
		 * save larger element in arraylist, and then return the list
		 * @param a
		 * @return
		 */
		  public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
				if(a == null || a.size() < 1) {
					return a;
				}
				ArrayList<Integer> results = new ArrayList<>();
				for(int i=0; i<a.size(); i++) {
					int max = -1;
					for(int j=i; j<a.size(); j++) {
						 if(a.get(j) > a.get(i)) {
							 max = a.get(j);
							 break;
						 }
					}
					results.add(max);
				}
				return results;
			}
		  
		  /**
		   * Checkpoint Level 5 - longest consecutive sequence.
		   * This problem can be solved via DP or using a Hashset
		   * The idea is to find the initial start point of the sequence, and increment the sequence to find the values
		   * We then save the count. 
		   * @param a
		   * @return
		   */
			public int longestConsecutive(final List<Integer> a) {
				if(a == null || a.size() == 0) {
					return 0;
				} else if (a.size() < 2) {
					return 1;
				}
				int totalMaxCount = 0;
				HashSet<Integer> aSet = new HashSet<>();
				for(int val : a) {
					aSet.add(val);
				}
				for(int val : a ) {
					if(!aSet.contains(val-1)) {
						int currentMaxCount = 0;
						while(aSet.contains(val)){
							currentMaxCount++;
							val++;
						}
						totalMaxCount = Math.max(currentMaxCount, totalMaxCount);
					}
				}
				return totalMaxCount;
			}

}
