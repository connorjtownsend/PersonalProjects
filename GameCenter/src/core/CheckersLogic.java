package core;

/**CheckersLogic class contains all logic necessary to play checkers game
 * @author Connor Townsend
 */
public class CheckersLogic {
    /**Character to represent which player's turn it currently is*/
    public char currentPlayer;
    /**Boolean value is true if current turn is not yet complete*/
    public boolean turnIncomplete;
    /**Boolean value is true when a piece was captured during the current turn*/
    public boolean capture;
    /**Boolean value is true when a piece was captured by a piece moving to the left side of the board*/
    public boolean leftSideCapture;
    /**String value of input from player to represent player move*/
    public String inputMove;
    /**String value of input from player*/
    public char scInput;
    /**xMatrix represents positions of each x checker*/
    public int[][] xMatrix;
    /**oMatrix represents positions of each o checker*/
    public int[][] oMatrix;
    /**gameboard represents status of each square: either x, o, or _*/
    public char[][] gameboard;
    /**lastMove is the String inputMove converted to an array of integers representing the piece to be moved and the spot it is to be moved to*/
    public int[][] lastMove;

    /**Constructor for new game*/
    public CheckersLogic() {
        // initialize all needed variables
        currentPlayer = 'x';
        turnIncomplete = true;
        capture = false;
        leftSideCapture = false;
        xMatrix = new int[8][8];
        oMatrix = new int[8][8];
        // build starting x and o matrices
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i < 5) {
                    xMatrix[i][j] = 0;
                }
                else {
                    if(i == 5 || i == 7) {
                        if(j % 2 == 0 ) {
                            xMatrix[i][j] = 1;
                        }
                        else {
                            xMatrix[i][j] = 0;
                        }
                    }
                    else {
                        if(j % 2 == 0) {
                            xMatrix[i][j] = 0;
                        }
                        else {
                            xMatrix[i][j] = 1;
                        }
                    }
                }
                if(i > 2) {
                    oMatrix[i][j] = 0;
                }
                else {
                    if(i == 0 || i == 2) {
                        if(j % 2 == 0) {
                            oMatrix[i][j] = 0;
                        }
                        else {
                            oMatrix[i][j] = 1;
                        }
                    }
                    else {
                        if(j % 2 == 0) {
                            oMatrix[i][j] = 1;
                        }
                        else {
                            oMatrix[i][j] = 0;
                        }
                    }
                }
            }
        }
        /**gameboard represents status of each square: either x, o, or _*/
        gameboard = new char[8][8];
        /**lastMove is the String inputMove converted to an array of integers representing the piece to be moved and the spot it is to be moved to*/
        lastMove = new int[2][2];

    }





    /**turnSwap swaps turns and returns the new player whose turn it is
     *@return character representing which player's turn it is after method id called
     */
    public char turnSwap() {// swap current player value
        if(currentPlayer == 'x') {
            currentPlayer = 'o';
        }
        else {
            currentPlayer = 'x';
        }
        return currentPlayer;
    }

    /**legalMove returns true if the input move is legal
     *@return boolean representing whether or not move is legal
     *@param String representing the move to be checked
     */
    public boolean legalMove(String move) {
        char char1, char2, char3, char4; // initialize characters to store values of input string
        capture = false; // initialize the move being a capture to false
        // first two string characters are char 1 and char 2, last 2 are char3 and char4
        ;
        char1 = move.charAt(0);
        char2 = move.charAt(1);
        char3 = move.charAt(3);
        char4 = move.charAt(4);

        // modify input values to corresponding matrix value
        if(char1 == '1') {
            char1 ='8';
        }
        else if(char1 == '2') {
            char1 = '7';
        }
        else if(char1 == '3') {
            char1 = '6';
        }
        else if(char1 == '4') {
            char1 = '5';
        }
        else if(char1 == '5') {
            char1 = '4';
        }
        else if(char1 == '6') {
            char1 = '3';
        }
        else if(char1 == '7') {
            char1 = '2';
        }
        else if(char1 == '8') {
            char1 = '1';
        }
        else {

            return false; // if value is not on gameboard, move is not legal
        }
        if(char3 == '1') {
            char3 ='8';
        }
        else if(char3 == '2') {
            char3 = '7';
        }
        else if(char3 == '3') {
            char3 = '6';
        }
        else if(char3 == '4') {
            char3 = '5';
        }
        else if(char3 == '5') {
            char3 = '4';
        }
        else if(char3 == '6') {
            char3 = '3';
        }
        else if(char3 == '7') {
            char3 = '2';
        }
        else if(char3 == '8') {
            char3 = '1';
        }
        else{

            return false;
        }
        if(char2 == 'a') {
            char2 = '1';
        }
        else if(char2 == 'b') {
            char2 = '2';
        }
        else if(char2 == 'c') {
            char2 = '3';
        }
        else if(char2 == 'd') {
            char2 = '4';
        }
        else if(char2 == 'e') {
            char2 = '5';
        }
        else if(char2 == 'f') {
            char2 = '6';
        }
        else if(char2 == 'g') {
            char2 = '7';
        }
        else if(char2 == 'h') {
            char2 = '8';
        }
        else {

            return false;
        }
        if(char4 == 'a') {
            char4 = '1';
        }
        else if(char4 == 'b') {
            char4 = '2';
        }
        else if(char4 == 'c') {
            char4 = '3';
        }
        else if(char4 == 'd') {
            char4 = '4';
        }
        else if(char4 == 'e') {
            char4 = '5';
        }
        else if(char4 == 'f') {
            char4 = '6';
        }
        else if(char4 == 'g') {
            char4 = '7';
        }
        else if(char4 == 'h') {
            char4 = '8';
        }
        else {

            return false;
        }

        //Convert character to numeric value and subtract 1 because matrix starts at 0
        //Then insert value into 2x2 matrix representing piece current postion and final position
        lastMove[0][0] = Character.getNumericValue(char1) - 1;
        lastMove[0][1] = Character.getNumericValue(char2) - 1;
        lastMove[1][0] = Character.getNumericValue(char3) - 1;
        lastMove[1][1] = Character.getNumericValue(char4) - 1;



        if(gameboard[lastMove[0][0]][lastMove[0][1]] == 'x' && currentPlayer == 'x') { // if current position has an x checker and current player is x
            if(gameboard[lastMove[1][0]][lastMove[1][1]] == '_' && lastMove[1][0] == (lastMove[0][0] - 1)) { // if desired position is empty and only one space forward
                if(lastMove[1][1] == (lastMove[0][1] + 1) || lastMove[1][1] == (lastMove[0][1] - 1)) { // if desired position is either one to the right or left
                    return true; // move is legal
                }
            }
            if(gameboard[lastMove[1][0]][lastMove[1][1]] == '_' && lastMove[1][0] == (lastMove[0][0] - 2) && lastMove[1][1] == (lastMove[0][1] + 2) && gameboard[lastMove[0][0] - 1][lastMove[0][1] + 1] == 'o') { // if desired position is empty and two forward and two to the right and an o checker in between
                capture = true; // captured piece
                return true; // legal move
            }
            if(gameboard[lastMove[1][0]][lastMove[1][1]] == '_' && lastMove[1][0] == (lastMove[0][0] - 2) && lastMove[1][1] == (lastMove[0][1] - 2) && gameboard[lastMove[0][0] - 1][lastMove[0][1] - 1] == 'o') { // if desired position is empty and two forward and two to the left and an o checker in between
                capture = true; // captured piece
                leftSideCapture = true; // captured piece on left side of board
                return true; // legal move
            }
        }
        if(gameboard[lastMove[0][0]][lastMove[0][1]] == 'o' && currentPlayer == 'o'){ // if current position has an o checker and current player is o
            if(gameboard[lastMove[1][0]][lastMove[1][1]] == '_' && lastMove[1][0] == (lastMove[0][0] + 1)) { // if desired position is empty and only one space forward
                if(lastMove[1][1] == (lastMove[0][1] + 1) || lastMove[1][1] == (lastMove[0][1] - 1)) { // if desired position is either one to the right or left
                    return true; // move is legal
                }
            }
            if(gameboard[lastMove[1][0]][lastMove[1][1]] == '_' && lastMove[1][0] == (lastMove[0][0] + 2) && lastMove[1][1] == (lastMove[0][1] + 2) && gameboard[lastMove[0][0] + 1][lastMove[0][1] + 1] == 'x') { // if desired position is empty and two forward and two to the right and an x checker in between
                capture = true; // captured piece
                return true; // legal move
            }
            if(gameboard[lastMove[1][0]][lastMove[1][1]] == '_' && lastMove[1][0] == (lastMove[0][0] + 2) && lastMove[1][1] == (lastMove[0][1] - 2) && gameboard[lastMove[0][0] + 1][lastMove[0][1] - 1] == 'x') { // if desired position is empty and two forward and two to the left and an x checker in between
                capture = true; // captured piece
                leftSideCapture = true; // capture on left side of board
                return true; // legal move
            }
        }

        return false; // illegal move

    }

    /**modifyMatrices updates xMatrix and oMatrix after a move is made */
    public void modifyMatrices() {
        if(capture == true) { // if capture happened during last turn
            if(currentPlayer == 'x') { // if player x
                if(leftSideCapture == true) { // if left side of board
                    // update all 3 positions
                    xMatrix[lastMove[0][0]][lastMove[0][1]] = 0;
                    xMatrix[lastMove[1][0]][lastMove[1][1]] = 1;
                    oMatrix[lastMove[0][0] - 1][lastMove[0][1] - 1] = 0;
                }
                else { // if right side of board update all 3 positions
                    xMatrix[lastMove[0][0]][lastMove[0][1]] = 0;
                    xMatrix[lastMove[1][0]][lastMove[1][1]] = 1;
                    oMatrix[lastMove[0][0] - 1][lastMove[0][1] + 1] = 0;
                }
            }
            else { // if player o
                if(leftSideCapture == true) { // if left side of board update all 3 positions
                    oMatrix[lastMove[0][0]][lastMove[0][1]] = 0;
                    oMatrix[lastMove[1][0]][lastMove[1][1]] = 1;
                    xMatrix[lastMove[0][0] + 1][lastMove[0][1] - 1] = 0;
                }
                else { // if right side of board update all 3 positions
                    oMatrix[lastMove[0][0]][lastMove[0][1]] = 0;
                    oMatrix[lastMove[1][0]][lastMove[1][1]] = 1;
                    xMatrix[lastMove[0][0] + 1][lastMove[0][1] + 1] = 0;
                }
            }
            capture = false; // reset capture to false
            leftSideCapture = false; // reset left side of board to false
        }
        else { // if no capture on this turn
            if(currentPlayer == 'x') { // if current player is x, update both positions
                xMatrix[lastMove[0][0]][lastMove[0][1]] = 0;
                xMatrix[lastMove[1][0]][lastMove[1][1]] = 1;

            }
            else { // if current player is o, update both positions
                oMatrix[lastMove[0][0]][lastMove[0][1]] = 0;
                oMatrix[lastMove[1][0]][lastMove[1][1]] = 1;
            }
        }
    }

    /**isPlayable returns true if game is able to continue, false if game is over
     * @return boolean representing whether or not game is able to continue
     */
    public boolean isPlayable() {
        int count = 0; // count to track number of checkers left
        int immovableCount = 0; // count to track number of checkers left unable to move
        int[][] zeroMatrix = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}}; // zero matrix for comparison
        if(currentPlayer == 'x' && xMatrix == zeroMatrix) { // if zero x checkers are left on player x's turn
            return false; // game is not playable
        }
        if(currentPlayer == 'o' && oMatrix == zeroMatrix) { // if zero o checkers are left on player o's turn
            return false; // game is not playable
        }
        if(currentPlayer == 'x') { // if player x is up
            for(int i = 0; i < 8; i++) { // for all positions on board
                for(int j = 0; j < 8; j++) {
                    if(xMatrix[i][j] == 1) { // if an x checker is here
                        count++; // increment count
                        if((j - 2) >= 0 && (j + 2) <= 7  && (i - 2) >= 0) { // prevent out of bounds error
                            if((oMatrix[i - 1][j - 1] == 1 || xMatrix[i - 1][j - 1] == 1) && (oMatrix[i - 2][j - 2] == 1 || xMatrix[i - 2][j - 2] == 1) && (oMatrix[i - 1][j + 1] == 1 || xMatrix[i - 1][j + 1] == 1) && (oMatrix[i - 2][j + 2] == 1 || xMatrix[i - 2][j + 2] == 1)) { // if checker has two checkers diagonally left and right
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((i - 1) >= 0 && (j - 1) >= 0 && (j + 2) <= 7) { // prevent out of bounds error
                            if((oMatrix[i - 1][j - 1] == 1 || xMatrix[i - 1][j - 1] == 1) && (j - 2) < 0 && (oMatrix[i - 1][j + 1] == 1 || xMatrix[i - 1][j + 1] == 1) && (oMatrix[i - 2][j + 2] == 1 || xMatrix[i - 2][j + 2] == 1)) { // if checker has one checker to the left diagonally and then the edge of the board and two checkers to the right diagonally
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((i - 2) >= 0 && (j - 2) >= 0 && (j + 1) <= 7) { // prevent out of bounds error
                            if((oMatrix[i - 1][j - 1] == 1 || xMatrix[i - 1][j - 1] == 1) && (oMatrix[i - 2][j - 2] == 1 || xMatrix[i - 2][j - 2] == 1) && (oMatrix[i - 1][j + 1] == 1 || xMatrix[i - 1][j + 1] == 1) && (j + 2) > 7) { // if checker has one checker to the right diagonally and then the edge of the board and two checkers to the left diagonally
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((j - 2) >= 0 && (i - 2) >= 0) { // prevent out of bounds error
                            if((oMatrix[i - 1][j - 1] == 1 || xMatrix[i - 1][j - 1] == 1) && (oMatrix[i - 2][j - 2] == 1 || xMatrix[i - 2][j - 2] == 1) && (j + 1) > 7) { // if checker has two checkers to the left diagonally and an edge on the right
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((j + 2) <= 7 && (i - 2) >= 0) { // prevent out of bounds error
                            if((j - 1) < 0 && (oMatrix[i - 1][j + 1] == 1 || xMatrix[i - 1][j + 1] == 1) && (oMatrix[i - 2][j + 2] == 1 || xMatrix[i - 2][j + 2] == 1)) { // if checker has two checkers to the right diagonally and an edge on the left
                                immovableCount++; // increment immovable count
                            }
                        }
                    }
                }
            }
            if(count == immovableCount) {
                return false;
            }
        }
        if(currentPlayer == 'o') {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(oMatrix[i][j] == 1) {
                        count++; // increment count
                        if((j - 2) >= 0 && (j + 2) <= 7 && (i + 2) <= 7) { // prevent out of bounds error
                            if((xMatrix[i + 1][j - 1] == 1 || oMatrix[i + 1][j - 1] == 1) && (xMatrix[i + 2][j - 2] == 1 || oMatrix[i + 2][j - 2] == 1) && (xMatrix[i + 1][j + 1] == 1 || oMatrix[i + 1][j + 1] == 1) && (xMatrix[i + 2][j + 2] == 1 || oMatrix[i + 2][j + 2] == 1)) { // if checker has two checkers diagonally left and right
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((j - 1) >= 0 && (j + 2) <= 7 && (i + 2) <= 7) { // prevent out of bounds error
                            if((xMatrix[i + 1][j - 1] == 1 || oMatrix[i + 1][j - 1] == 1) && (j - 2) < 0 && (xMatrix[i + 1][j + 1] == 1 || oMatrix[i + 1][j + 1] == 1) && (xMatrix[i + 2][j + 2] == 1 || oMatrix[i + 2][j + 2] == 1)) { // if checker has one checker to the left diagonally and then the edge of the board and two checkers to the right diagonally
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((j-2) >= 0 && (j + 1) <= 7 && (i + 2) <= 7) { // prevent out of bounds error
                            if((xMatrix[i + 1][j - 1] == 1 || oMatrix[i + 1][j - 1] == 1) && (xMatrix[i + 2][j - 2] == 1 || oMatrix[i + 2][j - 2] == 1) && (xMatrix[i + 1][j + 1] == 1 || oMatrix[i + 1][j + 1] == 1) && (j + 2) > 7) { // if checker has one checker to the right diagonally and then the edge of the board and two checkers to the left diagonally
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((j-2) >= 0 && (i + 2) <= 7) { // prevent out of bounds error
                            if((xMatrix[i + 1][j - 1] == 1 || oMatrix[i + 1][j - 1] == 1) && (xMatrix[i + 2][j - 2] == 1 || oMatrix[i + 2][j - 2] == 1) && (j + 1) > 7) { // if checker has two checkers to the left diagonally and an edge on the right
                                immovableCount++; // increment immovable count
                            }
                        }
                        if((j + 2) <= 7 && (i + 2) <= 7) { // prevent out of bounds error
                            if((j - 1) < 0 && (xMatrix[i + 1][j + 1] == 1 || oMatrix[i + 1][j + 1] == 1) && (xMatrix[i + 2][j + 2] == 1 || oMatrix[i + 2][j + 2] == 1)) { // if checker has two checkers to the right diagonally and an edge on the left
                                immovableCount++; // increment immovable count
                            }
                        }
                    }
                }
            }
            if(count == immovableCount) { // if for each checker left there is an equal amount of immovable checkers
                return false; // game is no longer playable
            }
        }
        return true; // otherwise game is playable
    }

    /**updateGameboard returns a string representation of the current gameboard
     * @param Game parameter to tell which game is being updated
     * @return String representing current gameboard
     */
    public String updateGameboard(CheckersLogic game) {
        String gameInterface = ""; // initialize string to build interface on
        int rowNumber = 8; // row number to decrement

        for(int i = 0; i < 8; i++) { // cycle through matrices
            for(int j = 0; j < 8; j++) {
                if(game.oMatrix[i][j] == 1) {
                    game.gameboard[i][j] = 'o'; // if an o is here set gameboard to o
                }
                else if(game.xMatrix[i][j] == 1){
                    game.gameboard[i][j] = 'x'; // if an x is here set gameboard to x
                }
                else {
                    game.gameboard[i][j] = '_'; // if nothing here set gameboard to _
                }
            }
        }
        for(int f = 0; f < 8; f++) { // cycle through rows
            gameInterface = gameInterface + "\n" + rowNumber; // on new line start with row number
            rowNumber--; // decrement row number
            for(int g = 0; g < 8; g++) { // cycle through columns
                gameInterface = gameInterface + " | " + game.gameboard[f][g]; // for each value put a bar and then the value at that position
            }
            gameInterface = gameInterface + " |" + "\n"; // put a bar at the end of each row then start new line
        }
        gameInterface = gameInterface + "\n" + "    a   b   c   d   e   f   g   h  " + "\n"; // add a new line then add one final row with letters to identify columns and move to next line
        return gameInterface; // return this game interface created
    }

}
