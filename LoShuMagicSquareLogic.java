/* Miron Smierzewski
   4/2      9/2022
   This class contains the logic that determines if a 2D array is a magic square and a Lo shu magic square */

public class LoShuMagicSquareLogic     
{
   public boolean determineMagicSquare(int [][] numberArray)
   {
      //declaring and initializing an int variable to hold the sum of all elements in the array
      int total = 0;
      
      //declaring and initializing a boolean variable to hold the boolean whether the array is a magic square or not
      boolean magic = true;
      
      //finding the sum of the first diagonal
      for(int diagonal = 0; diagonal < numberArray.length; diagonal++)
      {
         total += numberArray[diagonal][diagonal]; 
      }
      //creating a for each loop to find the total of each row
      for(int[] ints : numberArray)
      {
         //variable to hold the sum of each row
         int rowTotal = 0;
         for(int column = 0; column < numberArray.length; column++)
         {
            rowTotal += ints[column];
         }
         //checking if the row total is equal to the diagonal total
         if(rowTotal != total)
            magic = false;
      }
      
      
      //creating a loop to find the sum of each column
      for(int column = 0; column < numberArray.length; column++)
      {
         int columnTotal = 0;

         for(int row = 0; row < numberArray.length; row++)
         {
            columnTotal += numberArray[row][column];
         }
         if(columnTotal != total)
         {
            magic = false;
         }   
      }
      
      if(magic == true)
         System.out.println("This is a magic square");
      else
         System.out.println("This is not a magic square");
      
      return magic;
         
   }
   
   /* determineLoShu determines if 2D array is a Lo Shu Magic Square 
      @param int[][], numberArray, the 2D array
      @param boolean, magicSquare, if the 2D array is a magic square
      @param int, size, how large the 2D array is
   */
   public boolean determineLoShu(int[][] numberArray,boolean magicSquare, int size)
   {
      boolean loShuMagic = true; //initializing boolean that determines if the magicSquare is a loShu magic square
               
      if(size == 3) //determining if the array is the correct size
      {
         for(int row = 0; row < numberArray.length; row++) //iterating through rows and columns
         {
            for(int column = 0; column < numberArray.length; column++)
            {
               if(numberArray[row][column] <= 9) //checking if the numbers entered are less than or equal to 9
               {
                  for(int rowS = 0; rowS < numberArray.length; rowS++) //iterating through rows and columns once more
                  {
                     for(int columnS = 0; columnS < numberArray.length; columnS++)
                     {
                        if(numberArray[row][column] == numberArray[rowS][columnS]) //checking if there is a duplicate element
                        {   
                           if(rowS != row && columnS != column) //declaring an element duplicate if the indexes do not match
                           {
                           loShuMagic = false;
                           }
                        }
                     }  
                  }      
               }
               else 
                  loShuMagic = false;  
            }
         }   
      }
      else
         loShuMagic = false;
      
      
      return loShuMagic;      
   }
}