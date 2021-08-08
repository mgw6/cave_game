/*
MacGregor Winegard March 2020
This is a simple text based game. The objective is to escape the cave
without getting eaten by the monster.
*/

import java.util.Random;
import java.util.Scanner;

public class monster
{
	public static void main(String args[])
	{
		
		int x, y;
		Random rand = new Random();
		Scanner      input = new Scanner (System.in);
		int size;
		boolean      done = false;
		int choice;

		
		size = 6;
		
		int grid[] [] = new int [size] [size]; // generates a grid of the inputted size
		
		for (x = 0; x<size; x++) //makes all the values in the grid 0
		{
			for (y = 0; y<size; y++)
			{
				grid[x] [y] = 0;
			}
		}
		

		
		// generates monster
		int wx, wy; 
		wx=0; wy=0;
		wx = rand.nextInt((size-3))+1;
		wy = rand.nextInt((size-3))+1;

		grid [wx] [wy] = 9; 
		grid [wx+1] [wy] = grid [wx+1] [wy+1] = grid [wx+1] [wy-1] = 8;
		grid [wx-1] [wy] = grid [wx-1] [wy+1] = grid [wx-1] [wy-1] = 8;
		grid [wx] [wy+1] = grid [wx] [wy-1] = 8; // monster placed
		
		
		grid [size -1] [size - 1] =2; // sets exit
		grid [size -2] [size-1] =grid [size-1] [size -2] = 3; // sets heads up at exits

		
			int lx = 0; 
			int ly = 2; // sets location while (!done)
			
		System.out.printf("\n\nWhile spelunking one day, you find a hole. You start to investigate the hole, and suddenly you fall in!\n");
		System.out.printf("You cannot see anything. It is dark. You feel around you, and find cold hard stone.\n");
		System.out.printf("You hear a creature of sorts, moving, breathing. It sounds scary...\n");
		
		
		
		while (!done)
		{
			
		/*	for (y=0; y<size; y++) //print the grid, should be not showing on final product.
		{
			for (x=0; x<size; x++)
			{
				System.out.printf("%d ", grid[x][y]);
			}
			System.out.println();
		}
		 //next line prints location as a check
		System.out.printf(" %d %d", lx, ly); */
		
		
				printmenu();
				System.out.printf("input:");
				choice = input.nextInt();
					while (choice >4) // checks to make sure the inputed value is actually 5 or greater 
					{
					System.out.printf("Clearly you struggle to follow directions.\n"); // I like to think I have a sense of humor, but I better hope I followed all directions for this assignment
					System.out.printf("Please input your choice of move, between 1 and 4. \n");
					choice = input.nextInt();
					}
				System.out.printf("\n");
			switch (choice)	
			{
				case 1: //forwards
					if ( lx <(size-1))
					{
						lx=lx+1;
						System.out.printf("You start to take a step forwards...");
					} else {
						System.out.printf("You start to move that way, but you feel the cold hard wall, and stop.");
					}				
				break;
				case 2: //backwards
					if ( lx >(0))
					{
						lx=lx-1;
						System.out.printf("You start to take a step backwards...");
					} else {
						System.out.printf("You start to move that way, but you feel the cold hard wall, and stop.");
					}	
				break;
				case 3: //left
					if ( ly <(size-1))
					{
						System.out.printf("You start to take a step left...");
						ly=ly+1;
					} else {
						System.out.printf("You start to move that way, but you feel the cold hard wall, and stop.");
					}				
				break;
				
				case 4: //right
					if ( ly >(0))
					{
						ly=ly-1;
						System.out.printf("You start to take a step to your right...");
					} else {
						System.out.printf("You start to move that way, but you feel the cold hard wall, and stop.");
					}	
				break;
			}
			
			// 9 is monster, 8 is monster warning, exit is 2, exit warning is 3
			
			if ((grid [lx] [ly]) == 9) // monster
			{  
			System.out.printf("... and you feel something slimy, and cold - ITS THE MONSTER HE EATS YOU!!! CUE DEATH SCENE.\n");
			
			done = true;
			}
			
			if ((grid [lx] [ly]) == 8) // monster warning
			{  
			System.out.printf("... your foot lands, but suddenly the creature sounds a lot closer. And it smells god awful.\n");
			
			}
			
			if ((grid [lx] [ly]) == 2) // exit
			{  
			System.out.printf("... YOU FOUND DAYLIGHT!! YOURE OUTSIDE!! You've lived!! Now just to figure out where you are. But that is a game for another day.\n");
			
			done = true;
			}
			
			if ((grid [lx] [ly]) == 3) // exit warning
			{  
			System.out.printf("... your foot lands. Suddenly you see daylight, and wind. You are so close to getting out of this!\n");
			
			
			}
			
			if ((grid [lx] [ly]) == 0) // nothing
			{  
			System.out.printf("... you find your footing, and ponder where to make your next step.\n");
			
			}
			
		
			
		}
	
	} // end main
	

	public static void printmenu() // prints out the movement menu
	{
		System.out.printf ("\nSelect which way you would like to move:\n");
		System.out.printf ("1) Forward\n");
		System.out.printf ("2) backward\n");
		System.out.printf ("3) Left\n");
		System.out.printf ("4) Right\n\n");
	}
}
