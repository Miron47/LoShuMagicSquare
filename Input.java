/* Miron Smierzewski
   5/2/2022
This interface specifies that there must be a method named validateNumber that excepts an integer value as a parameter and returns and integer,
and a method named getInput that excepts an integer value as a parameter and returns a 2D array. */

interface Input {
   int validateNumber(int x);
   int[][] getInput(int x);
}