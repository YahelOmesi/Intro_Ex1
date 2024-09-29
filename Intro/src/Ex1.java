/** * The purpose of the code is to find the GPCD of two numbers.
        * In the algorithm we will check if there is a  common divisor (CD).
        * If there is CD we'll find the biggest prime cause of the CD and it will be the GPCD.
        * If there isn't CD that's mean that GPCD doesen't exist.
        **/
import java.util.Scanner;

public class Ex1
{
    public static void main(String[] args)
    {
        Scanner InputFromUser = new Scanner(System.in);
        System.out.println("Enter the first number for max prime GCD:");
        long f = InputFromUser.nextLong();
        //First number input
        System.out.println("Enter the second number for max prime GCD:");
        long g = InputFromUser.nextLong();
        //Second number input
        InputFromUser.close();
        long startTime = System.nanoTime();
        //Start measure runtime
        long min;
        min = Math.min(f, g);
        long j=min;
        long CD= -1;
        // CD cannot be equal to -1 that's how we know GPCD doesn't exist.
        long original_f=f;
        long original_g=g;
        // we keep the original f and g for the printing
        for (j=2; j<=min; j++)
        {
            // j is all dividers, will automatically skip non prime dividers because they were already passed before
            while (f%j == 0 && g%j == 0)
            //j is the CD of f and g
            {
                f= f/j;
                g= g/j;
                CD= j;
                // Save the result. Finally we will print the biggest CD=j because each time we override the smaller CD if was such.
                min = Math.min(f, g);
                //New minimum definition for the new f, g
            }
        }
        if (CD==-1)
        {
            System.out.println("Doesn't have GPCD");
        }
        else
        {
            System.out.println("The GPCD " + " (" + original_f+ "," +original_g + ")" + " = " +CD);
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("The runtime took: " + totalTime/1000 + " micro seconds.");
    }
}
