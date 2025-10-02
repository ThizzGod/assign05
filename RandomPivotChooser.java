package assign05;

import java.util.List;
import java.util.Random;

/**
 * PivotChooser class which selects a single random list element to be the pivot item for mergesort
 * @param <E> - a generic type, must be comparable
 * 
 * @author Max Barker and Josi Gac
 * @version 10/1/25
 */
public class RandomPivotChooser<E extends Comparable<? super E>> implements PivotChooser<E>{

	/**
	 * Selects a random elements in a mergesort partition
	 * @param list - a list object containing a generic type, E must be comparable
	 * @param leftIndex - the first index of the mergesort partition
	 * @param rightIndex - the last index of the mergesort partition
	 * @return - a random elements in the partition
	 */
	@Override
	public int getPivotIndex(List<E> list, int leftIndex, int rightIndex) {
		Random rng = new Random();
		int index = rng.nextInt(leftIndex, rightIndex + 1);
		return index;
	}

}
