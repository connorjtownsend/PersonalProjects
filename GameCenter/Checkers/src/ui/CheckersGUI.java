package ui;

import core.CheckersLogic;

import core.CheckersComputerPlayer;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;

import javafx.scene.control.TextField;

import javafx.scene.control.Button;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
public class CheckersGUI extends Application {
    /**Method start used to start application
     * @return no return applicable
     * @param primaryStage to display game on
     */
    public void start(Stage primaryStage) {

        CheckersLogic game = new CheckersLogic();

        game.updateGameboard(game); // initialize gameboard

        GridPane grid = new GridPane(); // to house checkerboard

        Label lbl1 = new Label(""); // create label for top of ui
        lbl1.setFont(Font.font("Arial", 20));
        Label lblStatus = new Label("Submit ‘P’ if you want to play against another player; submit ‘C’ to play against computer."); // create label for bottom of ui
        lblStatus.setFont(Font.font("Arial", 12));
        TextField text = new TextField(); // to take user input
        TextField text2 = new TextField(); // to take user input

        Button submitButton = new Button("Submit"); // to submit user input

        Button moveButton = new Button("Move"); // to submit user input

        Button aiMoveButton = new Button("AI Move"); // to complete AI move

        HBox hbox = new HBox(text, submitButton); // hbox to hold commands at bottom of ui

        VBox vbox = new VBox(lblStatus,hbox); // vbox to hold all bottom elements

        // white square created to label rows and columns
        Rectangle[] whiteArray = new Rectangle[17];
        for(int i = 0; i < 17; i++) {
            Rectangle white = new Rectangle();
            white.setWidth(50);
            white.setHeight(50);
            white.setFill(Color.WHITE);
            whiteArray[i] = white;
        }

        // empty tan square for empty tan spaces on checkerboard
        Rectangle[] tanArray = new Rectangle[32];
        for(int i = 0; i < 32; i++) {
            Rectangle newTan = new Rectangle();
            newTan.setWidth(50);
            newTan.setHeight(50);
            newTan.setFill(Color.BEIGE);
            newTan.setStrokeWidth(2);
            newTan.setStroke(Color.BLACK);
            tanArray[i] = newTan;
        }
        // empty brown square for empty brown spaces on checkerboard
        Rectangle[] brownArray = new Rectangle[32];
        for(int i = 0; i < 32; i++) {
            Rectangle newBrown = new Rectangle();
            newBrown.setWidth(50);
            newBrown.setHeight(50);
            newBrown.setFill(Color.SADDLEBROWN);
            newBrown.setStrokeWidth(2);
            newBrown.setStroke(Color.BLACK);
            brownArray[i] = newBrown;
        }
        // empty brown rectangles to later place a checker on
        Rectangle[] filledBrownArray = new Rectangle[24];
        for(int i = 0; i < 24; i++) {
            Rectangle newBrown = new Rectangle();
            newBrown.setWidth(50);
            newBrown.setHeight(50);
            newBrown.setFill(Color.SADDLEBROWN);
            newBrown.setStrokeWidth(2);
            newBrown.setStroke(Color.BLACK);
            filledBrownArray[i] = newBrown;
        }
        // red circle represents red checker
        Circle[] red = new Circle[12];
        for(int i = 0; i < 12; i++) {
            Circle newRed = new Circle();
            newRed.setRadius(22);
            newRed.setFill(Color.RED);
            newRed.setStrokeWidth(2);
            newRed.setStroke(Color.BLACK);
            red[i] = newRed;
        }

        // black circle represents black checker
        Circle[] black = new Circle[12];
        for(int i = 0; i < 12; i++) {
            Circle newBlack = new Circle();
            newBlack.setRadius(22);
            newBlack.setFill(Color.BLACK);
            newBlack.setStrokeWidth(1);
            newBlack.setStroke(Color.WHITE);
            black[i] = newBlack;
        }


        // stackpanes to represent brown squares occupied by checkers
        StackPane[] redSquareArray = new StackPane[12];
        for(int i = 0; i < 12; i++) {
            StackPane redSquare = new StackPane(filledBrownArray[i], red[i]);
            redSquareArray[i] = redSquare;
        }
        StackPane[] blackSquareArray = new StackPane[12];
        for(int i = 0; i < 12; i++) {
            StackPane blackSquare = new StackPane(filledBrownArray[i + 12], black[i]);
            blackSquareArray[i] = blackSquare;
        }
        StackPane[] whiteSquareArray = new StackPane[8];
        int number = 8;
        for(int i = 0; i < 8; i++) {
            Label label = new Label("" + number);
            StackPane whiteSquare = new StackPane(whiteArray[i], label);
            whiteSquareArray[i] = whiteSquare;
            number--;
        }

        // initialize gameboard to correct starting positions with row and column labels
        grid.addRow(0, whiteSquareArray[0], tanArray[0], blackSquareArray[0], tanArray[1], blackSquareArray[1], tanArray[2], blackSquareArray[2], tanArray[3], blackSquareArray[3]);

        grid.addRow(1, whiteSquareArray[1], blackSquareArray[4], tanArray[4], blackSquareArray[5], tanArray[5], blackSquareArray[6], tanArray[6], blackSquareArray[7], tanArray[7]);

        grid.addRow(2, whiteSquareArray[2], tanArray[8], blackSquareArray[8], tanArray[9], blackSquareArray[9], tanArray[10], blackSquareArray[10], tanArray[11], blackSquareArray[11]);

        grid.addRow(3, whiteSquareArray[3], brownArray[0], tanArray[12], brownArray[1], tanArray[13], brownArray[2], tanArray[14], brownArray[3], tanArray[15]);

        grid.addRow(4, whiteSquareArray[4], tanArray[16], brownArray[4], tanArray[17], brownArray[5], tanArray[18], brownArray[6], tanArray[19], brownArray[7]);

        grid.addRow(5, whiteSquareArray[5], redSquareArray[0], tanArray[20], redSquareArray[1], tanArray[21], redSquareArray[2], tanArray[22], redSquareArray[3], tanArray[23]);

        grid.addRow(6, whiteSquareArray[6], tanArray[24], redSquareArray[4], tanArray[25], redSquareArray[5], tanArray[26], redSquareArray[6], tanArray[27], redSquareArray[7]);

        grid.addRow(7, whiteSquareArray[7], redSquareArray[8], tanArray[28], redSquareArray[9], tanArray[29], redSquareArray[10], tanArray[30], redSquareArray[11], tanArray[31]);
        Label labela = new Label("a");
        Label labelb = new Label("b");
        Label labelc = new Label("c");
        Label labeld = new Label("d");
        Label labele = new Label("e");
        Label labelf = new Label("f");
        Label labelg = new Label("g");
        Label labelh = new Label("h");
        StackPane whiteSquarea= new StackPane(whiteArray[8], labela);
        StackPane whiteSquareb= new StackPane(whiteArray[9], labelb);
        StackPane whiteSquarec= new StackPane(whiteArray[10], labelc);
        StackPane whiteSquared= new StackPane(whiteArray[11], labeld);
        StackPane whiteSquaree= new StackPane(whiteArray[12], labele);
        StackPane whiteSquaref= new StackPane(whiteArray[13], labelf);
        StackPane whiteSquareg= new StackPane(whiteArray[14], labelg);
        StackPane whiteSquareh= new StackPane(whiteArray[15], labelh);
        grid.addRow(8, whiteArray[16], whiteSquarea, whiteSquareb, whiteSquarec, whiteSquared, whiteSquaree, whiteSquaref, whiteSquareg, whiteSquareh);

        // set layout of game interface
        BorderPane border = new BorderPane();
        border.setCenter(grid);
        Label empty1 = new Label("                                               ");
        HBox tophbox = new HBox(empty1, lbl1);
        VBox topvbox = new VBox(tophbox);
        border.setTop(topvbox);
        border.setBottom(vbox);

        // define and display scene
        Scene scene = new Scene(border,550,550);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();

        // when submit button is pressed

        submitButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            /** method to handle submit button press
             * @param intakes action event being the button press
             */
            public void handle(ActionEvent event) { // method to handle submit button press
                CharSequence textBox = text.getCharacters();
                if(textBox.charAt(0) == 'p' || textBox.charAt(0) == 'P') { // if the textfield contains a p when submit button is pressed
                    // new formatting for player vs player game
                    HBox hboxP = new HBox(text2, moveButton);
                    VBox vboxP = new VBox(lblStatus, hboxP);
                    border.setBottom(vboxP);
                    lbl1.setText("Player VS. Player Game");
                    lblStatus.setText("Player X (Red) - your turn. Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
                    moveButton.setOnAction(new EventHandler<ActionEvent>(){ // When move button is pressed
                        @Override
                        /** method to handle move button press
                         * @param intakes action event being the button press
                         */
                        public void handle(ActionEvent event) { // method to handle button push
                            CharSequence textBox2 = text2.getCharacters(); // assign contents of text field
                            game.inputMove = "" + textBox2.charAt(0) + textBox2.charAt(1) + textBox2.charAt(2) + textBox2.charAt(3) + textBox2.charAt(4); // convert to string
                            text2.setText(""); // clear text field
                            if(game.legalMove(game.inputMove) == true) { // if input move is legal
                                game.modifyMatrices(); // update matrices
                                game.updateGameboard(game); // update gameboard
                                updateGUIBoard(game.gameboard, grid); // update gui gameboard
                                game.turnSwap(); // alternate turn
                                if(game.currentPlayer == 'x') { // if its player x's turn
                                    lblStatus.setText("Player X (Red) - your turn. Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
                                }
                                else { // if its player o's turn
                                    lblStatus.setText("Player O (Black) - your turn. Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
                                }
                                if(game.isPlayable() == false) { // if game is not playable for current player
                                    game.turnSwap(); // swap turns to check for draw
                                    if(game.isPlayable() == false) { // if next player also cannot move game ends in draw
                                        lblStatus.setText("Game ends in a tie");
                                    }
                                    else if(game.currentPlayer == 'x'){ // if current player can move, current player wins game
                                        lblStatus.setText("Player X (Red) Won the Game");
                                    }
                                    else {
                                        lblStatus.setText("Player O (Black) has Won the Game");
                                    }
                                }
                            }
                        }
                    });
                }

                else if(textBox.charAt(0) == 'c' || textBox.charAt(0) == 'C') { // if the textfield contains a c when submit button is pressed
                    HBox hboxC = new HBox(text2, moveButton, aiMoveButton); // new formatting
                    VBox vboxC = new VBox(lblStatus, hboxC);
                    border.setBottom(vboxC);
                    CheckersComputerPlayer ai = new CheckersComputerPlayer(); // create new ai player
                    lbl1.setText("Player VS. Computer Game");
                    lblStatus.setText("Player X (Red) - your turn. Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
                    moveButton.setOnAction(new EventHandler<ActionEvent>(){ // when move button is pressed
                        @Override
                        /** method to handle move button press
                         * @param intakes action event being the button press
                         */
                        public void handle(ActionEvent event) { //method to handle button press
                            if(game.currentPlayer == 'x') { // if it is player x's turn
                                CharSequence textBox2 = text2.getCharacters(); // assign text field as move
                                game.inputMove = "" + textBox2.charAt(0) + textBox2.charAt(1) + textBox2.charAt(2) + textBox2.charAt(3) + textBox2.charAt(4);
                                text2.setText("");
                                if(game.legalMove(game.inputMove) == true) { // if move input is legal
                                    game.modifyMatrices(); // update matrices
                                    game.updateGameboard(game); // update gameboard
                                    updateGUIBoard(game.gameboard, grid); // update gui
                                    game.turnSwap();	// swap turns
                                    lblStatus.setText("Player O (Black) - computer turn. Press 'AI Move' button to complete computer turn");
                                    if(game.isPlayable() == false) { // if game is no longer playable
                                        game.turnSwap(); // swap turns to check for draw
                                        if(game.isPlayable() == false) { // if next player also cannot move game ends in draw
                                            lblStatus.setText("Game ends in a tie");
                                        }
                                        else if(game.currentPlayer == 'x'){ // if current player can move, current player wins game
                                            lblStatus.setText("Player X (Red) Won the Game");
                                        }
                                        else {
                                            lblStatus.setText("Player O (Black) has Won the Game");
                                        }
                                    }
                                }
                            }
                        }
                    });
                    aiMoveButton.setOnAction(new EventHandler<ActionEvent>(){ // when ai move button is pressed
                        @Override
                        /** method to handle ai move button press
                         * @param intakes action event being the button press
                         */
                        public void handle(ActionEvent event) { // method to handle button press
                            if(game.currentPlayer == 'o') { // if its player o's turn
                                ai.determineMove(game.gameboard, game); // identify ai move
                                game.modifyMatrices(); // once turn is complete modify the x and o positions
                                game.updateGameboard(game); // update gameboard matrix
                                updateGUIBoard(game.gameboard, grid); // update gui game board
                                game.turnSwap(); // next player's turn
                                lblStatus.setText("Player X (Red) - your turn. Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
                                if(game.isPlayable() == false) { // if game is no longer playable
                                    game.turnSwap(); // swap turns to check for draw
                                    if(game.isPlayable() == false) { // if next player also cannot move game ends in draw
                                        lblStatus.setText("Game ends in a tie");
                                    }
                                    else if(game.currentPlayer == 'x'){ // if current player can move, current player wins game
                                        lblStatus.setText("Player X (Red) Won the Game");
                                    }
                                    else {
                                        lblStatus.setText("Player O (Black) has Won the Game");
                                    }
                                }
                            }
                        }
                    });
                }
                else { // if the textfield contains neither a p nor a c when submit button is pressed
                    lblStatus.setText("Invalid input. Submit ‘P’ if you want to play against another player; submit ‘C’ to play against computer.");
                    text.setText("");
                }
            }
        });


    }
    /**Method used to update gui game baord
     * @param gameboard matrix used to keep track of location of each checker
     * @param grid used to store rectangles that represent the checkers and squares on the board
     */
    public void updateGUIBoard(char[][] gameboard, GridPane grid){
        // integers to store counts to keep track of which rectangles that have been used already
        int blackCount = 0;
        int redCount = 0;
        int tanCount = 0;
        int brownCount = 0;
        int resetCount = 0;

        // empty blue rectangles to clear out game board freeing up other squares for use again
        Rectangle[] reset = new Rectangle[64];
        for(int i = 0; i < 64; i++) {
            Rectangle newReset = new Rectangle();
            newReset.setWidth(50);
            newReset.setHeight(50);
            newReset.setFill(Color.BLUE);
            reset[i] = newReset;
        }
        // empty tan square for empty tan spaces on checkerboard
        Rectangle[] tanArray = new Rectangle[32];
        for(int i = 0; i < 32; i++) {
            Rectangle newTan = new Rectangle();
            newTan.setWidth(50);
            newTan.setHeight(50);
            newTan.setFill(Color.BEIGE);
            newTan.setStrokeWidth(2);
            newTan.setStroke(Color.BLACK);
            tanArray[i] = newTan;
        }
        // empty brown square for empty brown spaces on checkerboard

        Rectangle[] brownArray = new Rectangle[32];
        for(int i = 0; i < 32; i++) {
            Rectangle newBrown = new Rectangle();
            newBrown.setWidth(50);
            newBrown.setHeight(50);
            newBrown.setFill(Color.SADDLEBROWN);
            newBrown.setStrokeWidth(2);
            newBrown.setStroke(Color.BLACK);
            brownArray[i] = newBrown;
        }

        // empty brown rectangles to later be filled with red and black checkers
        Rectangle[] filledBrownArray = new Rectangle[24];
        for(int i = 0; i < 24; i++) {
            Rectangle newBrown = new Rectangle();
            newBrown.setWidth(50);
            newBrown.setHeight(50);
            newBrown.setFill(Color.SADDLEBROWN);
            newBrown.setStrokeWidth(2);
            newBrown.setStroke(Color.BLACK);
            filledBrownArray[i] = newBrown;
        }
        // red circle represents red checker
        Circle[] red = new Circle[12];
        for(int i = 0; i < 12; i++) {
            Circle newRed = new Circle();
            newRed.setRadius(22);
            newRed.setFill(Color.RED);
            newRed.setStrokeWidth(2);
            newRed.setStroke(Color.BLACK);
            red[i] = newRed;
        }

        // black circle represents black checker
        Circle[] black = new Circle[12];
        for(int i = 0; i < 12; i++) {
            Circle newBlack = new Circle();
            newBlack.setRadius(22);
            newBlack.setFill(Color.BLACK);
            newBlack.setStrokeWidth(1);
            newBlack.setStroke(Color.WHITE);
            black[i] = newBlack;
        }


        // stackpanes to represent brown squares occupied by checkers
        StackPane[] redSquareArray = new StackPane[12];
        for(int i = 0; i < 12; i++) {
            StackPane redSquare = new StackPane(filledBrownArray[i], red[i]);
            redSquareArray[i] = redSquare;
        }
        StackPane[] blackSquareArray = new StackPane[12];
        for(int i = 0; i < 12; i++) {
            StackPane blackSquare = new StackPane(filledBrownArray[i + 12], black[i]);
            blackSquareArray[i] = blackSquare;
        }

        // wipe existing game board and replace with reset rectangles
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                grid.add(reset[resetCount], j + 1, i);
                resetCount++;
            }
        }
        // parse through gameboard matrix and update ui at each square
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(gameboard[i][j] == 'o') { // if current square has an o checker, display a rectangle with an black checker
                    grid.add(blackSquareArray[blackCount], j + 1, i);
                    blackCount++;
                    System.out.println("1");
                }
                else if(gameboard[i][j]== 'x') { // if current square has an x checker, display a rectangle with a red checker
                    grid.add(redSquareArray[redCount], j + 1, i);
                    redCount++;
                    System.out.println("2");
                }
                else { // if current square has no checker, display the proper color rectangle
                    if(((i == 0) || (i == 2) || (i == 4) || (i == 6)) && ((j == 1 || j == 3 || j == 5 || j == 7))) {
                        grid.add(brownArray[brownCount], j + 1, i);
                        brownCount++;
                        System.out.println("3");
                    }
                    else if(((i == 0) || (i == 2) || (i == 4) || (i == 6)) && ((j == 0 || j == 2 || j == 4 || j == 6))) {
                        grid.add(tanArray[tanCount], j + 1, i);
                        tanCount++;
                        System.out.println("4");
                    }
                    else if(((i == 1) || (i == 3) || (i == 5) || (i == 7)) && ((j == 1 || j == 3 || j == 5 || j == 7))) {
                        grid.add(tanArray[tanCount], j + 1, i);
                        tanCount++;
                        System.out.println("5");
                    }
                    else {
                        grid.add(brownArray[brownCount], j + 1, i);
                        brownCount++;
                        System.out.println("6");
                    }
                }
            }
        }
    }
}
