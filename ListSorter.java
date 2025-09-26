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
		int current = 1;
		int previous = 0;
		
		for (int i = left; i <= right; i++ ) {
			while ((previous >= 0) && (arr.get(current+i).compareTo(arr.get(previous+i)) < 0)) {
				T placeholder = arr.get(current + i);
				arr.set(current + i, arr.get(previous + i));
				arr.set(previous + i, placeholder);
				current--;
				previous--;
			}
			current = i;
			previous = i - 1;
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
		for(int i = left; i <= mid; i+=2) {
			if (list.get(mid+1+i).compareTo(list.get(i)) < 0) {
				tempList.set(i, list.get(mid+i));
				tempList.set(i+1, list.get(i));
			} else {
				tempList.set(i, list.get(i));
				tempList.set(i+1, list.get(mid+1+i));
			}
		}
		if ((right - mid) > (mid - left)) {
			for (int j = right; j > (right - mid) - (mid - left); j--) {
				tempList.set(j, list.get(j));
			}
		}
		
		if ((right - mid) < (mid - left)) {
			for (int j = right; j > (mid - left) - (right - mid); j--) {
				tempList.set(j, list.get(j - mid));
			}
		}
		
		for (int i = left; i <= right; i ++) {
			list.set(i, tempList.get(i));
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
