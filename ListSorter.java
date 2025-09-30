package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class contains the code for the sorting algorithms merge sort and quicksort
 * 
 * @author Max Barker and Josi Gac
 * @version 9/30/25
 */
public class ListSorter {

	/**
	 * Makes sure the threshold is an acceptable number, creates a temporary list for merge storage and calls
	 * the merge sort recursive step
	 * 
	 * @param <T> the type of elements in the list
	 * @param list the list to be sorted
	 * @param threshold size of the subarray
	 */
	public static <T extends Comparable<? super T>> void mergesort(List<T> list, int threshold) {
		if (threshold <= 0) {
			throw new IllegalArgumentException();
		}
		List<T> tempList = new ArrayList<>(list.size());
		for (int i = 0; i < list.size(); i++) {
			tempList.add(null);
		}
		mergesortRecursive(list, threshold, 0, list.size() - 1, tempList);
		
	}
	
	/**
	 * Sorts the list given using insertion sort and the given comparator
	 * 
	 * @param <T> type of elements in the list
	 * @param arr the list to be sorted
	 * @param left the first element of the list
	 * @param right the last element of the list
	 */
	public static <T extends Comparable<? super T>> void insertionSort(List<T> arr, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
	        T item = arr.get(i);
	        int j = i - 1;

	        while (j >= left && arr.get(j).compareTo(item) > 0) {
	            arr.set(j + 1, arr.get(j)); 
	            j--;
	        }
	        
	        arr.set(j + 1, item);
	    }
	}
	
	/**
	 * Calls the merge sort recursively and split the list into two halves, the base case will call insertion sort on the small sublist
	 * 
	 * @param <T> type of elements in the list
	 * @param list the list to be sorted
	 * @param threshold the size of the sublist
	 * @param left the first element of the list
	 * @param right the last element of the list
	 * @param tempList a temporary list for merge space
	 */
	private static <T extends Comparable<? super T>> void mergesortRecursive(List<T> list, int threshold, int left, int right, List<T> tempList) {
		if ((right - left + 1) <= threshold) {
			insertionSort(list, left, right);
			return;
		}
		
		int mid = left + (right - left)/2;
		mergesortRecursive(list, threshold, left, mid, tempList);
		mergesortRecursive(list, threshold, mid + 1, right, tempList);
		mergeStep(list, left, mid, right, tempList);
		
	}
	
	/**
	 * This method deals with only the merge step of merge sort, it works by comparing the elements of each sublist
	 * and then copying the smaller element into the temporary list then moving the pointer. After it is done it copies
	 * everything back over to the original list
	 * 
	 * @param <T> type of elements in the list
	 * @param list the list to be sorted
	 * @param left the first element of the list
	 * @param mid the middle element of the list
	 * @param right the last element of the list
	 * @param tempList a temporary list for merge space
	 */
	private static <T extends Comparable<? super T>> void mergeStep(List<T> list, int left, int mid, int right, List<T> tempList) {	
        int i = left;
        int j = mid + 1;
        int current = left;

        while (i <= mid && j <= right) {
            if (list.get(i).compareTo(list.get(j)) <= 0) {
                tempList.set(current++, list.get(i++));
            } else {
                tempList.set(current++, list.get(j++));
            }
        }
        while (i <= mid) {
            tempList.set(current++, list.get(i++));
        }
        while (j <= right) {
            tempList.set(current++, list.get(j++));
        }
        for (int index = left; index <= right; index++) {
        	list.set(index, tempList.get(index));
        }
	}
	
	/**
	 * Calls the quicksort recursive step
	 * 
	 * @param <T> type of elements in the list
	 * @param list the list to be sorted
	 * @param chooser the pivot to be chosen
	 */
	public static <T extends Comparable<? super T>> void quicksort(List<T> list, PivotChooser<T> chooser) {
		quicksortRecursive(list, chooser, 0, list.size() - 1);
	}
	
	/**
	 * Recursively quicksorts the inputed list, the base case partitions the list
	 * 
	 * @param <T> type of elements in the list
	 * @param list the list to be sorted
	 * @param chooser the pivot to be chosen
	 * @param left the first element in the list
	 * @param right the last element in the list
	 */
	private static <T extends Comparable<? super T>> void quicksortRecursive(List<T> list, PivotChooser<T> chooser, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(list, chooser, left, right);
			
			quicksortRecursive(list, chooser, left, pivotIndex-1);
			quicksortRecursive(list, chooser, pivotIndex+1, right);
		}

	}
	
	/**
	 * The method deals with only rearranging the list around the chosen pivot based on the elements value,
	 * if the element is less than the pivot it will go to left of the pivot, if it's greater than it goes to the right
	 * 
	 * @param <T> type of elements in the list
	 * @param list the list to be sorted
	 * @param chooser the pivot to be chosen
	 * @param left the first element in the list
	 * @param right the last element in the list
	 * @return the index of the pivot element
	 */
	private static  <T extends Comparable<? super T>> int partition(List<T> list, PivotChooser<T> chooser, int left, int right) {
		int pivotIndex = chooser.getPivotIndex(list, left, right);
		swap(list, pivotIndex, right);
		int i = left;
		int k = right;
		
		while (i < k) {
			if (list.get(i).compareTo(list.get(right)) <= 0) {
				i++;
			} else {
				k--;
				swap(list, k, i);
			}
		}
		swap(list, i, right);
		return i;
	}
	
	/**
	 * Swaps two elements in the list
	 * 
	 * @param <T> type of elements in the list
	 * @param list the list to be sorted
	 * @param index1 the current index
	 * @param index2 the index to swap with
	 */
	private static <T extends Comparable<? super T>> void swap(List<T> list, int index1, int index2) {
		T temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
	
	public static List<Integer> generateAscending(int size){
		if (size < 1) throw new IllegalArgumentException();
		
		ArrayList<Integer> ascending = new ArrayList<>();
		for (int i = 1; i <= size; i++) {
			ascending.add(i);
		}
		return ascending;
	}
	
	public static List<Integer> generatePermuted(int size){
		if (size < 1) throw new IllegalArgumentException();
		
		ArrayList<Integer> permuted = new ArrayList<>();
		for (int i = 1; i <= size; i++) {
			permuted.add(i);
		}
		Collections.shuffle(permuted);
		return permuted;
	}
	
	public static List<Integer> generateDescending(int size){
		if (size < 1) throw new IllegalArgumentException();
		
		ArrayList<Integer> descending = new ArrayList<>();
		for (int i = size; i >= 1; i--) {
			descending.add(i);
		}
		return descending;
	}
}
