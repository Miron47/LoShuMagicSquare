/* Miron Smierzewski
   3/23/2022 
This class handles the inputs for the MagicSquare program   */
import java.util.Scanner;

public class MagicSquareInput extends LoShuMagicSquareLogic implements Input
{   
   
   /* getInput creates a 2D array and fills it with user input 
      @param size, size of the 2D array 
      @return arrayNumber, 2D array filled with integer numbers
   */
   
   public int[][] getInput(int size)
   {
      String s; // string variable to hold users input
      int numberArray[][] = new int[size][size];
      
      Scanner myObj = new Scanner(System.in);
      
      int counter = 0;
      int amountElements = size*size;
      for(int row = 0; row < numberArray.length; row++)
      {
         //place holder value to hold users input
         int value = 0;
         //validated user input
         int validValue = 0;
         
         for(int col = 0; col < numberArray[row].length; col++)
         {
            try
            {
               //incrementing counter
               counter++;
               System.out.println("Type a number, then press enter. You are on number: " + counter + "/" + amountElements);
               
               //parsing user input and adding it to numberArray
               s = myObj.nextLine();
               value = Integer.parseInt(s);
               validValue = validateNumber(value);
               numberArray[row][col] = validValue;
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
               System.out.println("You entered an incorrect value. Please enter an integer number.");
               //lowering position in index of array and lowering counter
               col--;
               counter--;
            }
            catch(NumberFormatException e)
            {
               System.out.println("You entered an incorrect value. Please enter an integer number.");
               //lowering position in index of array and lowering counter
               col--;
               counter--;
            }
         }
         
            
      }
      
      return numberArray;
   }
   
   /* validateNumber ensures the user must enter a number greater than or equal to 1
      @param x, number to be validated
      @return num, returns valid integer number */
      
   public int validateNumber(int x)
   {
      //declaring variables
      String s = "";
      int num = 0;   
      
      //Creating a new scanner object
      Scanner validNum = new Scanner(System.in);
      
      //verifying user enters an integer value greater than 0
      if(x < 1)
      {
         num = x;
         
         while(num < 1)
         {
            System.out.println("Please enter a number greater than or equal to 1.");
            
            try
            {
               s = validNum.next();
               num = Integer.parseInt(s);
            }    
            catch(Exception e)
            {   
               num = 0;
            }     
         }
         return num;
      }
      else
         return num = x;   
   }
   

   
}