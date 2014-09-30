package model;

import java.util.Random;

public class Board
{
	Random rand = new Random();
	int index;
	int index1;
	boolean isEdge = false;

	/**
	 * 
	 * @param setup
	 */
	public Board(Setup setup)
	{
		int[][] Board = new int[setup.getGenMax()][setup.getGenMax()];
		int[][] Path = new int[setup.getGenMax()][setup.getGenMax()];
		boolean[][] PathBool = new boolean[setup.getGenMax()][setup.getGenMax()];
		for (index = 0; index < setup.getGenMax(); index++)
		{
			for (index1 = 0; index1 < setup.getGenMax(); index1++)
			{
				Path[index][index1] = 0;
				PathBool[index][index1] = false;
			}
		}
		Path = Pathfinder(setup.getGenCent(), setup.getGenCent(), setup, Path);
		for (index = 0; index < setup.getGenMax() - 1; index++)
		{
			for (index1 = 0; index1 < setup.getGenMax() - 1; index1++)
			{
				if (Path[index][index1] == 1)
				{
					PathBool[index][index1] = true;
				}
			}
		}
		//if (PathBool == setup.get())
		if (true)
		{
			System.out.print("Setup: ");
			for (index = 0; index < setup.getGenMax() - 1; index++)
			{
				for (index1 = 0; index1 < setup.getGenMax() - 1; index1++)
				{
					System.out.print(setup.get()[index][index1] + " ");
				}
			}
			System.out.println("");
			System.out.print("Path:  ");
			for (index = 0; index < setup.getGenMax() - 1; index++)
			{
				for (index1 = 0; index1 < setup.getGenMax() - 1; index1++)
				{
					System.out.print(PathBool[index][index1] + " ");
				}
			}
		}
		while (!isEdge)
		{
			index = RanInt(setup);
			index1 = RanInt(setup);
			EdgeTest(setup);
			System.out.println(index + " " + index1);
			System.out.println(isEdge);
		}
	}

	private int RanInt(Setup setup)
	{
		return rand.nextInt((setup.getGenMax() - setup.getGenMin())) + setup.getGenMin();
	}

	private boolean EdgeTest(Setup setup)
	{
		if (setup.get()[index][index1])
		{
			if (index != setup.getGenMin() && index1 != setup.getGenMin()
					&& (index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& setup.get()[index - 1][index1 - 1] && setup.get()[index - 1][index1] && setup.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMin() && index1 != setup.getGenMax() - 1
					&& (index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1])
					&& setup.get()[index - 1][index1 + 1] && setup.get()[index - 1][index1] && setup.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMax() - 1 && index1 != setup.getGenMin()
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& setup.get()[index + 1][index1 - 1] && setup.get()[index + 1][index1] && setup.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMax() - 1 && index1 != setup.getGenMax() - 1
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1])
					&& setup.get()[index + 1][index1 + 1] && setup.get()[index + 1][index1] && setup.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if ((index != setup.getGenMax() - 1 && setup.get()[index + 1][index1])
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index != setup.getGenMin() && setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 != setup.getGenMax() - 1 && setup.get()[index][index1 + 1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& (index1 != setup.getGenMin() && setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
		}
		return isEdge;
	}
	private int[][] Pathfinder(int index, int index1, Setup setup, int[][] path)
	{
		if (setup.get()[index + 1][index])
		{
			path[index + 1][index1] = 1;
			path = Pathfinder(index + 1, index1, setup, path);
		}
		return path;
	}
}