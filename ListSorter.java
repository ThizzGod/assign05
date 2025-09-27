package assign05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSorter {

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
	 * Sorts the array given using insertion sort and the given comparator
	 * @param <T> type of elements in the array
	 * @param arr the array to be sorted
	 * @param cmp the comparator used to compare elements
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
	
	public static <T extends Comparable<? super T>> void quicksort(List<T> list, PivotChooser<T> chooser) {
		quicksortRecursive(list, chooser, 0, list.size() - 1);
	}
	
	private static <T extends Comparable<? super T>> void quicksortRecursive(List<T> list, PivotChooser<T> chooser, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(list, chooser, left, right);
			
			quicksortRecursive(list, chooser, left, pivotIndex-1);
			quicksortRecursive(list, chooser, pivotIndex+1, right);
		}

		
	}
	
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
