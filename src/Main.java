import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        //int index = rnd.nextInt(myArray.length);  //gives a random valid index on myArray

       // a.	Declare an array of type int named dataPoints.
                //dataPoints should have a length of 100. (i.e. it should hold 100 int values.)
        int[] dataPoints = new int [100];
        //b.	Now, code a regular for loop that iterates through the dataPoints array and
        // initializes each element in it to a random value between 1 and 100.
        //(See notes above for using java.util.Random. Please do not use Math.Random!)
        for (int i = 0; i < 100; i++){
            dataPoints[i] = rnd.nextInt(100) + 1;
        }
       //c.	Code a second loop that displays the dataPoints values like this
        // (values are all on the same line and separated by “ | “ e.g. space, vertical bar, space):
        //val1 | val2 | val3 |  HINT: use printf or System.out.print()
        for (int i = 0; i < 100; i++){
            System.out.print(dataPoints[i] + " | ");
        }
        System.out.print("\n");
        //d.	Now code a loop that calculates the sum and the average of the values in dataPoints.
        // Add code to output/display the sum and the calculated average.
        // (Be sure to include some sort of description in the output so it is clear
        // (i.e. use complete sentences) : ‘The average of the random array dataPoints is:
        // ‘ or something similar.  Don’t just print out the average and sum as a raw numbers.
        // (Do this for all the output here… just  like you should in every  program you code!)

        int sum = 0;
        for (int i = 0; i < 100; i++){
            sum += dataPoints[i];
        }
        float avg = sum/100;
        System.out.println("The sum of dataPoints is " + sum + " and the average is " + avg + ".");



        //2.	Linear scan (search): (10pts)
        //a.	Add code to prompt and input an int value between 1 and 100 from the user.
        // (Use your static getRangedInt(…) method from SafeInput from the last lab here!
        // Just include your SafeInput.java  Library. file in yourIntelliJ project and access
        // your bullet-proofed input methods there.   SafeInput.getRangedInt(…)
        Scanner in = new Scanner(System.in);
        int value = SafeInput.getRangedInt(in,"Please enter an int value", 1, 100);

        //b.	Code a loop that iterates through the entire dataPoints array and
        // counts how many times the user’s value is found within the array.
        // Indicate with a clear output statement how many times the loop
        // found the user’s value within the array.
        int count = 0;
        for (int i = 0; i < 100; i++){
            if (value == dataPoints[i]){
                count++;
            }
        }

        System.out.println(value + " was found " + count + " time(s) within the dataPoints array");

        //c.	Prompt the user again for a val between 1 and 100.
        //Code a loop that iterates through the dataPoints array checking
        // each value to see if it matches the one the user input.
        // This loop should short circuit (break) when it finds the value
        // and display the first position of the value within the array.
        // Again, make the output clear and explicit here.
        // (e.g. “The value VALUE was found at array index POSITION”
        // where VALUE is the user’s value you input and POSITION is the location (index)
        // where the value is found in the array.
        // If the value is not in the array, then the output statement should indicate that.
        // Note you can use the break keyword to jump out of a loop before it completes.
        // The problem here is that you have to keep track of whether or not the value was found at all.

        int checkLoc = SafeInput.getRangedInt(in,"Please enter an int value", 1, 100);
        boolean found = false;
        int location = 0;
        for (int i = 0; i < 100; i++){
            if (checkLoc == dataPoints[i]){
                found = true;
                location = i;
                break;
            }
        }

        if (found){
            System.out.println(checkLoc + " was found in dataPoints at location " + location);
        } else {
            System.out.println(checkLoc + " was not found in dataPoints.");
        }

        //d.	Write a loop to scan for the minimum and maximum values in the dataPoints array.
        // Display these values to the user.
        // (Note that these might not be unique,
        // there might be several occurrences of either the min or the max value in the random array.)
        // Hint: you can assume initially that the first element is
        // the min and max and iterate through the rest of the array
        // to determine if there is a lower or higher value which then becomes the min or max respectively.
        // You can also write a single loop that determines both the min and the max at the same time.

        int max = 1;
        int min = 100;
        for (int i = 0; i < 100; i++){
            if (dataPoints[i] > max){
                max = dataPoints[i];
            }
            if (dataPoints [i] < min){
                min = dataPoints[i];
            }
        }
        System.out.println("The maximum value in dataPoints is " + max + " and the minimum value is " + min);

        //e.	Write this static method which takes an array of double values
        // and returns the average and test it.
        // Remember static methods go in the main java class file
        // immediately after the main method.

        //public static double getAverage(int values[])
       // {
        //}
        //In your main code call it like this:

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

    }

    public static double getAverage(int values[])
    {
        double sum = 0;
        for (int i = 0; i < values.length; i++){
            sum += values[i];
        }
        return sum/values.length;
    }
}