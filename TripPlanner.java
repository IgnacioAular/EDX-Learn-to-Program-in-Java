/*
 * Copyleft 2018, 2037, SERECOM 2018 Aular. Without rights reserved.
 * EVERYONE IS PROPRIETARY/NOT CONFIDENTIAL. Use is NOT subject to
 * license terms
 */

package firstproject;

import java.util.Scanner;

/**
 * <H1>Trip Planner</H1>
 *
 * <p>
 * Program that asks the user for some information
 * about an international trip they are taking.
 * Based on that information we will need to do some
 * conversions, using the correct data types, to tell
 * them some information to help them plan their trip.
 * </p>
 *
 * <p>
 * The class {@code TripPlanner} includes methods for get
 * strings of characters, integer and double values from
 * the keyboard implemented through {@code Scanner} class
 * and its {@code nextLine}, {@code nexInt} and {@code nextDouble}
 * methods, and to present double values with two decimals
 * use the (@code round) method.
 * </p>
 *
 * @author  Ignacio Aular
 * @see     java.util.Scanner#nextLine()
 * @see     java.util.Scanner#nextInt()
 * @see     java.util.Scanner#nextDouble()
 * @since   09/02/2018
 */

public class TripPlanner
{
    /** A day have 24 hours  */
    private static final int HOURS_PER_DAY = 24;

    /** An hour have 60 minutes */
    private static final int MINUTES_PER_HOUR = 60;

    /** To multiply and divide a double value to eliminate some decimals of the original result */
    private static final double ONE_HUNDRED = 100.0;

    /** To do some calculate and get the miles from any value */
    private static final double CONVERSION_FACTOR_PER_MILES = 2.59;


    /**
     * Common public static utility method used to call some
     * methods or statements to do some tasks
     */
    public static void main(String[] args)
    {
        greeting();
        travelTimeAndBudget();
        timeDifference();
        countryArea();
    }

    /** Ask the name and greet to the user */
    private static void greeting()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Vacation Planner!");

        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("Nice to meet you " + name + ", Where are you travelling to? ");
        String destine = input.nextLine();

        System.out.println("Great! " + destine + " sounds like a great trip");

        separator();
    }

    /**
     * Ask the user about how much time and money they are budgeting for their trip
     * to tell the user the following information:
     *
     * 1.- How much time the user will spend at their destination in days, hours,
     *     minutes and seconds.
     * 2.- Show the user their budget in USD for the whole trip and how much they
     *     can spend in USD per day.
     * 3.- Show the user their budget in the travel destination’s currency for the total
     *     trip and per day
     */
    private static void travelTimeAndBudget()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many days are you going to spend travelling? ");
        int daysTravelling = input.nextInt();

        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double totalMoneyForTheTripInUSD = input.nextDouble();

        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currencySymbol = input.next().toUpperCase();

        System.out.print("How many " + currencySymbol + " are there in 1 USD? ");
        double conversionRate = input.nextDouble();

        int hoursInDaysTravelling = daysTravelling * HOURS_PER_DAY; // HOURS = 24
        int minutesInHoursPerDaysTravelling = hoursInDaysTravelling * MINUTES_PER_HOUR; // MINUTES = 60

        System.out.println("\n");

        System.out.println("If you are travelling for " + daysTravelling +
                " days that is the same as " +  hoursInDaysTravelling +
                " hours or " + minutesInHoursPerDaysTravelling + " minutes");

        double moneyToSpendPerDay = totalMoneyForTheTripInUSD / daysTravelling;

        System.out.println("If you are going to spend $" + totalMoneyForTheTripInUSD +
                " USD that means per day you can spend up to $" +
                round(moneyToSpendPerDay) + " USD");

        double totalBudget = totalMoneyForTheTripInUSD * conversionRate;
        double totalBudgetPerDay = totalBudget / daysTravelling;

        System.out.println("Your total budget in " + currencySymbol + " is " + totalBudget +
                " " + currencySymbol + ", which per day is " + round(totalBudgetPerDay) +
                " " + currencySymbol);

        separator();
    }

    /**
     * Ask the user about the time difference between their home and where they are going.
     * If the destination time zone is “behind” the user’s home time zone the user should
     * enter a negative number. For example, the time difference between Seattle and
     * Nairobi is 9 hours, and the time difference between New York and Mexico City
     * is -1 hours.
     *
     * Show the time it will be in the travel destination when it is midnight at home and
     * when it is noon at home. You can report these in 24 format, where midnight is 0:00
     * and noon is 12:00.
     */
    public static void timeDifference()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the time difference, in hours, between your home and " +
                "your destination? ");
        int timeDifferenceInHour = input.nextInt();

        System.out.print("That means that when it is midnight at home it will be ");
        System.out.println(((timeDifferenceInHour + 24) % 24) + ":00 in your travel destination ");
        System.out.println("and when it is noon at home it will be " +
                ((timeDifferenceInHour + 12) % 24) + ":00");

        separator();
    }

    /**
     * Ask the user the area of their travel destination country in km^2^.
     * Then it convert that to miles^2^ and report those results
     * back to the user.
     */
    public static void countryArea()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the square area of your destination country in km2? ");
        double squareAreaDestinationCountry = input.nextDouble();

        double milesAreaDestinationCountry = squareAreaDestinationCountry
                / CONVERSION_FACTOR_PER_MILES;

        System.out.println("In miles2 that is " + round(milesAreaDestinationCountry));

        separator();
    }

    /**
     * Some of our math has produced numbers with lots of decimal places,
     * making then not look very nice. This method clean up those answers
     * so they each only have 2 decimal places.
     *
     * @param numberWithLargeDecimalPart
     * @return double
     */
    public static double round(double numberWithLargeDecimalPart)
    {
        int numberWithExtendedWholePart = (int)(numberWithLargeDecimalPart * ONE_HUNDRED);
        return (numberWithExtendedWholePart / ONE_HUNDRED);
    }

    /**
     * Utility method to print a string of asteriscs as separator
     * between paragraphs and produce two jumps of line
     */
    public static void separator()
    {
        System.out.println("***********");
        System.out.println("\n");
    }
}
