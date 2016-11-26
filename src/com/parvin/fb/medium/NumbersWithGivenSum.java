package com.parvin.fb.medium;
/*
 * Given an array, please determine whether 
 * it contains three numbers whose sum equals to 0.
 * 1) Sorted Input array
 * 2) Unsorted array
 */
public class NumbersWithGivenSum {

	public static void main(String args[]){
		testSortedArray();
		testUnsortedArray();
		testSortedArrayWithDuplicates1();
		testSortedArrayWithDuplicates2();
	}
	
	
	
	private static void testSortedArrayWithDuplicates1() {
		int duplicateArr[] = {0,2,3,3,6,11,14};
		System.out.println("input was an array with duplicates: " + hasSum(duplicateArr, 12));
	}

	private static void testSortedArrayWithDuplicates2() {
		int duplicateArr[] = {-5,0,2,3,3,6,11,14};
		System.out.println("input was an array with duplicates: " + hasSum(duplicateArr, 15));
	}

	private static void testUnsortedArray() {
		// TODO Auto-generated method stub
		
	}



	private static void testSortedArray() {
		int sortedArr[] = {-5,-2,0,2,3,4,11,14};
		System.out.println("input was a sorted array: " + hasSum(sortedArr, 0));
	}



	private static boolean hasSum(int[] input, int sum){
		for(int i=0; i<input.length; i++){
			int tempSum = sum - input[i];
			boolean hasSum = hasSum(input, tempSum, 1, input[i]);
			if(hasSum) return true;
		}
		return false;
	}
	
	private static boolean hasSum(int[] arr, int sum, int startIndex, int firstElem){
		int i=startIndex, end=arr.length-1;
		while(i < end){
			int curSum = arr[i]+arr[end];
			if(curSum == sum) {
				System.out.println("elements with the sum are: " + "{" + firstElem + "," +arr[i] + "," + arr[end] + "}");
				return true;
			}else if(curSum > sum){
				end--;
			}else{
				i++;
			}
		}
		return false;
	}
}
