
package devoirdesudoku;


import java.util.List;
import java.util.ArrayList;

public class SudokuSolver implements GameSolver {

    private IntegerBoard board;
    private IntegerBoard solution;
    private SimpleTree tree;

    public SudokuSolver(IntegerBoard board) {
        if (!(board instanceof IntegerBoard)) {
            throw new IllegalArgumentException("The board must be of type IntegerBoard for SudokuSolver.");
        }
        this.board = (IntegerBoard) board;
        this.solution = this.board.clone();
        this.tree = new SimpleTree(); // Using the inner class instead of Tree or AbstractTree
        this.tree.addRoot(this.board);
    }

    @Override
    public boolean solve() {
        if (board.getHeight() != board.getWidth() || board.getMaxSize() < board.getHeight() || board.getMaxSize() < board.getWidth() || board.getMaxSize() > board.getHeight() || board.getMaxSize() > board.getWidth()){
            return false;

        } else{
            if (solveBoard(tree.root())) {
                solution = board.clone();
                return true;
            }
            return false;
        }
    }

    @Override
    public void printSolution() {
        if (solve()) {
            System.out.println("Sudoku solved:");
            solution.display();
        } else {
            if (board.getHeight() != board.getWidth() || board.getMaxSize() < board.getHeight() || board.getMaxSize() < board.getWidth() || board.getMaxSize() > board.getHeight() || board.getMaxSize() > board.getWidth()){
                System.out.println("La taille de la grille n'est pas 9x9");
                return;
            } else {
                System.out.println("No solution exists for this puzzle.");
            }
        }
    }

    public boolean isValidPlacement(int row, int col, Integer value) {
        for (int i = 0; i < 9; i++) {
            if (board.getCell(row, i).equals(value) || board.getCell(i, col).equals(value)) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(startRow + i, startCol + j).equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solveBoard(Position<IntegerBoard> currentNode) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getCell(row, col) == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidPlacement(row, col, num)) {
                            board.setCell(row, col, num);
                            IntegerBoard newBoardState = board.clone();
                            Position<IntegerBoard> childNode = tree.addChild(currentNode, newBoardState);

                            if (solveBoard(childNode)) {
                                return true;
                            }

                            board.setCell(row, col, 0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Inner class to handle simple tree operations
    private class SimpleTree {

        private TreeNode root;

        // Adds a root node to the tree
        public Position<IntegerBoard> addRoot(IntegerBoard element) {
            if (root != null)
                throw new IllegalStateException("Tree already has a root.");
            root = new TreeNode(element, null);
            return root;
        }

        public Position<IntegerBoard> root() {
            return root;
        }

        public Position<IntegerBoard> addChild(Position<IntegerBoard> p, IntegerBoard element) {
            TreeNode parent = validate(p);
            TreeNode child = new TreeNode(element, parent);
            parent.children.add(child);
            return child;
        }

        private TreeNode validate(Position<IntegerBoard> p) {
            if (!(p instanceof TreeNode))
                throw new IllegalArgumentException("Invalid position");
            return (TreeNode) p;
        }

        private class TreeNode implements Position<IntegerBoard> {
            private IntegerBoard element;
            private TreeNode parent;
            private List<TreeNode> children = new ArrayList<>();

            public TreeNode(IntegerBoard element, TreeNode parent) {
                this.element = element;
                this.parent = parent;
            }

            @Override
            public IntegerBoard getElement() {
                return element;
            }
        }
    }
}
