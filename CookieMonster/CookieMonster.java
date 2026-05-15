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
		if (cookieGrid[0][0] == -1) {
			return 0;
		}
		
		return recursiveCookies(0,0);	
	}	
	
	// Returns the maximum number of cookies edible starting from (and including) cookieGrid[row][col]
	public int recursiveCookies(int row, int col) {
		
		if (row == numRows - 1 && col == numCols - 1) {
			return cookieGrid[row][col];
		}

		int maxCookies = cookieGrid[row][col];
		int rightCookies = 0;
		int downCookies = 0;

		if (validPoint(row + 1, col)) {
			rightCookies = recursiveCookies(row + 1, col);
		}

		if (validPoint(row, col + 1)) {
			downCookies = recursiveCookies(row, col + 1);
		}

		return maxCookies + Math.max(rightCookies, downCookies);

		
	}
	

	/* Calculate which route grants the most cookies using a QUEUE.
	 * Returns the maximum number of cookies attainable. */
    /* From any given position, always add the path right before adding the path down */
    public int queueCookies() {
		
		if (cookieGrid[0][0] == -1) {
			 	return 0;
		}

		ArrayDeque<OrphanScout> q = new ArrayDeque<>();
		int row = 0;
		int col = 0;
		OrphanScout firstKid = new OrphanScout(row, col, cookieGrid[0][0]);
		int max = cookieGrid[0][0];
		q.add(firstKid);

		while (!q.isEmpty()) {
			OrphanScout currentOrphan = q.poll();
			row = currentOrphan.getEndingRow();
			col = currentOrphan.getEndingCol();
			int currentCookies = currentOrphan.getCookiesDiscovered();

			if (validPoint(row + 1, col)) {
				OrphanScout rightKid = new OrphanScout(row + 1, col, currentCookies + cookieGrid[row + 1][col]);
				if (!(rightKid.getCookiesDiscovered() < currentCookies)) {
					if (rightKid.getCookiesDiscovered() > max) {
						max = rightKid.getCookiesDiscovered();
					}
				}
				q.add(rightKid);
			}

			if (validPoint(row, col + 1)) {
				OrphanScout downKid = new OrphanScout(row, col + 1, currentCookies + cookieGrid[row][col + 1]);
				if (!(downKid.getCookiesDiscovered() < currentCookies)) {
					if (downKid.getCookiesDiscovered() > max) {
						max = downKid.getCookiesDiscovered();
					}
				}
				q.add(downKid);
			}
		}

		return max;
		


    }

    
    /* Calculate which route grants the most cookies using a stack.
 	 * Returns the maximum number of cookies attainable. */
    /* From any given position, always add the path right before adding the path down */
    public int stackCookies() {

		if (cookieGrid[0][0] == -1) {
			return 0;
   		}

		Stack<OrphanScout> q = new Stack<>();
		int row = 0;
		int col = 0;
		OrphanScout firstKid = new OrphanScout(row, col, cookieGrid[0][0]);
		int max = cookieGrid[0][0];
		q.push(firstKid);

		while (!q.isEmpty()) {
			OrphanScout currentOrphan = q.pop();
			row = currentOrphan.getEndingRow();
			col = currentOrphan.getEndingCol();
			int currentCookies = currentOrphan.getCookiesDiscovered();

			if (validPoint(row + 1, col)) {
				OrphanScout rightKid = new OrphanScout(row + 1, col, currentCookies + cookieGrid[row + 1][col]);
				if (!(rightKid.getCookiesDiscovered() < currentCookies)) {
					if (rightKid.getCookiesDiscovered() > max) {
						max = rightKid.getCookiesDiscovered();
					}
				}
				q.push(rightKid);
			}

			if (validPoint(row, col + 1)) {
				OrphanScout downKid = new OrphanScout(row, col + 1, currentCookies + cookieGrid[row][col + 1]);
				if (!(downKid.getCookiesDiscovered() < currentCookies)) {
					if (downKid.getCookiesDiscovered() > max) {
						max = downKid.getCookiesDiscovered();
					}
				}
				q.push(downKid);
			}
		}

		return max;


    }

}
