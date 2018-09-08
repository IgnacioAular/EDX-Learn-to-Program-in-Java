/*
 * Copyleft 2018, 2037, SERECOM 2018 Aular. Without rights reserved.
 * EVERYONE IS PROPRIETARY/NOT CONFIDENTIAL. Use is NOT subject to
 * license terms..
 */

package firstproject;

import java.util.Scanner;
import java.util.Random;

/**
 * <H1>Odds or Evens</H1>
 *
 * <p>
 * For this project you are going to program a game called "Odds and Evens".
 * The game is similar to rock paper scissors. It is played between two players,
 * in your version it will be you versus the computer. Each player will choose
 * either "odds" or "evens", since you’re playing the computer you will get
 * first pick. Once you have chosen your side, you each choose a number of fingers
 * to play- 0 to 5. The winner is determined by whether the sum of your fingers is
 * odd or even (depending on what you chose).
 * </p>
 *
 * <p>
 * For example, let’s say you choose "evens". That means the computer gets "odds".
 * You choose to play 2 fingers and the computer plays 3. 2 + 3 = 5, which is odd
 * so the computer wins.
 * </p>
 *
 * @author  Ignacio Aular
 * @see     java.util.Scanner#nextLine()
 * @see     java.util.Scanner#next()
 * @see     java.util.Scanner#nextInt()
 * @see     java.util.Scanner#nextDouble()
 * @see     java.util.Random#nextInt()
 * @since   09/07/2018
 */

public class OddsAndEvens
{
    /**
     * Common public static utility method used to call some
     * statements to do some tasks
     */
    public static void main(String[] args)
    {
        // Part One: Intro

        /* Take in the users name, odds or evens */

        Scanner input = new Scanner(System.in);

        System.out.println("Let's play a game called \"Odds and Evens\"");

        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String userChoice = "" + input.next().charAt(0); // get only the first character

        if ( userChoice.equalsIgnoreCase("O") ) // user selected Odds
        {
            System.out.println(name + " has picked odds! The computer will be evens.");
        }
        else if ( userChoice.equalsIgnoreCase("E") ) // user selected Evens
        {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        else
        {
            System.out.println("I'm sorry. You must enter O or E");
        }

        separator();

        // Part Two: Randomizer

        /*
         * Takes in the number of "fingers" the user would like to play,
         * and uses the random generator to decide what the computer will play
         */
        System.out.print("\n\nHow many \"fingers\" do you put out? ");
        int userFingers = input.nextInt();

        Random rand = new Random();
        int computerFingers = rand.nextInt(6);

        // Part Three: Sum

        /*
         * Adds the two integers together and produces the sum
         */
        int sumTotalFingers = userFingers + computerFingers;

        System.out.println("The computer plays " + computerFingers + " \"fingers\"");

        separator();

        System.out.println("\n\n" + userFingers + " + " + computerFingers + " = " + sumTotalFingers);

        // Part Four: Who wins

        /*
         * Decided whether the final answer is even or odd, and declares a winner.
         */
        boolean isEven = ( (sumTotalFingers % 2) == 0);

        if (isEven)
        {
            System.out.println(sumTotalFingers + " is ...even!");

            if (userChoice.equalsIgnoreCase("E"))
            {
                System.out.println("That means " + name + " wins! :)");
            }
            else
            {
                System.out.println("That means computer wins! :)");
            }
        }
        else
        {
            System.out.println(sumTotalFingers + " is ...odd!");
            
            if (userChoice.equalsIgnoreCase("O"))
            {
                System.out.println("That means " + name + " wins! :)");
            }
            else
            {
                System.out.println("That means computer wins! :)");
            }
        }

        separator();
    }

    /**
     * Utility method to print a string of asteriscs as separator
     * between paragraphs and produce two jumps of line
     */
    private static void separator()
    {
        for (int i = 0; i < 60; i++)
        {
            System.out.print("-");
        }
    }
}
