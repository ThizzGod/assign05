package assign05;

import java.util.ArrayList;
import java.util.Comparator;
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
		if (((right - left + 1)/2) <= threshold) {
			insertionSort(list, left, right);
			return;
		}
		
		int mid = left + (right - left)/2;
		mergesortRecursive(list, threshold, left, mid, tempList);
		mergesortRecursive(list, threshold, mid + 1, right, tempList);
		mergeStep(list, left, mid, right, tempList);
		
	}
	
	private static <T extends Comparable<? super T>> void mergeStep(List<T> list, int left, int mid, int right, List<T> tempList) {
		int tempSize = 0;
		int l = left;
		int r = mid + 1;
		
		while (r <= right && l <= mid) {
			if (list.get(r).compareTo(list.get(l)) < 0) {
				tempList.set(tempSize, list.get(r));
				tempSize++;
				r++;
			} else {
				tempList.set(tempSize, list.get(l));
				tempSize++;
				l++;
			}
		}
		
		if (r > right) {
			for (int i = l; i <= mid; i++) {
				tempList.set(tempSize, list.get(i));
				tempSize++;
			}
		}
		if (l > mid) {
			for (int i = r; i <= right; i++) {
				tempList.set(tempSize, list.get(i));
				tempSize++;
			}
		}
		
		for (int i = 0; i < tempSize; i++) {
			list.set(i + left, tempList.get(i));
		}
	}
	
	public static <T extends Comparable<? super T>> void quicksort(List<T> list, PivotChooser<T> chooser) {}
	
	public static List<Integer> generateAscending(int size){
		return null;}
	
	public static List<Integer> generatePermuted(int size){
		return null;}
	
	public static List<Integer> generateDescending(int size){
		return null;}
}
