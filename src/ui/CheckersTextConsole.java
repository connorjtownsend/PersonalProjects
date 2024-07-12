package ui;

import java.util.Scanner;

import core.CheckersLogic;
import javafx.application.Application;
import core.CheckersComputerPlayer;


public class CheckersTextConsole {
    /**Scanner to receive input from players*/
    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static Scanner sc3 = new Scanner(System.in);
    /**Value to represent a correct input, initialized to false to enter while loop*/
    static boolean incorrectInput;


    /**gameStart is a method meant to run a single game from start to finish
     *@param Must give which game is wanted to start
     */
    static void gameStart() {
        CheckersLogic newGame = new CheckersLogic(); // create new game
        incorrectInput = true; // initialize as true
        System.out.println("Begin game. Enter 'G' if you want to use GUI; enter 'C' if you want to use the console.");
        newGame.scInput = sc3.next().charAt(0);
        while(incorrectInput) { // catch an incorrect input
            if(newGame.scInput == 'G' || newGame.scInput == 'g' || newGame.scInput == 'C' || newGame.scInput == 'c') { // if correct input
                incorrectInput = false; // break while loop
            }
            else { // if incorrect input
                System.out.println("Invalid input. Enter 'G' if you want to use GUI; enter 'C' if you want to use the console."); // try again
                newGame.scInput = sc3.next().charAt(0);
            }
        }
        if(newGame.scInput == 'C' || newGame.scInput == 'c') { // If user wants to use the text console
            System.out.println(newGame.updateGameboard(newGame)); // display gameboard
            System.out.println("Enter ‘P’ if you want to play against another player; enter ‘C’ to play against computer.");
            newGame.scInput = sc.next().charAt(0);
            incorrectInput = true; // reinitialize as true
            while(incorrectInput) { // catch an incorrect input
                if(newGame.scInput == 'p' || newGame.scInput == 'P' || newGame.scInput == 'c' || newGame.scInput == 'C') { // if correct input
                    incorrectInput = false; // break while loop
                }
                else { // if incorrect input
                    System.out.println("Incorrect input. Enter ‘P’ if you want to play against another player; enter ‘C’ to play against computer."); // try again
                    newGame.scInput = sc.next().charAt(0);
                }
            }
            if(newGame.scInput == 'p' || newGame.scInput == 'P') { // if user wants to play against player
                while(newGame.isPlayable() == true) { // while loop with each iteration representing a turn. when isPlayable == false, no legal move is possible
                    newGame.turnIncomplete = true; // set turn to incomplete at the beginning of each new turn
                    if(newGame.currentPlayer == 'x') { // display which player's turn it is
                        System.out.println("Player X - your turn." + "\n");
                    }
                    else {
                        System.out.println("Player O - your turn." + "\n");
                    }
                    while(newGame.turnIncomplete == true) { // while legal move has not been input by user
                        System.out.println("Choose a cell position of piece to be moved and the new position. e.g., 3a-4b"); // prompt user
                        newGame.inputMove = sc2.nextLine(); // assign user input
                        if(newGame.legalMove(newGame.inputMove) == true) { // if user input move is legal
                            newGame.turnIncomplete = false; // turn is complete
                        }
                    }
                    newGame.modifyMatrices(); // once turn is complete modify the x and o positions
                    System.out.println(newGame.updateGameboard(newGame)); // display updated gameboard
                    newGame.turnSwap(); // next player's turn
                }
                newGame.turnSwap(); // swap turns to check for draw
                if(newGame.isPlayable() == false) { // if next player also cannot move game ends in draw
                    System.out.println("Game ends in a tie");
                }
                else if(newGame.currentPlayer == 'x'){ // if current player can move, current player wins game
                    System.out.println("Player X Won the Game");
                }
                else {
                    System.out.println("Player O has Won the Game");
                }
            }
            else { // user wants to play against computer
                CheckersComputerPlayer ai = new CheckersComputerPlayer();
                System.out.println("Start game against computer." + "\n" + "You are Player X. It is your turn." + "\n");
                while(newGame.isPlayable() == true) { // while loop with each iteration representing a turn. when isPlayable == false, no legal move is possible
                    newGame.turnIncomplete = true; // set turn to incomplete at the beginning of each new turn
                    if(newGame.currentPlayer == 'x') { // display which player's turn it is
                        System.out.println("Player X - your turn." + "\n");
                        while(newGame.turnIncomplete == true) { // while legal move has not been input by user
                            System.out.println("Choose a cell position of piece to be moved and the new position. e.g., 3a-4b"); // prompt user
                            newGame.inputMove = sc2.nextLine(); // assign user input
                            if(newGame.legalMove(newGame.inputMove)) { // if user input move is legal
                                newGame.turnIncomplete = false; // turn is complete
                            }
                        }
                    }
                    else {
                        System.out.println("Player O - computer turn." + "\n");
                        ai.determineMove(newGame.gameboard, newGame);
                    }

                    newGame.modifyMatrices(); // once turn is complete modify the x and o positions
                    System.out.println(newGame.updateGameboard(newGame)); // display updated gameboard
                    newGame.turnSwap(); // next player's turn
                }
                newGame.turnSwap(); // swap turns to check for draw
                if(newGame.isPlayable() == false) { // if next player also cannot move game ends in draw
                    System.out.println("Game ends in a tie");
                }
                else if(newGame.currentPlayer == 'x'){ // if current player can move, current player wins game
                    System.out.println("Player X Won the Game");
                }
                else {
                    System.out.println("Player O has Won the Game");
                }
            }
        }
        else if(newGame.scInput == 'G' || newGame.scInput == 'g') { // if player selects gui
            Application.launch(CheckersGUI.class); // Launch gui
        }
        else { // just in case
            System.out.println("Invalid input");
            gameStart();
        }
    }

    /**main method used to start game*/
    public static void main(String args[]) {
        gameStart(); // start game
    }
}
