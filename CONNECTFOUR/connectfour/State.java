package connectfour;

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_ROWS][Constants.BOARD_COLUMNS];

    public int getGameState() {
        return this.gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return this.whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return this.xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return this.oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row,int col) {
        if (row >= 0 && row < Constants.BOARD_ROWS) {
            if (col >= 0 && col < Constants.BOARD_COLUMNS) {
                return this.board[row][col]; 
            }
        } return 0;
    }

    public void setBoardCell(int col, int value) {
        if (col >= 0 && col <= Constants.BOARD_COLUMNS) {
            boolean columnFull = true;
            for (int row = Constants.BOARD_ROWS - 1; row >= 0; row--) {
                if (this.board[row][col] == Constants.BLANK) {
                    this.board[row][col] = value;
                    columnFull = false; // At least one empty cell found, so column is not full
                    break;
                }
            }
            if (columnFull) {
                System.out.println(Constants.COLUMN_FULL);
            }
        } else {
            System.out.println("Invalid column index.");
        }
    }

    public boolean isWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < Constants.BOARD_ROWS; i++) {
            for (int j = 0; j < Constants.BOARD_ROWS - 3; j++) {
                // Check rows
                if (board[i][j] == whoseMove && board[i][j+1] == whoseMove && board[i][j+2] == whoseMove && board[i][j+3] == whoseMove) {
                    return true;
                }
                // Check columns
                if (board[j][i] == whoseMove && board[j+1][i] == whoseMove && board[j+2][i] == whoseMove && board[j+3][i] == whoseMove) {
                    return true;
                }
                //Check diagonals

            }
        }

        // Check diagonals left to right
        for (int i = Constants.BOARD_ROWS - 1; i >= Constants.BOARD_ROWS - 3; i--) { 
            for (int j = 0; j < Constants.BOARD_ROWS - 2; j++) {
                if (board[i][j] == whoseMove && board[i-1][j+1] == whoseMove && board[i-2][j+2] == whoseMove && board[i-3][j+3] == whoseMove) {
                    return true;
                }
            }
        }
        //Check diagonals right to left
        for (int i = Constants.BOARD_ROWS - 1; i >= Constants.BOARD_ROWS - 3; i--) { 
            for (int j = Constants.BOARD_COLUMNS - 1; j >= Constants.BOARD_COLUMNS - 4; j--) {
                if (board[i][j] == whoseMove && board[i-1][j-1] == whoseMove && board[i-2][j-2] == whoseMove && board[i-3][j-3] == whoseMove) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTie() {
        // Check if all spaces on the board are filled
        for (int i = 0; i < Constants.BOARD_ROWS; i++) {
            for (int j = 0; j < Constants.BOARD_COLUMNS; j++) {
                if (board[i][j] == Constants.BLANK) {
                    return false; // There's an empty space, game is not a tie
                }
            }
        }

        // If no empty spaces are found, the game is a tie
        return true;
    }

    public State() {
        board = new int[Constants.BOARD_ROWS][Constants.BOARD_COLUMNS];
        // Initialize other variables as needed
    }

    // Other methods in the State class

    public void clearBoard() {
        for (int i = 0; i < Constants.BOARD_ROWS; i++) {
            for (int j = 0; j < Constants.BOARD_COLUMNS; j++) {
                board[i][j] = Constants.BLANK;
            }
        }
    }

    // Getter and setter methods
}