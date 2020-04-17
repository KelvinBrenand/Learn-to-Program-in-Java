/**
 * Created by Kelvin Brenand on 15/04/2020.
 */

import java.util.Scanner;

public class Assessment {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        greeting(input);
        travelTimeAndBudget(input);
        timeDifference(input);
        countryArea(input);
        howFar(input);

    }

    public static void greeting(Scanner input){

        System.out.println("Welcome to Vacation Planner!");

        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = input.nextLine();

        System.out.println("Great! " + destination + " sounds like a great trip.");

        System.out.println("**********\n");
    }

    public static void travelTimeAndBudget(Scanner input){

        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();

        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();

        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();

        System.out.print("How many " + currency + " are there in 1 USD? ");
        double conversion = input.nextDouble();

        System.out.println("\nIf you are travelling for " + days + " days that is the same as " + days*24 +
                " hours or " + days*24*60 + " minutes.");
        int k = (int) ((money/days)*100);
        double spendPerDay = k/100.0;
        System.out.println("If you are going to spend " + money + " USD that means per day you can spend up to $"
                + spendPerDay + " USD.");

        int x = (int) (money*conversion*100);
        double moneyAfterConverted = x/100.0;

        int z = (int) ((moneyAfterConverted/days)*100);
        double moneyAfterConvertedPerDay = z/100.0;
        System.out.println("Your total budget in " + currency + " is " + moneyAfterConverted + " "
                + currency + ", which per day is " + moneyAfterConvertedPerDay + " " + currency + ".");

        System.out.println("**********\n");

    }

    public static void timeDifference(Scanner input) {

        System.out.print("What is the time difference, in hours, between your home and your destination? ");

        int timeDifference = input.nextInt();
        System.out.println("That means that when it is midnight at home it will be " + Math.abs(timeDifference) +
                ":00 in your travel destination");
        System.out.println("and when is noon at home it will be " + ((12 + timeDifference)%24) + ":00.");

        System.out.println("**********\n");
    }

    public static void countryArea(Scanner input){

        System.out.print("What is the square area of your destination country in km2? ");

        int countryAreaKm2 = input.nextInt();
        int y = (int) ((countryAreaKm2/2.59)*100);
        double countryAreaMiles2 = y/100.0;

        System.out.println("In miles2 that is " + countryAreaMiles2 + ".");
        System.out.println("**********\n\n");
    }

    public static void howFar(Scanner input){

    System.out.println("What is the latitude and longitude of your home and your travel destination?");

    double lat1 = input.nextDouble();
    double lon1 = input.nextDouble();
    double lat2 = input.nextDouble();
    double lon2 = input.nextDouble();

    System.out.println("The distance between your home and your travel destination is " +
            distance(lat1, lon1, lat2, lon2) + "km.");

    }

    public static double distance(double lat1, double lon1, double lat2, double lon2){

        int R = 6371; // Radius of the earth in km
        var dLat = (lat2-lat1)*(Math.PI/180);
        var dLon = (lon2-lon1)*(Math.PI/180);
        var a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos((Math.PI/180)*(lat1))
                * Math.cos((Math.PI/180)*(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        int z = (int) (R*c*100);
        double d = z/100.0;

        return d;
    }
}
