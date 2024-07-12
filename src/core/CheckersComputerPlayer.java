package core;

/**CheckersComputerPlayer class contains all logic necessary for computer ai to play checkers game
 * @author Connor Townsend
 */
public class CheckersComputerPlayer {
    /**String to represent move to be checked*/
    String moveCheck;
    /**String to represent the ai's chosen move*/
    public String chosenMove;
    /**array to hold the coordinates of the array being parsed*/
    public int[] lastChecker;
    /**characters to hold the 4 digits of a move*/
    char char1;
    char char2;
    char char3;
    char char4;

    /**Constructor for ai player*/
    public CheckersComputerPlayer() {
        lastChecker = new int[2]; // initialize array size to 2
    }

    /**determineMove class meant to choose a move for the ai to play
     *@param gameboard matrix to parse through
     * @return String representing the chosen move
     */
    public String determineMove(char[][] gameboard, CheckersLogic game) {
        lastChecker[0] = 0; // initialize tool to parse through board to 0
        lastChecker[1] = 0;
        for(int i = 0; i < checkerCount('o', gameboard); i++) {	// loop once for every o checker
            while(gameboard[lastChecker[0]][lastChecker[1]] != 'o') { // keep looping until the values of last checker represent an o checker on game board
                if(lastChecker[1] != 7) { // increment y
                    lastChecker[1]++;
                }
                else {
                    lastChecker[0]++; // increment x
                    lastChecker[1] = 0; // reset y to 0
                }
            }
            if(jumpAvailable(lastChecker[0],lastChecker[1],game)) { // if a jump can be made
                chosenMove = moveCheck; // set jump move to chosen move
                return chosenMove; // return this move
            }
            if(lastChecker[1] != 7) { // increment tool to space without o checker so while loop can continue
                lastChecker[1]++;
            }
            else {
                lastChecker[0]++;
                lastChecker[1] = 0;
            }
        }
        lastChecker[0] = 0; // reset tool to 0
        lastChecker[1] = 0;
        for(int j = 0; j < checkerCount('o', gameboard); j++) { // for each o checker
            while(gameboard[lastChecker[0]][lastChecker[1]] != 'o') {
                if(lastChecker[1] != 7) { // increment until o checker
                    lastChecker[1]++;
                }
                else {
                    lastChecker[0]++;
                    lastChecker[1] = 0;
                }
            }
            // set char1 and char2 to the coordinates of the current checker on the ui gameboard
            if(lastChecker[0] == 0) {
                char1 ='8';
            }
            else if(lastChecker[0] == 1) {
                char1 = '7';
            }
            else if(lastChecker[0] == 2) {
                char1 = '6';
            }
            else if(lastChecker[0] == 3) {
                char1 = '5';
            }
            else if(lastChecker[0] == 4) {
                char1 = '4';
            }
            else if(lastChecker[0] == 5) {
                char1 = '3';
            }
            else if(lastChecker[0] == 6) {
                char1 = '2';
            }
            else{
                char1 = '1';
            }

            if(lastChecker[1] == 0) {
                char2 ='a';
            }
            else if(lastChecker[1] == 1) {
                char2 = 'b';
            }
            else if(lastChecker[1] == 2) {
                char2 = 'c';
            }
            else if(lastChecker[1] == 3) {
                char2 = 'd';
            }
            else if(lastChecker[1] == 4) {
                char2 = 'e';
            }
            else if(lastChecker[1] == 5) {
                char2 = 'f';
            }
            else if(lastChecker[1] == 6) {
                char2 = 'g';
            }
            else{
                char2 = 'h';
            }
            // check spot that is 1 ahead of current checker
            if(lastChecker[0] + 1 == 0) {
                char3 ='8';
            }
            else if(lastChecker[0] + 1 == 1) {
                char3 = '7';
            }
            else if(lastChecker[0] + 1 == 2) {
                char3 = '6';
            }
            else if(lastChecker[0] + 1 == 3) {
                char3 = '5';
            }
            else if(lastChecker[0] + 1 == 4) {
                char3 = '4';
            }
            else if(lastChecker[0] + 1 == 5) {
                char3 = '3';
            }
            else if(lastChecker[0] + 1 == 6) {
                char3 = '2';
            }
            else{
                char3 = '1';
            }
            // and 1 to the right of current checker
            if(lastChecker[1] + 1 == 0) {
                char4 ='a';
            }
            else if(lastChecker[1] + 1 == 1) {
                char4 = 'b';
            }
            else if(lastChecker[1] + 1 == 2) {
                char4 = 'c';
            }
            else if(lastChecker[1] + 1 == 3) {
                char4 = 'd';
            }
            else if(lastChecker[1] + 1 == 4) {
                char4 = 'e';
            }
            else if(lastChecker[1] + 1 == 5) {
                char4 = 'f';
            }
            else if(lastChecker[1] + 1 == 6) {
                char4 = 'g';
            }
            else{
                char4 = 'h';
            }
            // turn chars to a string in a format fitting legalMove method
            moveCheck = "" + char1 + char2 + "-" + char3 + char4;

            if(game.legalMove(moveCheck)) { // check if this move is legal, if so choose it as move
                chosenMove = moveCheck;
                return chosenMove;
            }
            // if it is not legal try the spot that is one forward and one to the left of current checker
            if(lastChecker[1] - 1 == 0) {
                char4 ='a';
            }
            else if(lastChecker[1] - 1 == 1) {
                char4 = 'b';
            }
            else if(lastChecker[1] - 1 == 2) {
                char4 = 'c';
            }
            else if(lastChecker[1] - 1 == 3) {
                char4 = 'd';
            }
            else if(lastChecker[1] - 1 == 4) {
                char4 = 'e';
            }
            else if(lastChecker[1] - 1 == 5) {
                char4 = 'f';
            }
            else if(lastChecker[1] - 1 == 6) {
                char4 = 'g';
            }
            else{
                char4 = 'h';
            }
            // create string to check
            moveCheck = "" + char1 + char2 + "-" + char3 + char4;

            if(game.legalMove(moveCheck)) { // if this move is legal, choose it
                chosenMove = moveCheck;
                return chosenMove;
            }
            // if not increment to empty square to keep while loop going
            if(lastChecker[1] != 7) {
                lastChecker[1]++;
            }
            else {
                lastChecker[0]++;
                lastChecker[1] = 0;
            }
        }

        chosenMove = moveCheck;
        return chosenMove; // used to fix error, this should never be used because any time no move is available the game should already be over
    }
    /**Class used to determine if a jump is available for a specific checker
     * @param integer x and y represent the position of the checker being checked on the gameboard
     * @param game used to call legalMove method from CheckersLogic class
     * @return boolean value true if jump is available at current checker location
     */
    public boolean jumpAvailable(int x, int y, CheckersLogic game) {
        // set chars to their ui representation in order to construct a move to be checked
        if(x == 0) {
            char1 ='8';
        }
        else if(x == 1) {
            char1 = '7';
        }
        else if(x == 2) {
            char1 = '6';
        }
        else if(x == 3) {
            char1 = '5';
        }
        else if(x == 4) {
            char1 = '4';
        }
        else if(x == 5) {
            char1 = '3';
        }
        else if(x == 6) {
            char1 = '2';
        }
        else{
            char1 = '1';
        }

        if(y == 0) {
            char2 ='a';
        }
        else if(y == 1) {
            char2 = 'b';
        }
        else if(y == 2) {
            char2 = 'c';
        }
        else if(y == 3) {
            char2 = 'd';
        }
        else if(y == 4) {
            char2 = 'e';
        }
        else if(y == 5) {
            char2 = 'f';
        }
        else if(y == 6) {
            char2 = 'g';
        }
        else{
            char2 = 'h';
        }

        if(x + 2 == 0) {
            char3 ='8';
        }
        else if(x + 2 == 1) {
            char3 = '7';
        }
        else if(x + 2 == 2) {
            char3 = '6';
        }
        else if(x + 2 == 3) {
            char3 = '5';
        }
        else if(x + 2 == 4) {
            char3 = '4';
        }
        else if(x + 2 == 5) {
            char3 = '3';
        }
        else if(x + 2 == 6) {
            char3 = '2';
        }
        else{
            char3 = '1';
        }
        if(y + 2 == 0) {
            char4 ='a';
        }
        else if(y + 2 == 1) {
            char4 = 'b';
        }
        else if(y + 2 == 2) {
            char4 = 'c';
        }
        else if(y + 2 == 3) {
            char4 = 'd';
        }
        else if(y + 2 == 4) {
            char4 = 'e';
        }
        else if(y + 2 == 5) {
            char4 = 'f';
        }
        else if(y + 2 == 6) {
            char4 = 'g';
        }
        else{
            char4 = 'h';
        }
        // construct move
        moveCheck = "" + char1 + char2 + "-" + char3 + char4;

        if(game.legalMove(moveCheck)) { // if move is legal, a jump is available
            return true;
        }

        if(y - 2 == 0) {
            char4 ='a';
        }
        else if(y - 2 == 1) {
            char4 = 'b';
        }
        else if(y - 2 == 2) {
            char4 = 'c';
        }
        else if(y - 2 == 3) {
            char4 = 'd';
        }
        else if(y - 2 == 4) {
            char4 = 'e';
        }
        else if(y - 2 == 5) {
            char4 = 'f';
        }
        else if(y - 2 == 6) {
            char4 = 'g';
        }
        else{
            char4 = 'h';
        }
        // construct move
        moveCheck = "" + char1 + char2 + "-" + char3 + char4;

        if(game.legalMove(moveCheck)) { // if move is legal, jump is available
            return true;
        }
        return false; // if moves are not legal, no jump is available
    }

    /**Checker count method used to count number of checkers on gameboard
     * @param char player input either o or x depending on which player's checker you are checking
     * @param gameboard matrix used to parse through and count number of checkers
     * @return integer representing the count of checkers on the board of the given player
     */
    public int checkerCount(char player, char[][] gameboard) {
        int[] gameboardParse = new int[2]; // initialize parsing tool
        int checkerCount = 0; // initialize counter
        gameboardParse[0] = 0; // initialize parsing tool
        gameboardParse[1] = 0;
        if(player == 'o') { // if counting o checkers
            while(!(gameboardParse[0] == 7 && gameboardParse[1] == 7)) { // when the matrix has been parsed the tool will be equal to (7,7), loop until this is true
                if(gameboard[gameboardParse[0]][gameboardParse[1]] == 'o') { // if current checker is o
                    checkerCount++; // increment count
                }
                if(gameboardParse[1] != 7) { // increment tool
                    gameboardParse[1]++;
                }
                else {
                    gameboardParse[0]++;
                    gameboardParse[1] = 0;
                }
            }
            return checkerCount; // after whole board has been parsed, return count
        }
        else if(player == 'x') { // if counting x checkers
            while(!(gameboardParse[0] == 7 && gameboardParse[1] == 7)) { // when the matrix has been parsed the tool will be equal to (7,7), loop until this is true
                if(gameboard[gameboardParse[0]][gameboardParse[1]] == 'x') { // if current checker is x
                    checkerCount++; // increment count
                }
                if(gameboardParse[1] != 7) { // increment tool
                    gameboardParse[1]++;
                }
                else {
                    gameboardParse[0]++;
                    gameboardParse[1] = 0;
                }
            }
            return checkerCount; // after whole board has been parsed, return count
        }
        else { // if checking for player that does not exist, that player has 0 checkers
            return 0;
        }
    }
}
