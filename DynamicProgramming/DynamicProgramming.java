import java.util.HashMap;


public class DynamicProgramming {

	
    // Every day for the rest of the year, you're going to be given a choice between two jobs to do: 
    // one that is LOW stress, and one that is HIGH stress.  Each job pays out a dollar amount; 
    // *usually* the high stress jobs pay more.  However, after doing a high stress job, you need to 
    // REST for a day.

    // Given a list of all the payouts for all the low stress and high stress jobs, 
    // what is the most amount of money you can get?
    
    // You can assume lowPayouts.length == highPayouts.length
    public static int hiLoStress(int[] lowPayouts, int[] highPayouts) {

        HashMap<Integer, Integer> expectedPayout = new HashMap<Integer, Integer>();

        return hiLoStressHelper(lowPayouts, highPayouts, expectedPayout, 0);

    }

    public static int hiLoStressHelper(int[] lowPayouts, int[] highPayouts, HashMap<Integer, Integer> expectedPayout, int day) {

        if (day >= lowPayouts.length) { 
            return 0;
        }

        if (expectedPayout.get(day) != null) {
            return expectedPayout.get(day);
        }
        
        int highPayout = highPayouts[day] + hiLoStressHelper(lowPayouts, highPayouts, expectedPayout, day + 2);
        int lowPayout = lowPayouts[day] + hiLoStressHelper(lowPayouts, highPayouts, expectedPayout, day + 1);

        int maxPayout = highPayout;
        if (lowPayout > highPayout) {
            maxPayout = lowPayout;
        }

        expectedPayout.put(day, maxPayout);
        return maxPayout;

    }

    
	// You are partaking in a scavenger hunt!
    // You've gotten a secret map to find many of the more difficult
    // items, but they are only available at VERY specific times at
    // specific places.  You have an array, times[], that lists at which
    // MINUTE an item is available, in increasing order.
    // Items in the ScavHunt are worth varying numbers of points.
    // You also have an array, points[], same length as times[],
    // that lists how many points each of the corresponding items is worth.
    // Problem is: to get from one location to the other takes 5 minutes,
    // so if there is an item, for example, available at time 23 and another
    // at time 27, it's just not possible for you to make it to both: you'll
    // have to choose!
    // Write a method that returns the maximum POINTS you can get.
    public static int scavHunt(int[] times, int[] points) {
	
        HashMap<Integer, Integer> expectedMoney = new HashMap<Integer, Integer>();

        return scavHelper(times, points, expectedMoney, 0);

	}

    public static int scavHelper(int[] times, int[] points, HashMap<Integer, Integer> expectedMoney, int index) {

        if (index == times.length - 1) {
            return points[index];
        }

        if (index >= times.length) {
            return 0;
        }

        if (expectedMoney.get(index) != null) {
            return expectedMoney.get(index);
        }

        int nextIndex = getFiveTimeIndex(index, times);

        int take = 0;
        

        if (nextIndex != -1) {
            take = points[index] + scavHelper(times, points, expectedMoney, nextIndex);
        }

        //int take = points[index] + scavHelper(times, points, expectedMoney, nextIndex);
        int notTake = scavHelper(times, points, expectedMoney, index + 1);

        int maxMoney = notTake;
        if (take > notTake) {
            maxMoney = take;
        }

        expectedMoney.put(index, maxMoney);
        return maxMoney;

    }

    public static int getFiveTimeIndex(int currentIndex, int[] times) {
        for (int i = currentIndex; i < times.length; i++) {
            if (times[i] >= times[currentIndex] + 5) {
                return i;
            }
        }

        return -1;
    }
    


	/* Uses memoization to calculate the route which grants the most cookies, 
	 * starting at [0][0], only going right or down at each point */
	public static int dynamicCookies(int[][] cookieGrid) {

        int[][] solutionGrid = new int[cookieGrid.length][cookieGrid[0].length];

        return recursiveOptimalPath(0, 0, cookieGrid, solutionGrid);

	}

    private static boolean goodPoint(int row, int col, int[][] cookieGrid) {
        int numRows = cookieGrid.length;
        int numCols = cookieGrid[0].length;

        return (row >= 0 && row < numRows && 
        col >= 0 && col < numCols && 
        cookieGrid[row][col] >= 0);
   
        }

        /* RECURSIVELY calculates the route which grants the most cookies.

        * Returns the maximum number of cookies attainable. */


        /* Helper function for the above, which returns the maximum number of cookies 
       
       
        * edible starting at coordinate (row, col). */
       
       
        /* From any given position, always check right before checking down */
   
        private static int recursiveOptimalPath(int row, int col, int[][] cookieGrid, int[][] solutionGrid) {
        
       
        if (!goodPoint(row, col, cookieGrid)) {
            return 0;
        }

        if (solutionGrid[row][col] != 0) {
            return solutionGrid[row][col];
        }
   
        int down = recursiveOptimalPath(row+1, col, cookieGrid, solutionGrid);
        int right = recursiveOptimalPath(row, col+1, cookieGrid, solutionGrid);

        if (goodPoint(row + 1, col, cookieGrid)) {
            solutionGrid[row+1][col] = down;
        }

        if (goodPoint(row, col + 1, cookieGrid)) {
            solutionGrid[row][col+1] = right;
        }
        
 
        return cookieGrid[row][col] + Math.max(right, down);

        } 

}
