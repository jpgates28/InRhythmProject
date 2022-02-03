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
		PaginationHelper pagehelper = new PaginationHelper(items, 4);
		return pagehelper;
	}

	@Test(priority =1)
	public static void test_PageCount() {

		int pageCount = createPaginationObj().pageCount();
		Assert.assertEquals(pageCount, 2);
		System.out.println("Page Count is verified");
	}

	@Test(priority =2)
	public static void test_ItemCount() {
		int itemCount = createPaginationObj().itemCount();
		Assert.assertEquals(itemCount, 6);
		System.out.println("Item Count is verified");
	}

	@Test(priority =3)
	public static void test_zeroIndxPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(0);
		Assert.assertEquals(itemCount, 4);
		System.out.println("Item Count in Zero Index Page is verified");
	}

	@Test(priority =4)
	public static void test_firstIndxPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(1);
		Assert.assertEquals(itemCount, 2);
		System.out.println("Item Count in First Index Page is verified");
	}

	@Test(priority =5)
	public static void test_secondIndxPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(2);
		Assert.assertEquals(itemCount, -1);
		System.out.println("Item Count in Second Index Page is verified");
	}

	@Test(priority =6)
	public static void test_negindxPageItemCount() {

		int itemCount = createPaginationObj().pageItemCount(-2);
		Assert.assertEquals(itemCount, -1);
		System.out.println("Item Count in incorrect page is verified");
	}

	@Test(priority =7)
	public static void test_5thItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(5);
		Assert.assertEquals(pageIndex, 1);
		System.out.println("Page Index of 5th Item is verified");
	}

	@Test(priority =8)
	public static void test_2ndItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(2);
		Assert.assertEquals(pageIndex, 0);
		System.out.println("Page Index of 2nd Item is verified");
	}

	@Test(priority =9)
	public static void test_20thItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(20);
		Assert.assertEquals(pageIndex, -1);
		System.out.println("Page Index of 20th Item is verified");
	}

	@Test(priority =10)
	public static void test_negItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(-10);
		Assert.assertEquals(pageIndex, -1);
		System.out.println("Page Index of 10th Item is verified");
	}

	@Test(priority =11)
	public static void test_ZerothItemPageIndex() {

		int pageIndex = createPaginationObj().pageIndex(0);
		Assert.assertEquals(pageIndex, 0);
		System.out.println("Page Index of zero index Item is verified");
	}

	@AfterTest
	public static void allvalidations() {

		System.out.println("All the test cases executed successfully");
	}

}
