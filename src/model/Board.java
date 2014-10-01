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
		boolean[][] Path = new boolean[setup.getGenMax()][setup.getGenMax()];
		for (index = 0; index < setup.getGenMax(); index++)
		{
			for (index1 = 0; index1 < setup.getGenMax(); index1++)
			{
				Path[index][index1] = false;
			}
		}
		Path[setup.getGenCent()][setup.getGenCent()] = true;
		Path = Pathfinder(setup.getGenCent(), setup.getGenCent(), setup, Path);
		// if (Path == setup.get())
		if (true)
		{
			System.out.print("Setup: ");
			for (index = 0; index < setup.getGenMax() - 1; index++)
			{
				for (index1 = 0; index1 < setup.getGenMax() - 1; index1++)
				{
					if (setup.get()[index][index1])
					{
						System.out.print(setup.get()[index][index1] + "  ");
					}
					else
					{
						System.out.print(setup.get()[index][index1] + " ");
					}
				}
			}
			System.out.println("");
			System.out.print("Path:  ");
			for (index = 0; index < setup.getGenMax() - 1; index++)
			{
				for (index1 = 0; index1 < setup.getGenMax() - 1; index1++)
				{
					if (Path[index][index1])
					{
						System.out.print(Path[index][index1] + "  ");
					}
					else
					{
						System.out.print(Path[index][index1] + " ");
					}
				}
			}
			System.out.println("");
			System.out.println(Path == setup.get());
			for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 1.5) - 2; i++)
			{
				System.out.print(" ");
			}
		}
		/*
		 * while (!isEdge)
		 *	{
		 *		index = RanInt(setup);
		 *		index1 = RanInt(setup);
		 *		EdgeTest(setup);
		 *		System.out.println(index + " " + index1);
		 *		System.out.println(isEdge);
		 *	}
		 */
	}

	private int RanInt(Setup setup)
	{
		return rand.nextInt((setup.getGenMax() - setup.getGenMin())) + setup.getGenMin();
	}

	private boolean[][] Pathfinder(int index, int index1, Setup setup, boolean[][] path)
	{
		
		if (index + 1 < setup.getGenMax())
		{
			if (setup.get()[index + 1][index1])
			{
				if (!path[index + 1][index1])
				{
					path[index + 1][index1] = true;
					path = Pathfinder(index + 1, index1, setup, path);
				}
			}
		}
		
		if (index > setup.getGenMin())
		{
			if (setup.get()[index - 1][index1])
			{
				if (!path[index - 1][index1])
				{
					path[index - 1][index1] = true;
					path = Pathfinder(index - 1, index1, setup, path);
				}
			}
		}
		
		if (index1 + 1 < setup.getGenMax())
		{
			if (setup.get()[index][index1 + 1])
			{
				if (!path[index][index1 + 1])
				{
					path[index][index1 + 1] = true;
					path = Pathfinder(index, index1 + 1, setup, path);
				}
			}
		}
		
		if (index1 > setup.getGenMin())
		{

			if (setup.get()[index][index1 - 1])
			{
				if (!path[index][index1 - 1])
				{
					path[index][index1 - 1] = true;
					path = Pathfinder(index, index1 - 1, setup, path);
				}
			}
		}
		
		return path;
	}
}