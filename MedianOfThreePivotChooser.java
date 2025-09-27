package assign05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MedianOfThreePivotChooser<E extends Comparable<? super E>> implements PivotChooser<E>{

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
