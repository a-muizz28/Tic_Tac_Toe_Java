import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    public static String[][] gameblock;

    public static void main(String[] args) {

        boolean playagain = true;

        while (playagain) {

        gameblock = new String[][]{{".", ".", "."}, {".", ".", "."}, {".", ".", "."}};
        // main menu
        int choice = 0;
        System.out.println("Welcome To Tic Tac Toe!");
        System.out.println("1.Single Player.");
        System.out.println("2.Multi Player.");

        while (true) {

            try {
                choice = input.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("You have entered the wrong number!");
                }
            } catch (InputMismatchException e) {
                System.out.println("You have entered the wrong input, please enter a correct value!");
                input.next(); // clear invalid input
            }

        }

        switch (choice) {
            case 1:
                // for single player game
                String name = "Player 1";
                input.nextLine(); // clears new line character
                String[] player_tosses1 = chooseSign(name);
                gridDisplaySinglePlayer(gameblock, player_tosses1);

                break;
            case 2:
                // for multiplayer game
                String[] player_tosses2 = multiPlayerToss();
                gridDisplayMultiplayer(gameblock, player_tosses2);
                break;

            default:

                System.out.println("Choice out of bounds!");
                break;

        }

            // Ask the user if they want to play again
            System.out.println("Do you want to play again? (y/n): ");
            String response = input.next().toLowerCase();
            if (!response.equals("y")) {
                playagain = false;
            }

    }
        System.out.println("Thanks For Playing! Bye ");
}


    // function to return toss results if multiplayer game
    public static String [] multiPlayerToss(){

        String [] toss = {"heads", "tails"} ;
        String toss_one = "h" , toss_two  = "t"; // garbage values necessary for the check
        input.nextLine(); // clears new line character

        System.out.println("Player One select Heads or Tails: ");
        while (true) {

            toss_one = input.nextLine().toLowerCase();
            if (toss_one.equals("heads") || toss_one.equals("tails")) {
                break;
            } else {
                System.out.println("Wrong Input! Please enter 'heads' or 'tails'.");
            }

        }
        while (true) {

            toss_two = input.nextLine().toLowerCase();
            if (toss_two.equals("heads") || toss_two.equals("tails")) {
                break;
            } else {
                System.out.println("Wrong Input! Please enter 'heads' or 'tails'.");
            }

        }

        int choice = rand.nextInt(2); // random function to choose heads or tails
        String toss_selected = toss[choice];

        if (toss_selected.equals(toss_one)){

            System.out.println("Player 1 has won the toss!:Its  " + toss_selected);
            String name = "Player 1" ;
            String [] player_tosses = chooseSign(name); // asks the winner to choose a sign
            return player_tosses ;

        }else{

            System.out.println("Player 2 has won the toss!:Its  " + toss_selected);
            String name = "Player 2" ;
            String [] player_tosses = chooseSign(name);
            return player_tosses ;

        }


    }
    // function to return the signs selected by the players
    public static String [] chooseSign( String name ){

        String [] signs = {"X" , "O"} ;
        String [] player_tosses = new String [3] ;
        String sign = "D";

        System.out.printf("Choose your sign X or O: %s",name);
        System.out.println();

        while (true) {

            sign = input.nextLine().toUpperCase();
            if (sign.equals("X") || sign.equals("O")) {

                if (name.equals("Player 1")) { // chooses the sign specified by player 1

                    player_tosses[0] = sign;
                    player_tosses[1] = sign.equals("X") ? "O" : "X"; // assigns remaining sign to other player

                } else { // chooses the sign specified by player 2

                    player_tosses[1] = sign;
                    player_tosses[0] = sign.equals("X") ? "O" : "X";

                }
                player_tosses[2] = name;
                break;

            } else {
                System.out.println("Wrong sign chosen! Please enter 'X' or 'O'.");
            }
        }
        return player_tosses;
    }

    public static void gridDisplayMultiplayer( String [][] gameblock , String [] player_tosses) { // function to display grid for multiplayer allowing two user inputs
        int count = 1;

        while (!winnerCheck(gameblock,player_tosses)) {

            if(count > 9){ // breaks the loop if the game results in a draw
                String winner = "D" ;
                winnerDisplayer( winner , player_tosses );
                break;
            }

            for (int i = 0; i < gameblock.length; i++) {
                for (int k = 0; k < gameblock[i].length; k++) {
                    System.out.print("  " + gameblock[i][k] + "  ");
                    if (k < gameblock[i].length - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                System.out.print("-----+-----+-----");
                System.out.println();
            }
            if (count % 2 != 0) {

                int [] index_1 ;
                Boolean taken  = false ;

                while (!taken){

                    System.out.println("Enter number from 1 to 9 in order to insert your sign, First Player:  "); // Takes the index of the block where the sign needs to be added
                    int index = input.nextInt();
                    index_1 = indexReturner(index);

                    if (gameblock[index_1[0]][index_1[1]] == ".") { // updates the block in grid only if the block has the following character

                        if (player_tosses[2].equals("Player 1")) {

                            gameblock[index_1[0]][index_1[1]] = player_tosses[0]; // updates the block with the sign of the first user
                            taken = true ;

                        } else {

                            gameblock[index_1[0]][index_1[1]] = player_tosses[1];
                            taken = true ;

                        }

                    } else {

                        System.out.println("Block Already Taken!");


                    }
                }

            } else {
                int [] index_2 ;
                boolean taken = false ;

                while(!taken){

                    System.out.println("Enter number from 1 to 9 in order to insert your sign, Second Player:  ");
                    int index2 = input.nextInt();
                    index_2 = indexReturner(index2);

                    if(gameblock[index_2[0]][index_2[1]] == ".") {

                        if (player_tosses[2].equals("Player 1")) {

                            gameblock[index_2[0]][index_2[1]] = player_tosses[1]; // updates the block with respective sign of the first user
                            taken = true ;

                        } else {

                            gameblock[index_2[0]][index_2[1]] = player_tosses[0];
                            taken = true ;

                        }
                    }else{

                        System.out.println("Block Already Taken!");

                    }
                }
            }


            if (winnerCheck(gameblock,player_tosses)) {
                break;
            }

            count++;

        }


    }
    public static void gridDisplaySinglePlayer(String [][] gameblock , String [] player_tosses){ // displays grid for single player allowing one user input
        int count = 1;

        while (!winnerCheck(gameblock,player_tosses)) {

            if(count > 9){ // breaks the loop if the game results in a draw
                String winner = "D" ;
                winnerDisplayer( winner , player_tosses );
                break;
            }

            for (int i = 0; i < gameblock.length; i++) {
                for (int k = 0; k < gameblock[i].length; k++) {
                    System.out.print("  " + gameblock[i][k] + "  "); // grid display
                    if (k < gameblock[i].length - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                System.out.print("-----+-----+-----");
                System.out.println();
            }
            if (count % 2 != 0) {

                int [] index_1 ;
                Boolean taken  = false ;

                while (!taken){

                    System.out.println("Enter number from 1 to 9 in order to insert your sign, First Player:  ");
                    int index = input.nextInt();
                    index_1 = indexReturner(index);

                    if (gameblock[index_1[0]][index_1[1]] == ".") { // updates the block in grid only if the block has the following character

                        if (player_tosses[2].equals("Player 1")) {

                            gameblock[index_1[0]][index_1[1]] = player_tosses[0]; // updates the users sign in the grid
                            taken = true ;

                        } else {

                            gameblock[index_1[0]][index_1[1]] = player_tosses[1];
                            taken = true ;

                        }

                    } else {

                        System.out.println("Block Already Taken!");


                    }
                }

            } else {
                int [] index_2 ;
                boolean taken = false ;

                while(!taken){

                    int index2 = rand.nextInt(1,10) ; // computer generated indexes for automatic input
                    index_2 = indexReturner(index2);

                    if(gameblock[index_2[0]][index_2[1]] == ".") {

                        if (player_tosses[2].equals("Player 1")) {

                            gameblock[index_2[0]][index_2[1]] = player_tosses[1];
                            taken = true ;

                        } else {

                            gameblock[index_2[0]][index_2[1]] = player_tosses[0];
                            taken = true ;

                        }
                    }
                }
            }
            
            if (winnerCheck(gameblock,player_tosses)) {
                break;
            }

            count++;



        }

    }
    public static boolean winnerCheck(String [][] gameblock , String [] player_tosses){ // function to check winners based on the values in the array

        if (gameblock[0][0] == gameblock[0][1] && gameblock[0][1] == gameblock[0][2] && gameblock[0][0] != "."){ // 1st

            winnerDisplayer(gameblock[0][0],player_tosses);
            return true ;

        }
        if (gameblock[1][0] == gameblock[1][1] && gameblock[1][1] == gameblock[0][2] && gameblock[1][0] != "."){ // 1st 2nd 3rd if's checks row wise in the grid

            winnerDisplayer(gameblock[1][0],player_tosses);
            return true ;

        }
        if(gameblock[2][0] == gameblock[2][1] && gameblock[2][1] == gameblock[2][2] && gameblock[2][0] != "."){ // 3rd

            winnerDisplayer(gameblock[2][0],player_tosses);
            return true ;

        }
        if(gameblock[0][0] == gameblock[1][0] && gameblock[1][0] == gameblock[2][0] && gameblock[0][0] != "."){ //4th

            winnerDisplayer(gameblock[0][0],player_tosses);
            return true ;

        }
        if(gameblock[0][1] == gameblock[1][1] && gameblock[1][1] == gameblock[2][1] && gameblock[0][1] != "."){ // 4th 5th 6th if's checks column wise in the grid

            winnerDisplayer(gameblock[0][1],player_tosses);
            return true ;

        }
        if(gameblock[0][2] == gameblock[1][2] && gameblock[1][2] == gameblock[2][2] && gameblock[0][2] != "."){ // 6th

            winnerDisplayer(gameblock[0][2],player_tosses);
            return true ;

        }
        if(gameblock[0][0] == gameblock[1][1] && gameblock[1][1] == gameblock[2][2] && gameblock[0][0] != "."){ // 7th

            winnerDisplayer(gameblock[0][0],player_tosses);
            return true ;

        }
        if(gameblock[0][2] == gameblock[1][1] && gameblock[1][1] == gameblock[2][0] && gameblock[0][2] != "."){ // 7th 8th if's checks diagonally in the grid

            winnerDisplayer(gameblock[0][2],player_tosses);
            return true ;

        }else{

            return false ;

        }
    }
    // function to return indexes based on the number entered by the user
    public static int [] indexReturner(int index){
        int [] indexes = new int[2] ;

        if (index == 1 || index == 2 || index == 3){ // row 1

            indexes[0] = 0 ;
            indexes[1] = index - 1 ;
        }
        if (index == 4 || index == 5 || index == 6){ // row 2

            indexes[0] = 1 ;
            indexes[1] = index - 4 ;
        }
        if (index == 7 || index == 8 || index == 9){ // row 3

            indexes[0] = 2 ;
            indexes[1] = index - 7 ;
        }
        return indexes ;
    }
    // function to display winner based on the result from winnerCheck function
    public static void winnerDisplayer( String winner , String [] player_tosses){

        if(winner == player_tosses[0]){
            System.out.printf("Congratulations! Player-%d you have won and their sign was %s!",1,player_tosses[0]);
            System.out.println();
      }
        if(winner == player_tosses[1]){

          System.out.printf("Congratulations! Player-%d you have won and their sign was %s!",2,player_tosses[1]);
          System.out.println();
      }
        if(winner == "D"){
            System.out.println("The match was a draw!");
        }
      for(int i = 0 ; i < gameblock.length ; i++){ // displays the grid one last time after someone has won
          for(int k = 0 ; k < gameblock[i].length ; k++){
              System.out.print("  " + gameblock[i][k] + "  ");
              if (k < gameblock[i].length - 1) {
                  System.out.print("|");
              }
          }
          System.out.println();
          System.out.print("-----+-----+-----");
          System.out.println();
      }

    }

}
