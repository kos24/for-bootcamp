import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    // a target number entered by user
   private int firstNum; 

    /**
     * Default constructor for objects of class Solution
     */
    public Solution()
    {
        // initialising variable for the target number, by default equals to 0
        firstNum = 0;
        
    }
    
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */
    
    public static void main(String[] args)
    {
      //creating a new instance of the class and invoking enterNumbers method
      Solution mySolution = new Solution();
      mySolution.enterNumbers();
        
    }
    
    /**
     * Reading positive integers from the user and add them to the list
     */
     
    public void enterNumbers()
    {
        //clear screen
        System.out.print('\u000C');
        Scanner input = new Scanner(System.in);
        //assigning target number from the user.
        firstNum = numberPositive();
        //declaring and creating list of Integers
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean exit = false;
        int enteredNum = 0;
        System.out.println("Please enter any positive integers for the list using 'Enter' after each integer.");
        System.out.println("To finish input please enter any letter.");
        
        while (!exit)
        {
            if (input.hasNextInt())
            {
                enteredNum = input.nextInt();
                if (enteredNum >0)
                {
                   if (!list.contains(enteredNum))
                      list.add(enteredNum);
                }
                else 
                System.out.println ("Entered number should be positive");
            }
            else 
                exit = true;
        }
        
        //invoking method to check which numbers add up to target number
        matchNumbers(firstNum, list);     
    }
   
    /**
     * Check entered numbers and find pairs among them which sum is equal to the target number.
     * @param targetNum Target number entered by the user
     * @param newList List of positive integers entered by the user
     */
    
    public void matchNumbers(int targetNum, ArrayList<Integer> newList)
    {
      // declaring array of integers to store numbers which add up to the target number
      int[] tempPair;
      //declaring and creating collection which stores pairs of numbers which sum is equal to the target number
      ArrayList<int[]> targetList = new ArrayList<int[]>();
      
      for (int i = 0; i< newList.size();i++)
      {
          for (int j = i+1; j<newList.size();j++)
          {
              if ((newList.get(i) + newList.get(j)) == targetNum)
              {
              tempPair = new int[2];
              tempPair[0] = newList.get(i);
              tempPair[1] = newList.get(j);
              targetList.add(tempPair);
              }    
                 
          }
          
      }
      
      if (!targetList.isEmpty())
      {
          System.out.println("The following pairs of numbers add up to " + firstNum + " according to the given rules"); 
          for (int[] temp: targetList)
          {
              System.out.println(Arrays.toString(temp));
          }
      }
      else 
      {
          System.out.println("There are no pairs of numbers that add up to " + firstNum + " according to the given rules");
      }
      
    }
    
    /**
     * Check whether an entered number is numeric.
     * @return an entered numeric number.
     */
    public int numberNumeric()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter any positive integer");
        while (!console.hasNextInt())
        {
               console.next();
               System.out.println("Please enter a positive integer");
        }
        
        return console.nextInt();
    }
    
    /**
     * Check whether an entered number is positive.
     * @return an entered positive number.
     */
    public int numberPositive()
    {
        Scanner console = new Scanner(System.in);
        boolean positive = false;
        int num = numberNumeric();
        while (!positive)
        {
               if (num <= 0)
                   num = numberNumeric();
               else 
                   positive = true;               
        }
        return num;
        
    } 
    
    
}
