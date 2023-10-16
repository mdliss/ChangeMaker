
///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           ChangemakerTester Program
// Course:          CS 300, Summer, 2023
//
// Author:          Max Liss-'s-Gravemade
// Email:           lisssgravema@wisc.edu
// Lecturer's Name: Michelle Jensen
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// https://canvas.wisc.edu/courses/355989/assignments/1923294
// 
//
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.util.Arrays;

/**
 * This class contains various test methods to test the functionality of the
 * Changemaker class. It tests the count(), minCoins(), and makeChange() methods
 * with different inputs to ensure the correctness of their implementations.
 * 
 * Each test method is responsible for checking a specific scenario and
 * returning a boolean indicating whether the test passed or failed.
 * 
 * @author Max Liss-'s-Gravemade
 *
 */
public class ChangemakerTester {

	// passed
	public static boolean testCountBase() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 3, 0, 0, 3 };
		int value = 27;
		int expectedCount = 3;
		int count = Changemaker.count(denominations, coinsRemaining, value);
		return count == expectedCount;
	}

	// passed
	public static boolean testCountRecursive() {
		int[] denominations = { 1, 2, 5 };
		int[] coinsRemaining = { 3, 2, 1 };
		int value = 5;
		int expectedCount = 8;
		int count = Changemaker.count(denominations, coinsRemaining, value);
		return count == expectedCount;
	}

	// passed
	public static boolean testMinCoinsBase() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 3, 0, 0, 3 };
		int value = 27;
		int expectedMinCoins = 3;
		int minCoins = Changemaker.minCoins(denominations, coinsRemaining, value);
		return minCoins == expectedMinCoins;
	}

	// passed
	public static boolean testMinCoinsBase2() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 5, 1, 3, 1 };
		int value = 59;
		int expectedMinCoins = 8;
		int minCoins = Changemaker.minCoins(denominations, coinsRemaining, value);
		return minCoins == expectedMinCoins;
	}

	// passed
	public static boolean testMinCoinsBase3() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 59, 12, 6, 3 };
		int value = 59;
		int expectedMinCoins = 7;
		int minCoins = Changemaker.minCoins(denominations, coinsRemaining, value);
		return minCoins == expectedMinCoins;
	}

	// passed
	public static boolean testMinCoinsBase4() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 3, 6, 3, 2 };
		int value = 29;
		int expectedMinCoins = -1;
		int minCoins = Changemaker.minCoins(denominations, coinsRemaining, value);
		return minCoins == expectedMinCoins;
	}

	// passed
	public static boolean testMinCoinsBase5() {
		int[] denominations = { 1, 5, 6, 9 };
		int[] coinsRemaining = { 11, 3, 2, 2 };
		int value = 11;
		int expectedMinCoins = 2;
		int minCoins = Changemaker.minCoins(denominations, coinsRemaining, value);
		return minCoins == expectedMinCoins;
	}

	// Fails with greedy method
	public static boolean testMinCoinsRecursive() {
		int[] denominations = { 1, 5, 8 };
		int[] coinsRemaining = { 2, 1, 1 };
		int value = 9;
		int expectedMinCoins = 2;
		int minCoins = Changemaker.minCoins(denominations, coinsRemaining, value);
		return minCoins == expectedMinCoins; // Will return false
	}

	// passed
	public static boolean testMakeChangeBase() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 3, 0, 0, 3 };
		int value = 27;
		int[] expectedChange = { 2, 0, 0, 1 };
		int[] change = Changemaker.makeChange(denominations, coinsRemaining, value);
		return Arrays.equals(change, expectedChange);
	}

	// Fails with greedy method
	public static boolean testMakeChangeGreedy1() {
		int[] denominations = { 1, 3, 4, 5 };
		int[] coinsRemaining = { 5, 5, 5, 5 };
		int value = 7;
		int[] expectedChange = { 0, 1, 1, 0 };
		int[] change = Changemaker.makeChange(denominations, coinsRemaining, value);
		return Arrays.equals(change, expectedChange); // Will return false
	}

	// Fails for greedy method
	public static boolean testMakeChangeRecursive() {
		int[] denominations = { 1, 10, 25 };
		int[] coinsRemaining = { 5, 3, 1 };
		int value = 30;
		int[] expectedChange = { 0, 3, 0 };
		int[] change = Changemaker.makeChange(denominations, coinsRemaining, value);
		return Arrays.equals(change, expectedChange); // Will return false
	}

	// passed
	public static boolean testMakeChangeRecursive1() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 4, 0, 2, 0 };
		int value = 25;
		int[] expectedChange = null;
		int[] change = Changemaker.makeChange(denominations, coinsRemaining, value);
		return Arrays.equals(change, expectedChange);
	}

	// passed
	public static boolean testMakeChangeRecursive2() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 4, 3, 0, 0 };
		int value = 13;
		int[] expectedChange = { 3, 2, 0, 0 };
		int[] change = Changemaker.makeChange(denominations, coinsRemaining, value);
		return Arrays.equals(change, expectedChange);
	}

	// passed
	public static boolean testMakeChangeRecursive3() {
		int[] denominations = { 1, 5, 10, 25 };
		int[] coinsRemaining = { 5, 5, 5, 5 };
		int value = 5;
		int[] expectedChange = { 0, 1, 0, 0 };
		int[] change = Changemaker.makeChange(denominations, coinsRemaining, value);
		return Arrays.equals(change, expectedChange);
	}

	public static void main(String[] args) {
		System.out.println("Running tests...");

		boolean allTestsPassed = true;

		if (!testCountBase()) {
			System.out.println("testCountBase failed");
			allTestsPassed = false;
		}

		if (!testCountRecursive()) {
			System.out.println("testCountRecursive failed");
			allTestsPassed = false;
		}

		if (!testMinCoinsBase()) {
			System.out.println("testMinCoinsBase failed");
			allTestsPassed = false;
		}

		if (!testMinCoinsBase2()) {
			System.out.println("testMinCoinsBase2 failed");
			allTestsPassed = false;
		}

		if (!testMinCoinsBase3()) {
			System.out.println("testMinCoinsBase3 failed");
			allTestsPassed = false;
		}

		if (!testMinCoinsBase4()) {
			System.out.println("testMinCoinsBase4 failed");
			allTestsPassed = false;
		}

		if (!testMinCoinsBase5()) {
			System.out.println("testMinCoinsBase5 failed");
			allTestsPassed = false;
		}

		if (!testMinCoinsRecursive()) {
			System.out.println("testMinCoinsRecursive failed");
			allTestsPassed = false;
		}

		if (!testMakeChangeBase()) {
			System.out.println("testMakeChangeBase failed");
			allTestsPassed = false;
		}

		if (!testMakeChangeGreedy1()) {
			System.out.println("testMakeChangeGreedy1 failed");
			allTestsPassed = false;
		}

		if (!testMakeChangeRecursive()) {
			System.out.println("testMakeChangeRecursive failed");
			allTestsPassed = false;
		}

		if (!testMakeChangeRecursive1()) {
			System.out.println("testMakeChangeRecursive1 failed");
			allTestsPassed = false;
		}

		if (!testMakeChangeRecursive2()) {
			System.out.println("testMakeChangeRecursive2 failed");
			allTestsPassed = false;
		}

		if (!testMakeChangeRecursive3()) {
			System.out.println("testMakeChangeRecursive3 failed");
			allTestsPassed = false;
		}

		if (allTestsPassed) {
			System.out.println("All tests passed");
		}
	}
}
