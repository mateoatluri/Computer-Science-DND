import java.io.*;
import java.util.*;

// You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make stacks and queues


public class CookieMonster {

    private int [][] cookieGrid;
    private int numRows;
    private int numCols;
    
    //Constructs a CookieMonster from a file with format:
    //numRows numCols
    //<<rest of the grid, with spaces in between the numbers>>
    public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try
		{
			Scanner input = new Scanner(new File(fileName));

			numRows    = input.nextInt();  
			numCols    = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++) 
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();
			
			input.close();
		}
		catch (Exception e)
		{
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

    }

    public CookieMonster(int [][] cookieGrid) {
        this.cookieGrid = cookieGrid;
        this.numRows    = cookieGrid.length;
        this.numCols    = cookieGrid[0].length;
    }

    //You may find it VERY helpful to write this helper method.  Or not!
	private boolean validPoint(int row, int col) {
		//Write this if you want
		if (row >= numRows || row < 0 || col >= numCols || col < 0 || cookieGrid[row][col] == -1 ) {
			return false;
		} else {
			return true;
		}
	}
	
	/* RECURSIVELY calculates the route which grants the most cookies.
	 * Returns the maximum number of cookies attainable. */
	public int recursiveCookies() {
		return recursiveCookies(0,0);	
	}	
	
	// Returns the maximum number of cookies edible starting from (and including) cookieGrid[row][col]
	public int recursiveCookies(int row, int col) {
		int rightValue = -1;
		int downValue = -1;
		
		if (row == numRows - 1 && col == numCols - 1) {
			return cookieGrid[row][col];
		}

		if (row + 1 < numRows && validPoint(row + 1, col) == true) {
			rightValue = recursiveCookies(row + 1, col);
		}

		if (col + 1 < numCols && validPoint(row, col + 1) == true) {
			downValue = recursiveCookies(row, col + 1);
		}

		if (rightValue != -1 && downValue != -1) {
			if (rightValue > downValue) {
				return rightValue + cookieGrid[row][col];
			} else {
				return downValue + cookieGrid[row][col];
			}
		} else if (rightValue == -1) {
			return downValue + cookieGrid[row][col];
		} else if (downValue == -1) {
			return rightValue + cookieGrid[row][col];
		} else {
			return -1;
		}
		
	}
	

	/* Calculate which route grants the most cookies using a QUEUE.
	 * Returns the maximum number of cookies attainable. */
    /* From any given position, always add the path right before adding the path down */
    public int queueCookies() {
		ArrayDeque<OrphanScout> q = new ArrayDeque<>();
		int row = 0;
		int col = 0;

		OrphanScout firstKid = new OrphanScout(row, col, cookieGrid[0][0]);
		//int cookieCount = firstKid.getCookiesDiscovered();
		int newCookieCount = 0;
		q.add(firstKid);

		while (!(q.peek().getEndingRow() == numRows - 1 && q.peek().getEndingCol() == numCols - 1)) {
			row = q.peek().getEndingRow();
			col = q.peek().getEndingCol();
			
			if (validPoint(row + 1, col)) {
				newCookieCount = q.peek().getCookiesDiscovered() + cookieGrid[row + 1][col];
				q.add(new OrphanScout(row + 1, col, newCookieCount));
			}	
			
			if (validPoint(row, col + 1)) {
				newCookieCount = q.peek().getCookiesDiscovered() + cookieGrid[row][col + 1];
				q.add(new OrphanScout(row, col + 1, newCookieCount));
			}

			q.remove();
		}

		int maxCookies = 0;
		while (q.peek() != null) {
			int currentCookies = q.remove().getCookiesDiscovered();
			if (currentCookies > maxCookies) {
				maxCookies = currentCookies;
			}
		}

		return maxCookies;

    }

    
    /* Calculate which route grants the most cookies using a stack.
 	 * Returns the maximum number of cookies attainable. */
    /* From any given position, always add the path right before adding the path down */
    public int stackCookies() {
		

		
		Stack<OrphanScout> stack = new Stack<>();
		int row = 0;
		int col = 0;
		int maxCookies = 0;

		OrphanScout firstKid = new OrphanScout(row, col, cookieGrid[0][0]);

		int rightCookieCount = 0;
		int leftCookieCount = 0;
		stack.push(firstKid);

		while (!stack.empty()) {
			OrphanScout current = stack.pop();

			row = current.getEndingRow();
			col = current.getEndingCol();

			if (row == numRows - 1 && col == numCols -1) {
				if (current.getCookiesDiscovered() > maxCookies) {
					maxCookies = current.getCookiesDiscovered();
				}
			}

			OrphanScout rightKid = new OrphanScout(0, 0, 0);
			OrphanScout downKid = new OrphanScout(0, 0, 0);

			if (validPoint(row + 1, col)) {
				rightCookieCount = current.getCookiesDiscovered() + cookieGrid[row + 1][col];
				rightKid = new OrphanScout(row + 1, col, rightCookieCount);
			}

			if (validPoint(row, col + 1)) {
				leftCookieCount = current.getCookiesDiscovered() + cookieGrid[row][col + 1];
				downKid = new OrphanScout(row, col + 1, leftCookieCount);
			}

			if (validPoint(row, col + 1)) {
				stack.push(downKid);
			}

			if (validPoint(row + 1, col)) {
				stack.push(rightKid);
			}
		
		}


		return maxCookies;


		
		// Stack<OrphanScout> stack = new Stack<>();
		// int row = 0;
		// int col = 0;

		// OrphanScout firstKid = new OrphanScout(row, col, cookieGrid[0][0]);

		// int rightCookieCount = 0;
		// int leftCookieCount = 0;
		// stack.push(firstKid);

		// while (!(stack.peek().getEndingRow() == numRows - 1 && stack.peek().getEndingCol() == numCols - 1)) {
		// 	row = stack.peek().getEndingRow();
		// 	col = stack.peek().getEndingCol();
		// 	OrphanScout rightKid = new OrphanScout(0, 0, 0);
		// 	OrphanScout downKid = new OrphanScout(0, 0, 0);

		// 	if (validPoint(row + 1, col)) {
		// 		rightCookieCount = stack.peek().getCookiesDiscovered() + cookieGrid[row + 1][col];
		// 		rightKid = new OrphanScout(row + 1, col, rightCookieCount);
		// 	}

		// 	if (validPoint(row, col + 1)) {
		// 		leftCookieCount = stack.peek().getCookiesDiscovered() + cookieGrid[row][col + 1];
		// 		downKid = new OrphanScout(row, col + 1, leftCookieCount);
		// 	}

		// 	stack.pop();

		// 	if (validPoint(row, col +1)) {
		// 		stack.push(downKid);
		// 	}

		// 	if (validPoint(row + 1, col)) {
		// 		stack.push(rightKid);
		// 	}
		
		// }

		// int maxCookies = 0;
		// while (!stack.empty()) {
		// 	int currentCookies = stack.pop().getCookiesDiscovered();
		// 	if (currentCookies > maxCookies) {
		// 		maxCookies = currentCookies;
		// 	}
		// }

		// return maxCookies;
    }

}
