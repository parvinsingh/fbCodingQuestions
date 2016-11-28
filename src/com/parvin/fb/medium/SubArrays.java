package com.parvin.fb.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find all sub arrays with a given sum.
 * 1) First find all the sub arrays for a given array
 * 2) Find sub arrays with a given sum
 */
public class SubArrays {

	public static void main(String args[]){
		testCase1();
	}
	
	private static void testCase1(){
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,3));
		ArrayList<ArrayList<Integer>> result = getSubSets(input, 0);
		System.out.print("{ ");
		for(ArrayList<Integer> subset: result){
			System.out.print("{");
				for(int i: subset){
					System.out.print(i);
					System.out.print(",");
				}
			System.out.print("}");
			System.out.print(",");
		}
		System.out.print(" }");
		System.out.println();
	}
	
	private static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> input, int index){
		ArrayList<ArrayList<Integer>> resultSet = new ArrayList<ArrayList<Integer>>();
		if(input.size() == index){
			resultSet = new ArrayList<ArrayList<Integer>>();
			resultSet.add(new ArrayList<Integer>());
		}else{
			getSubSets(input, index+1);
			int item = input.get(index);
			ArrayList<ArrayList<Integer>> tempSet =
					new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset: resultSet){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(subset);
				temp.add(item);
				tempSet.add(temp);
			}
			resultSet.addAll(tempSet);
		}
		return resultSet;
	}
	
}
