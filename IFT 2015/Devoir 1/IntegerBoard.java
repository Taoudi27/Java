package devoirdesudoku;




public class IntegerBoard implements GameBoard<Integer> {
    private Integer[][] board;
    private static final int size = 9;

    // Default constructor for an empty 9x9 board
    /* public IntegerBoard() {
        board = new Integer[size][size];
    } */

    // Constructor that accepts an initial board setup
    public IntegerBoard(Integer[][] initialBoard) {
        /* this(); */
        this.board = initialBoard;
        if (initialBoard.length != initialBoard[0].length || size < initialBoard.length || size < initialBoard[0].length || size > initialBoard.length || size > initialBoard[0].length){
        return;
        }
        for (int i = 0; i < size; i++) {
            System.arraycopy(initialBoard[i], 0, board[i], 0, size);
            }

        }
    

    // Methods required by GameBoard interface
    public Integer getCell(int x, int y) {
        return board[x][y];
    }

    public void setCell(int x, int y, Integer value) {
        board[x][y] = value;
    }

    public int getWidth() {
        return board[0].length;
    }

    public int getHeight() {
        return board.length;
    }

    public int getMaxSize() {
        return size;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((board[i][j] != null ? board[i][j] : ".") + " ");
            }
            System.out.println();
        }
    }

    // Method to clone the board
    public IntegerBoard clone() {
        Integer[][] newBoard = new Integer[board.length][];
        for (int i = 0; i < board.length; i++) {
            /* System.arraycopy(this.board[i], 0, newBoard[i], 0, size); */
            newBoard[i] = board[i].clone();
        }
        return new IntegerBoard(newBoard);
    }
}
