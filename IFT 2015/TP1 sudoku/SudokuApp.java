package devoirdesudoku;



/**
 * Sudoku application (Main class)
 *
 * @author Morteza Mahdiani (for TP1-IFT2015-A24)
 * @author modified by Francois Major, on 24.10.25)
 * 
 * @version 1.1 (25 october 2024)
 * @since 1.0 (22 October 2024)
 */

public class SudokuApp {

    public void testCase1() {
        Integer[][] puzzle = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        IntegerBoard board = new IntegerBoard(puzzle);
        SudokuSolver solver = new SudokuSolver(board);

        if (solver.solve()) {
            System.out.println("Test Case 1: Sudoku Solved:");
            solver.printSolution();
        } else {
            System.out.println("Test Case 1: No solution exists.");
        }
    }

    public void testCase2() {
        Integer[][] puzzle = {
                { 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 4, 0, 3, 0, 0, 5, 0, 0, 0 },
                { 0, 0, 0, 0, 3, 0, 0, 6, 0 },
                { 0, 5, 0, 4, 6, 0, 0, 0, 0 },
                { 0, 0, 0, 3, 0, 8, 0, 0, 0 },
                { 0, 0, 0, 0, 9, 7, 0, 8, 0 },
                { 0, 6, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 5, 0, 0, 2, 0, 9 },
                { 0, 8, 0, 0, 0, 0, 0, 0, 0 }
        };

        IntegerBoard board = new IntegerBoard(puzzle);
        SudokuSolver solver = new SudokuSolver(board);

        if (solver.solve()) {
            System.out.println("Test Case 2: Sudoku Solved:");
            solver.printSolution();
        } else {
            System.out.println("Test Case 2: No solution exists.");
        }
    }

    public void testCase3() {
        Integer[][] puzzle = {
                { 5, 1, 6, 8, 4, 9, 7, 3, 2 },
                { 3, 0, 7, 6, 0, 5, 0, 0, 0 },
                { 8, 0, 9, 7, 0, 0, 0, 6, 5 },
                { 1, 3, 5, 0, 6, 0, 9, 0, 7 },
                { 4, 7, 2, 5, 9, 1, 0, 0, 6 },
                { 9, 6, 8, 3, 7, 0, 0, 5, 0 },
                { 2, 5, 3, 1, 8, 6, 0, 7, 4 },
                { 6, 8, 4, 2, 0, 7, 5, 0, 0 },
                { 7, 9, 1, 0, 5, 0, 6, 0, 0 }
        };

        IntegerBoard board = new IntegerBoard(puzzle);
        SudokuSolver solver = new SudokuSolver(board);

        if (solver.solve()) {
            System.out.println("Test Case 3: Sudoku Solved:");
            solver.printSolution();
        } else {
            System.out.println("Test Case 3: No solution exists.");
        }
    }

    public void testCase4() {
        Integer[][] puzzle = new Integer[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 0, 0, 0, 0, 0, 0, 6, 0, 0 },
                { 0, 0, 0, 5, 0, 9, 0, 0, 0 },
                { 6, 0, 0, 0, 4, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 0, 0, 0, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 3, 0 },
                { 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 7, 0, 0, 0, 0 },
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 }
        };

        IntegerBoard board = new IntegerBoard(puzzle); // Explicitly parameterize as GameBoard<Integer>
        SudokuSolver solver = new SudokuSolver(board);

        if (solver.solve()) {
            System.out.println("Test Case 4: Sudoku Solved:");
            solver.printSolution();
        } else {
            System.out.println("Test Case 4: No solution exists.");
        }
    } 

     public static void main(String[] args) {
        SudokuApp test = new SudokuApp();
        test.testCase1();
        test.testCase2();
        test.testCase3();
        test.testCase4();
    }
}
/* public class SudokuApp {
    public SudokuApp() {
    }
 
    public void testCase1() {
       System.out.println("*** Test Case 1 ***");
       Integer[][] var1 = new Integer[][]{{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
       IntegerBoard var2 = new IntegerBoard(var1);
       SudokuSolver var3 = new SudokuSolver(var2);
       var3.solve();
       var3.printSolution();
    }
 
    public void testCase2() {
       System.out.println("*** Test Case 2 ***");
       Integer[][] var1 = new Integer[][]{{0, 0, 0, 0, 0, 0, 0, 1, 0}, {4, 0, 3, 0, 0, 5, 0, 0, 0}, {0, 0, 0, 0, 3, 0, 0, 6, 0}, {0, 5, 0, 4, 6, 0, 0, 0, 0}, {0, 0, 0, 3, 0, 8, 0, 0, 0}, {0, 0, 0, 0, 9, 7, 0, 8, 0}, {0, 6, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 5, 0, 0, 2, 0, 9}, {0, 8, 0, 0, 0, 0, 0, 0, 0}};
       IntegerBoard var2 = new IntegerBoard(var1);
       SudokuSolver var3 = new SudokuSolver(var2);
       var3.solve();
       var3.printSolution();
    }
 
    public void testCase3() {
       System.out.println("*** Test Case 3 ***");
       Integer[][] var1 = new Integer[][]{{5, 1, 6, 8, 4, 9, 7, 3, 2}, {3, 0, 7, 6, 0, 5, 0, 0, 0}, {8, 0, 9, 7, 0, 0, 0, 6, 5}, {1, 3, 5, 0, 6, 0, 9, 0, 7}, {4, 7, 2, 5, 9, 1, 0, 0, 6}, {9, 6, 8, 3, 7, 0, 0, 5, 0}, {2, 5, 3, 1, 8, 6, 0, 7, 4}, {6, 8, 4, 2, 0, 7, 5, 0, 0}, {7, 9, 1, 0, 5, 0, 6, 0, 0}};
       IntegerBoard var2 = new IntegerBoard(var1);
       SudokuSolver var3 = new SudokuSolver(var2);
       var3.solve();
       var3.printSolution();
    }
 
    public void testCase4() {
       System.out.println("*** Test Case 4 ***");
       Integer[][] var1 = new Integer[][]{{0, 0, 0, 0, 0, 0, 0, 0, 2}, {0, 0, 0, 0, 0, 0, 6, 0, 0}, {0, 0, 0, 5, 0, 9, 0, 0, 0}, {6, 0, 0, 0, 4, 0, 0, 0, 0}, {0, 7, 0, 0, 0, 0, 0, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 3, 0}, {9, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 7, 0, 0, 0, 0}, {0, 0, 8, 0, 0, 0, 0, 0, 0}};
       IntegerBoard var2 = new IntegerBoard(var1);
       SudokuSolver var3 = new SudokuSolver(var2);
       var3.solve();
       var3.printSolution();
    }
 
    public void testCase5() {
       System.out.println("*** Test Case 5 ***:");
       Integer[][] var1 = new Integer[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {9, 0, 0, 0}, {6, 0, 0, 0}, {0, 0, 0, 0}};
       IntegerBoard var2 = new IntegerBoard(var1);
       SudokuSolver var3 = new SudokuSolver(var2);
       var3.solve();
       var3.printSolution();
    }
 
    public static void main(String[] var0) {
       SudokuApp var1 = new SudokuApp();
       var1.testCase1();
       var1.testCase2();
       var1.testCase3();
       var1.testCase4();
       var1.testCase5();
    }
} */
