import java.util.*;

public class MazeRunner {
    public static void main(String[] args){
        Maze myMap = new Maze();
        intro(myMap);
        int moves = 0;

        while (true){
            userMove(myMap);
            moves++;
            movesMessage(moves);

            if (myMap.didIWin()){
                System.out.println("Congratulations, you made it out alive!");
                System.out.println("And you did it in " + moves + " moves.");
                break;
            }
        }
    }
    public static void intro(Maze myMap){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static void userMove(Maze myMap){
        Scanner input = new Scanner(System.in);
        String aux;
        do {
            System.out.print("\nWhere would you like to move? (R, L, U, D) ");
            aux = input.next();
            aux = aux.toUpperCase();
        } while (!aux.equalsIgnoreCase("R") && !aux.equalsIgnoreCase("L") &&
                !aux.equalsIgnoreCase("U") && !aux.equalsIgnoreCase("D"));

        switch (aux) {
            case "R":
                if (myMap.canIMoveRight()) {
                    myMap.moveRight();
                } else {
                    navigatePit(myMap, aux);
                }
                myMap.printMap();
                break;
            case "L":
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                } else {
                    navigatePit(myMap, aux);
                }
                myMap.printMap();
                break;
            case "U":
                if (myMap.canIMoveUp()) {
                    myMap.moveUp();
                } else {
                    navigatePit(myMap, aux);
                }
                myMap.printMap();
                break;
            case "D":
                if (myMap.canIMoveDown()) {
                    myMap.moveDown();
                } else {
                    navigatePit(myMap, aux);
                }
                myMap.printMap();
                break;
        }
    }

    public static void movesMessage(int moves){
        if (moves == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }else if (moves == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }else if (moves == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }else if (moves == 100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time- you lose!");
            System.out.println("\n\n\n\n\n\"I see... only... darkness.. before... me.\"");
            System.exit(0);
        }
    }

    public static void navigatePit(Maze myMap, String direction){
        Scanner input = new Scanner(System.in);
        if (myMap.isThereAPit(direction)){
            System.out.print("Watch out! There's a pit ahead, jump it? ");
            String decision = input.next();
            if (decision.toUpperCase().startsWith("Y")){
                myMap.jumpOverPit(direction);
            }
        }else {
            System.out.println("Sorry, you’ve hit a wall.");
        }
    }
}