package math;

class Math {

    public static void main(String[] args) {

    //Use the // to create single line comments to either add info or to take out code for debugging

    System.out.println("Hello world!");

    //We will be using System.out.println and System.out.print throughout the year. Try using both below to see what the difference is!






    //ANSWER:



    //Throughout the year this year we will need to store information. For that we will be using VARIABLES!

    //Java is an Object-Oriented programming language. All variables we use this year will either be OBJECTS or PRIMITIVES

    //There are 8 primitives in Java: int, byte, short, long, float, double, boolean, char

    //For AP we need to know: int, double, boolean

    //List examples of the types below and give definition
    //int (integer):
    //double:
    //boolean:

    //For now we are just going to work with primitive

    //Create 3 variables of each of the above types (USE GOOD CODING PRACTICE WHEN CREATING THE VARIABLES
/* 
    int i = 1;
    double hi = 8.75;
    boolean isHi = true;
*/


    //MATH TIME!

    //What are the math operators that we can use?
    //+ - * / %

    //Try doing some math operations with numbers. How can we check to see if the math worked?
    System.out.println(5*5%2);
    System.out.println(3/3*2);
    //Create codes that will print the following:

    //Odd integers from 1 to 100, inclusive of both
      System.out.print("Printing odd numbers:");
      for (int ii = 1; ii <= 100; ii++) {
            if (ii % 2 != 0) { //Checking if the number is odd (remainder is not 0 when divided by 2)
                System.out.println(ii); //printint if above statement is true
            }
          }
      
      System.out.println("Printing multpiles of 3:");
    //All multiples of 3 from 1 to 100
      for (int m = 1; m <= 100; m++) { //setting inteer value 1 to m and m should always be less than or equal to 100 and every time it iterates, it increases by 1
        if (m % 3 == 0) { //using modulus operator to see if the remainder is = 0
          System.out.println(m); //printing m if the statement above is true
        }
      }


    //Starting at 1000, print on the same line (with a - [hypthen] between each) all of the numbers that end in 0 going down to 0
    System.out.print("Printing all numbers that end with a 0: ");
    for (int d = 1000; d >= 0; d--) { //setting te integer "d" to 1000 and iterated until it is hitting 0, reduces the 1000 by 1 ever time it iterates
      if (d % 10 == 0) {      //using modulus operator to find the remainder and since any number that ends with a 0 divided by 0 should have a remainder of 0
        System.out.print(" - " + d);  //printing the final integer value of the variable d wth a hyphen before it
      }
    }
  }
}
