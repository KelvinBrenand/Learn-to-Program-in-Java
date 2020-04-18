import java.util.*;
public class OddsAndEvens {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("\nLet’s play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String option = input.next();

        if (option.equalsIgnoreCase("O")){
            System.out.println(name + " has picked odds! The computer will be evens.");
        }else {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        System.out.println("------------------------------------\n");

        game(input, name, option);

    }

    public static void game(Scanner input, String name, String option){
        System.out.print("How many “fingers” do you put out? ");
        int playerFingers;

        while (true){
            playerFingers = input.nextInt();
            if ( (playerFingers < 0) || (playerFingers > 5) ){
                System.out.println("Invalid number. Please, choose a number between 0 and 5, inclusive.");
            }else{
                break;
            }
        }

        Random rand = new Random();
        int computerFingers = rand.nextInt(6);

        System.out.println("The computer plays " + computerFingers + " \"fingers\".");
        System.out.println("------------------------------------\n");

        int sum = playerFingers + computerFingers;

        System.out.println( playerFingers + " + " + computerFingers + " = " + sum);

        if (sum%2 == 0){
            System.out.println(sum + " is ... even!");
            if(option.equalsIgnoreCase("E")){
                System.out.println("That means " + name + " wins! :)");
            }else{
                System.out.println("That means Computer wins! :)");
            }
        }else{
            System.out.println(sum + " is ... odd!");
            if(option.equalsIgnoreCase("E")){
                System.out.println("That means Computer wins! :)");
            }else{
                System.out.println("That means " + name + " wins! :)");
            }
        }

        System.out.print("------------------------------------");
    }
}