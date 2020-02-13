package com.github.intrigus.security;

/**
 * See https://rosettacode.org/wiki/Binary_search
 *
 */
public class BrokenBinarySearches {

	// initially called with low = 0, high = N-1
	public static int binarySearchRecursive(int[] A, int value, int low, int high) {
		// invariants: value > A[i] for all i < low
		// value < A[i] for all i > high
		if (high < low)
			return -1; // value would be inserted at index "low"
		int mid = (low + high) / 2;
		if (A[mid] > value)
			return binarySearchRecursive(A, value, low, mid - 1);
		else if (A[mid] < value)
			return binarySearchRecursive(A, value, mid + 1, high);
		else
			return mid;
	}

	public static int binarySearchIterative(int[] A, int value) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			// invariants: value > A[i] for all i < low
			// value < A[i] for all i > high
			int mid = (low + high) / 2;
			if (A[mid] > value)
				high = mid - 1;
			else if (A[mid] < value)
				low = mid + 1;
			else
				return mid;
		}
		return -1; // value would be inserted at index "low"
	}

	// initially called with low = 0, high = N - 1
	public static int binarySearchLeftRecursive(int[] A, int value, int low, int high) {
		// invariants: value > A[i] for all i < low
		// value <= A[i] for all i > high
		if (high < low)
			return low;
		int mid = (low + high) / 2;
		if (A[mid] >= value)
			return binarySearchLeftRecursive(A, value, low, mid - 1);
		else
			return binarySearchLeftRecursive(A, value, mid + 1, high);
	}

	public static int binarySearchLeftIterative(int[] A, int value) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			// invariants: value > A[i] for all i < low
			// value <= A[i] for all i > high
			int mid = (low + high) / 2;
			if (A[mid] >= value)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	// initially called with low = 0, high = N - 1
	public static int binarySearchRightRecursive(int[] A, int value, int low, int high) {
		// invariants: value >= A[i] for all i < low
		// value < A[i] for all i > high
		if (high < low)
			return low;
		int mid = (low + high) / 2;
		if (A[mid] > value)
			return binarySearchRightRecursive(A, value, low, mid - 1);
		else
			return binarySearchRightRecursive(A, value, mid + 1, high);
	}

	public static int binarySearchRightIterative(int[] A, int value) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			// invariants: value >= A[i] for all i < low
			// value < A[i] for all i > high
			int mid = (low + high) / 2;
			if (A[mid] > value)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

}
