package tictactoe;

import java.util.Scanner;

/**
 *
 * @author Brydon 2nd PC commit
 */
public class TicTacToe{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Grid grid = new Grid();
        int posX;
        int posY;
        boolean gameOver = false;
        int turn = 1; //1 = X's, 0 = O's

        //Intro
        System.out.println("Welcome to TicTacToe!");
        System.out.println("To play, enter the grid coordinate of your move "
                + "ie top left is 0,0, bottom right is 2,2");
        System.out.println("X's go first!");

        Scanner userInput = new Scanner(System.in);

        while(gameOver == false){
            System.out.print("Enter you grid: ");
            String move = userInput.next();

            //Seperate
            posX = (int) move.charAt(0);
            posY = (int) move.charAt(2);

            //Try toi place peice, repeat piece is placed already
            boolean placed = false;
            while(placed = false){
                if(grid.setPiece(posX, posY, turn) == false){
                    System.out.println("There is already a piece there! Choose again!");
                }else{
                    placed = true; //Piece succesfully placed
                }
            }
            grid.printBoard(); //Print board
            if(checkWinner(grid) != -1){

            }
        }
    }

    public static int checkWinner(Grid grid){
        int winner = -1;
        winner = grid.checkForWinner();// Check for a winner
        if(winner == 1){
            System.out.println("X has Won!");
        }else if(winner == 0){
            System.out.println("O has Won!");
        }
        return winner;
    }

}
