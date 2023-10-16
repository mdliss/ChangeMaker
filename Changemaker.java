///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Changemaker Program
// Course:          CS 300, Summer, 2023
//
// Author:          Max Liss-'s-Gravemade
// Email:           lisssgravema@wisc.edu
// Lecturer's Name: Michelle Jensen
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// https://canvas.wisc.edu/courses/355989/assignments/1923294
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html#copyOf(int[],int) 
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html#min(int,int)
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Arrays;

/**
 * Provides utility methods to work with coin denominations and target values.
 * It offers solutions to: 
 * Calculate the minimum number of coins required to achieve a given value. 
 * Determine the number of different ways to form a value using specific coin denominations. 
 * Find the optimal combination of coins to make a given value using available coins for each denomination.
 * 
 * @author Max Liss-'s-Gravemade
 */
public class Changemaker {

	/**
	 * Calculates the number of different ways to make a given value using a given
	 * set of coin denominations.
	 * 
	 * @param denominations  an array of coin denominations
	 * @param coinsRemaining an array representing the number of available coins for
	 *                       each denomination
	 * @param value          the target value to be formed
	 * @return the number of different ways to make the target value
	 */
	public static int count(int[] denominations, int[] coinsRemaining, int value) {
		// base case
		if (value == 0) {
			return 1;
		}

		// base case
		if (value < 0 || allCoinsExhausted(coinsRemaining)) {
			return 0;
		}

		// recursive case
		int count = 0;
		Arrays.sort(denominations); // sort denominations in ascending order
		for (int i = denominations.length - 1; i >= 0; i--) {
			if (coinsRemaining[i] > 0 && value >= denominations[i]) {
				int[] updatedCoinsRemaining = Arrays.copyOf(coinsRemaining, coinsRemaining.length);
				updatedCoinsRemaining[i]--;
				count += count(denominations, updatedCoinsRemaining, value - denominations[i]);

				// skip counting duplicate combinations
				while (i > 0 && denominations[i] == denominations[i - 1]) {
					i--;
				}
			}
		}
		return count;
	}

	/**
	 * Calculates the optimal combination of coins to make a given value using a
	 * given set of coin denominations and the available coins of each denomination.
	 * 
	 * @param denominations  an array of coin denominations
	 * @param coinsRemaining an array representing the number of available coins for
	 *                       each denomination
	 * @param value          the target value to be formed
	 * @return an array representing the optimal combination of coins, or null if it
	 *         is impossible to make the value
	 */
	public static int[] makeChange(int[] denominations, int[] coinsRemaining, int value) {
		if (value == 0) {
			return new int[denominations.length];
		}

		int[] optimalCoins = null;

		for (int i = denominations.length - 1; i >= 0; i--) {
			if (coinsRemaining[i] > 0 && value >= denominations[i]) {
				coinsRemaining[i]--;
				int[] subOptimalCoins = makeChange(denominations, coinsRemaining, value - denominations[i]);
				coinsRemaining[i]++;

				if (subOptimalCoins != null) {
					subOptimalCoins[i]++;
					if (optimalCoins == null || sum(subOptimalCoins) < sum(optimalCoins)) {
						optimalCoins = subOptimalCoins;
					}
				}
			}
		}

		return optimalCoins;
	}

	/**
	 * Calculates the minimum number of coins needed to make a given value using a
	 * given set of coin denominations and the available coins of each denomination.
	 * 
	 * @param denominations  an array of coin denominations
	 * @param coinsRemaining an array representing the number of available coins for
	 *                       each denomination
	 * @param value          the target value to be formed
	 * @return the minimum number of coins needed to make the value, or -1 if it is
	 *         impossible to make the value
	 */
	public static int minCoins(int[] denominations, int[] coinsRemaining, int value) {
		if (value == 0) {
			return 0;
		}

		int minCoins = Integer.MAX_VALUE;

		for (int i = 0; i < denominations.length; i++) {
			if (coinsRemaining[i] > 0 && value >= denominations[i]) {
				coinsRemaining[i]--;
				int subMinCoins = minCoins(denominations, coinsRemaining, value - denominations[i]);
				coinsRemaining[i]++;

				if (subMinCoins != -1) {
					minCoins = Math.min(minCoins, subMinCoins + 1);
				}
			}
		}

		return minCoins != Integer.MAX_VALUE ? minCoins : -1;
	}

	// Calculates the sum of elements in an array
	private static int sum(int[] array) {
		int total = 0;
		for (int num : array) {
			total += num;
		}
		return total;
	}

	// Checks if all available coins are exhausted
	private static boolean allCoinsExhausted(int[] coinsRemaining) {
		for (int remaining : coinsRemaining) {
			if (remaining > 0) {
				return false;
			}
		}
		return true;
	}

}
