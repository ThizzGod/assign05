package assign05;

import java.util.List;

/**
 * PivotChooser class which selects the first element in a partition to be the pivot item for mergesort
 * @param <E> - a generic type, must be comparable
 * 
 * @author Max Barker and Josi Gac
 * @version 10/1/25
 */
public class FirstPivotChooser<E extends Comparable<? super E>> implements PivotChooser<E>{

	/**
	 * Selects the first element in a mergesort partition
	 * @param list - a list object containing a generic type, E must be comparable
	 * @param leftIndex - the first index of the mergesort partition
	 * @param rightIndex - the last index of the mergesort partition
	 * @return - the left index passed in
	 */
	@Override
	public int getPivotIndex(List<E> list, int leftIndex, int rightIndex) {
		return leftIndex;
	}

}
