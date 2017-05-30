
/*
 * In a board game roll a 6-faced dice and move forward the same number of spaces that is rolled. 
 * If the finishing point is “n” spaces away from the starting point, implement a program that calculates 
 * the number of possible ways there are to arrive exactly at the finishing point.
 */

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardGameWaysToReachAPosition
{
	static int combinationCount = 0;

	public void combinationCalc(int[] diceFaceValues, int target, int j, List<Integer> current)
	{
		if (target == 0)
		{
			combinationCount++;
			return;
		}

		for (int i = j; i < diceFaceValues.length; i++)
		{
			if (target < diceFaceValues[i])
			{
				return;
			}

			current.add(diceFaceValues[i]);
			combinationCalc(diceFaceValues, target - diceFaceValues[i], i, current);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args)
	{
		BoardGameWaysToReachAPosition dice = new BoardGameWaysToReachAPosition();
		int[] diceFaceValues = { 1, 2, 3, 4, 5, 6 };
		int target = 610;

		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		Date startTime = new Date(timeStamp.getTime());
		System.out.println("Started at: " + startTime);

		dice.combinationCalc(	diceFaceValues, target, 0,
								new ArrayList<Integer>());

		timeStamp = new Timestamp(System.currentTimeMillis());
		Date endDate = new Date(timeStamp.getTime());
		System.out.println("Ended at: " + endDate);
		System.out.println("Possible combinations: " + combinationCount);
	}
}

