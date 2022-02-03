package InRhythmChallenge;

import java.util.List;

import org.testng.annotations.Test;

public class PaginationHelper {

	private int totalCount = 0;
	private int itemsPerPage = 0;

	/**
	 * The constructor takes in an array of items and a integer indicating how many
	 * items fit within a single page
	 */

	public PaginationHelper(List<Character> items, int itemsPerPage) {

		this.totalCount = items.size();
		this.itemsPerPage = itemsPerPage;
			
	}

	/**
	 * returns the number of items within the entire collection
	 */
	public int itemCount() {
		return totalCount;
	}

	/**
	 * returns the number of pages
	 */
	public int pageCount() {
		return (totalCount - 1) / itemsPerPage + 1;
	}

	/**
	 * returns the number of items on the current page. page_index is zero based.
	 * this method should return -1 for pageIndex values that are out of range
	 */
	public int pageItemCount(int pageIndex) {
		int c = pageCount();
		if (pageIndex < 0 || pageIndex >= c)
			return -1;
		if (pageIndex == c - 1)
			return totalCount % itemsPerPage;
		else
			return itemsPerPage;
	}

	/**
	 * determines what page an item is on. Zero based indexes this method should
	 * return -1 for itemIndex values that are out of range
	 */
	public int pageIndex(int itemIndex) {
		if (itemIndex < 0 || itemIndex >= totalCount)
			return -1;
		return (itemIndex - 1) / itemsPerPage;
	}

}
