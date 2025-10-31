import java.util.ArrayList;
import java.lang.StringBuilder;


public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		ListNode current = head;
		if (current.getNext() == null) {
			System.out.println(current.getValue());
		} else {
			printListInReverse(current.getNext());
			System.out.println(current.getValue());
		}

	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (r < 0 || r > grid[0].length || c < 0 || c > grid.length) {
			return;
		}
		if (grid[r][c].equals("vaccinated") || grid[r][c].equals("infected")) {
			return;
		}
		infect(grid, r+1, c);
		infect(grid, r-1, c);
		infect(grid, r, c+1);
		infect(grid, r, c-1);
		grid[r][c] = "infected";

	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		if (n == 1) {
			return 2;
		} if (n == 2) {
			return 3;
		} else {
			return countNonConsecutiveSubsets(n-1) + countNonConsecutiveSubsets(n-2);
		}
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (n-1) + countWaysToJumpUpStairs(n-1);
		}
	}

	// Everything above this line does NOT require a recursive helper method
	// ----------------------------------
	// Everything below this line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) your description must include role of each parameter in the helper method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice
	public static void printSubsets(String str) {
		if (str.length() == 0) {
			System.out.println("");
		} else {
			ArrayList<String> toPrint = createSubsets(str);
			StringBuilder printableString = new StringBuilder();
			for (int i = 0; i < toPrint.size() - 1; i++) {
				printableString.append("\"" + toPrint.get(i) + "\", ");
			}
			printableString.append("\"" + toPrint.get(toPrint.size()-1) + "\"");
			System.out.println(printableString);
		}
	}

	// Our recursive helper method will, eventually, return every subset of the original string. To do this, it will 
	// call itself on the list minus the first letter, until it gets all the way to one letter, where it will return
	// that letter plus and empty string. Elsewhere, it will add the letter to calling the same method on the list minus that letter, for example "abc", calling it would do a + "bc" and we'd add a to every subset in bc, plus maintain the original bc subsets without a. This will ensure that at the end we have all subsets, with the first letter and without.
	// our only parameter intakes a String that is the word/list that we want to create all the subsets of, so it'll start with the whole string, but then each recursive will call it with one less letter.
	public static ArrayList<String> createSubsets(String list) {
		if (list.length() == 1) {
			ArrayList<String> toReturn = new ArrayList<String>();
			toReturn.add("");
			toReturn.add(list.substring(0, 1));
			return toReturn;
		} else {
			String firstLetter = list.substring(0, 1);
			ArrayList<String> previousSubsets = createSubsets(list.substring(1, list.length()));
			ArrayList<String> toReturn = new ArrayList<String>();
			for (int i = 0; i < previousSubsets.size(); i++) {
				toReturn.add(firstLetter + previousSubsets.get(i));
			}
			toReturn.addAll(previousSubsets);
			return toReturn;
		}
	}

	

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void printPermutations(String str) {
		if (str.length() == 0) {
			System.out.println("");
		} else {
			ArrayList<String> toPrint = createPermutations(str);
			StringBuilder printableString = new StringBuilder();
			for (int i = 0; i < toPrint.size() - 1; i++) {
				printableString.append("\"" + toPrint.get(i) + "\", ");
			}
			printableString.append("\"" + toPrint.get(toPrint.size()-1) + "\"");
			System.out.println(printableString);
		}

	}

	// This method creates all the actual permutations and the print method above just prints it. 
	// It has a base case of the list is 2 and will just print ab, ba. If not, it will call itself on
	// the method without the first letter, then for each permutation that it returns I will add the first letter
	// to each position possible. ex. with abc, i call it on bc, get bc & cb, and then add a to all 3 possible positions
	// for each of the two permutations. The parameter is the string that we're intaking, but it'll be without the first letter.
	public static ArrayList<String> createPermutations(String str) {
		ArrayList<String> toReturn = new ArrayList<String>();
		if (str.length() == 1) {
			toReturn.add(str);
			return toReturn;
		} else if (str.length() == 2) {
			toReturn.add(str);
			toReturn.add(str.substring(1, 2) + str.substring(0, 1));
			return toReturn;
		} else {
			String letter = str.substring(0, 1);
			ArrayList<String> permutations = createPermutations(str.substring(1));
			for (int i = 0; i < permutations.size(); i++) {
				for (int j = 0; j <= permutations.get(i).length(); j++) {
					String currentPermutation = permutations.get(i); 
					String toAdd = "";
					if (j == 0) {
						toAdd = letter + currentPermutation;
					} else if (j == currentPermutation.length()) {
						toAdd = currentPermutation + letter;
					}
					else {
						toAdd = currentPermutation.substring(0, j) + letter + currentPermutation.substring(j, currentPermutation.length());
					}
					toReturn.add(toAdd);
				}
			}
			return toReturn;
		}
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] ints) {

	}

	public static ArrayList<Integer> recombineArrays(ArrayList<Integer> oneArray, ArrayList<Integer> twoArray) {
		int pointerOne = 0;
		int pointerTwo = 0;
		ArrayList<Integer> newList = new ArrayList<Integer>();
		while (pointerOne != oneArray.size() && pointerTwo != twoArray.size()) {
			if (oneArray.get(pointerOne) < twoArray.get(pointerTwo)) {
				newList.add(oneArray.get(pointerOne));
				pointerOne++;
			} else {
				newList.add(twoArray.get(pointerTwo));
				pointerTwo++;
			}
		}
		if (pointerOne == oneArray.size()) {
			for (int i = pointerTwo; i < twoArray.size(); i++) {
				newList.add(twoArray.get(pointerTwo));
			}
		} else if (pointerTwo == twoArray.size()) {
			for (int i = pointerOne; i < oneArray.size(); i++) {
				newList.add(oneArray.get(pointerOne));
			}
		}
		return newList;
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] ints) {

	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int startingDisks) {

	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.
	public static int scavHunt(int[] times, int[] points) {

	}

}
