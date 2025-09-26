package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DOMStringList;

class ListSorterTester {
	ArrayList<Integer> intList;
	ArrayList<String> wordList;
	ArrayList<Integer> intListOrdered;
	ArrayList<String> wordListOrdered; 
	ArrayList<Integer> ascendingInts;
	ArrayList<Integer> descendingInts; 

	@BeforeEach
	void setUp() {
		intList = new ArrayList<Integer>();
		intListOrdered = new ArrayList<Integer>();
		wordList = new ArrayList<String>();
		wordListOrdered = new ArrayList<String>();
		ascendingInts = new ArrayList<Integer>();
		descendingInts = new ArrayList<Integer>();

		//add integers to intList
		intList.add(3);
		intList.add(-20);
		intList.add(40);
		intList.add(12);
		intList.add(2);
		intList.add(100);
		intList.add(200);
		intList.add(-5);
		
		//add integers to intListOrdered
		intListOrdered.add(-20);
		intListOrdered.add(-5);
		intListOrdered.add(2);
		intListOrdered.add(3);
		intListOrdered.add(12);
		intListOrdered.add(40);
		intListOrdered.add(100);
		intListOrdered.add(200);
		
		//add strings to stringList
		wordList.add("Mac");
		wordList.add("Charlie");
		wordList.add("Dennis");
		wordList.add("Dee");
		wordList.add("Frank");
		
		//add strings to wordListOrdered
		wordListOrdered.add("Charlie");
		wordListOrdered.add("Dee");
		wordListOrdered.add("Dennis");
		wordListOrdered.add("Frank");
		wordListOrdered.add("Mac");
		
		//add ascendingInts
		for (int i = 1; i <= 50; i++) {
			ascendingInts.add(i);
		}
		//add descendingInts
		for (int i = 50; i <= 1; i--) {
			descendingInts.add(i);
		}
	}
	
	@Test
	void testMergeSortThrowsIllegalArgument() {
		assertThrows(IllegalArgumentException.class, () -> ListSorter.mergesort(intList, -5));
		assertThrows(IllegalArgumentException.class, () -> ListSorter.mergesort(wordList, 0));
	}
	
	@Test
	void testMergeSortWithStrings() {
		ListSorter.mergesort(wordList, 1);
		assertEquals(wordListOrdered, wordList);
	}
	
	@Test
	void testMergeSortWithIntegers() {
		ListSorter.mergesort(intList, 3);
		assertEquals(intListOrdered, intList);
	}
	
	@Test
	void testQuickSortWithStringsFirstPivot() {
		ListSorter.quicksort(wordList, new FirstPivotChooser<String>());
		assertEquals(wordListOrdered, wordList);
	}
	
	@Test
	void testQuickSortWithStringsMedianPivot() {
		ListSorter.quicksort(wordList, new MedianOfThreePivotChooser<String>());
		assertEquals(wordListOrdered, wordList);
	}

	@Test
	void testQuickSortWithStringsRandomPivot() {
		ListSorter.quicksort(wordList, new RandomPivotChooser<String>());
		assertEquals(wordListOrdered, wordList);
	}
	
	@Test
	void testQuickSortWithIntegersFirstPivot() {
		ListSorter.quicksort(intList, new FirstPivotChooser<Integer>());
		assertEquals(intListOrdered, intList);
	}

	@Test
	void testQuickSortWithIntegersMedianPivot() {
		ListSorter.quicksort(intList, new MedianOfThreePivotChooser<Integer>());
		assertEquals(intListOrdered, intList);
	}

	@Test
	void testQuickSortWithIntegersRandomPivot() {
		ListSorter.quicksort(intList, new RandomPivotChooser<Integer>());
		assertEquals(intListOrdered, intList);
	}
	
	@Test
	void testGenerateAscending() {
		assertEquals(ascendingInts, ListSorter.generateAscending(50));
	}

	@Test
	void testGenerateAscendingThrowsIllegalArgument() {
		assertThrows(IllegalArgumentException.class, () -> ListSorter.generateAscending(-5));
	}

	@Test
	void testGeneratePermuted() {
		assertNotEquals(ascendingInts, ListSorter.generateAscending(50));
	}
	
	@Test
	void testGeneratePermutedThrowsIllegalArgument() {
		assertThrows(IllegalArgumentException.class, () -> ListSorter.generatePermuted(-5));
	}

	@Test
	void testGenerateDescending() {
		assertEquals(descendingInts, ListSorter.generateDescending(50));
	}
	
	@Test
	void testGenerateDescendingThrowsIllegalArgument() {
		assertThrows(IllegalArgumentException.class, () -> ListSorter.generateDescending(-5));
	}
 }
