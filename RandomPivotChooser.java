package assign05;

import java.util.List;
import java.util.Random;

public class RandomPivotChooser<E extends Comparable<? super E>> implements PivotChooser<E>{

	@Override
	public int getPivotIndex(List<E> list, int leftIndex, int rightIndex) {
		Random rng = new Random();
		int index = rng.nextInt(leftIndex, rightIndex + 1);
		return index;
	}

}
