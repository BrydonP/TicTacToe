package tictactoe;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Brydon 2nd PC commit start enum
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
        Scanner userInput = new Scanner(System.in);
        boolean placed = false;
        String move;

        //Intro
        System.out.println("Welcome to TicTacToe!");
        System.out.println("To play, enter the grid coordinate of your move "
                + "ie top left is 0,0, bottom right is 2,2");
        System.out.println("X's go first!");

        while(gameOver == false){
            System.out.print("Enter you grid: ");
            placed = false;
            while(placed == false){
                move = userInput.next();

                //Seperate
                posX = Character.getNumericValue(move.charAt(0));
                posY = Character.getNumericValue(move.charAt(2));

                //Try to place peice, repeat if piece is placed already
                placed = grid.setPiece(posX, posY, turn);
                if(placed == false){
                    System.out.println("There is already a piece there! Choose again!");
                    grid.printBoard();
                }else{
                    placed = true; //Piece succesfully placed
                }
            }
            grid.printBoard(); //Print board
            if(turn == 1){//Swap Player
                turn = 0;
                System.out.println("It's O's Turn!");
            }else{
                turn = 1;
                System.out.println("It's X's Turn!");
            }
            if(checkWinner(grid) != -1){
                gameOver = true;
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
