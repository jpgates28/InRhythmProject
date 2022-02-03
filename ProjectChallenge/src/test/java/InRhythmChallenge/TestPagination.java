package InRhythmChallenge;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPagination {

	@BeforeTest
	public static PaginationHelper createPaginationObj() {
		ArrayList<Character> items = new ArrayList<>();
		items.add('a');
		items.add('b');
		items.add('c');
		items.add('d');
		items.add('e');
		items.add('f');
		PaginationHelper helper = new PaginationHelper(items, 4);
		return helper;
	}

	@Test
	public static void test_correctPageCount() {

		int pageCount = createPaginationObj().pageCount();
		Assert.assertEquals(pageCount, 2);
	}

	@Test
	public static void test_correctItemCount() {
		int itemCount = createPaginationObj().itemCount();
		Assert.assertEquals(itemCount, 6);
	}

	@Test
	public static void test_zerothPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(0);
		Assert.assertEquals(itemCount, 4);
	}

	@Test
	public static void test_1stPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(1);
		Assert.assertEquals(itemCount, 2);
	}

	@Test
	public static void test_2ndPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(2);
		Assert.assertEquals(itemCount, -1);
	}

	@Test
	public static void test_negPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(-2);
		Assert.assertEquals(itemCount, -1);
	}

	@Test
	public static void test_5thItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(5);
		Assert.assertEquals(pageIndex, 1);
	}

	@Test
	public static void test_2ndItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(2);
		Assert.assertEquals(pageIndex, 0);
	}

	@Test
	public static void test_20thItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(20);
		Assert.assertEquals(pageIndex, -1);
	}

	@Test
	public static void test_negItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(-10);
		Assert.assertEquals(pageIndex, -1);
	}

	@Test
	public static void test_ZerothItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(0);
		Assert.assertEquals(pageIndex, 0);
	}

	@AfterTest
	public static void allvalidations() {

		System.out.println("All the test cases executed successfully");
	}

}
