package assign05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * PivotChooser class which selects three random list elements and chooses the median element 
 * to be the pivot item for mergesort
 * @param <E> - a generic type, must be comparable
 * 
 * @author Max Barker and Josi Gac
 * @version 10/1/25
 */
public class MedianOfThreePivotChooser<E extends Comparable<? super E>> implements PivotChooser<E>{

	/**
	 * Selects the median of three random elements in a mergesort partition
	 * @param list - a list object containing a generic type, E must be comparable
	 * @param leftIndex - the first index of the mergesort partition
	 * @param rightIndex - the last index of the mergesort partition
	 * @return - the median of three random elements in the partition
	 */
	@Override
	public int getPivotIndex(List<E> list, int leftIndex, int rightIndex) {
		Random rng = new Random();
		ArrayList<Integer> randomIndices = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			randomIndices.add(rng.nextInt(leftIndex, rightIndex + 1));
		}
		randomIndices.sort((int1, int2) -> int1.compareTo(int2));
		return randomIndices.get(1);
	}

}
