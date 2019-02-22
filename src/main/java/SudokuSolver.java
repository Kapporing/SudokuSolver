import board.Board;

import java.io.IOException;
import java.util.Stack;

public abstract class SudokuSolver {

    public Board board;
    public SudokuSolver(String filepath) throws IOException {
        this.board = new Board(filepath);
    }
    public abstract Board solve();
}

class RecursiveSolver extends SudokuSolver {

    public RecursiveSolver(String s) throws IOException {
        super(s);
    }

    private Board solve(Board board) {
        if (board.isSolved()) {
            return board;
        } else {
            for (Board neighbor : board.getNeighbors()) {
                Board potentialSolution = solve(neighbor);
                if (potentialSolution != null) {
                    return potentialSolution;
                }
            }
        }

        return null;
    }

    public Board solve() {
        return solve(this.board);
    }
}

class DFSSolver extends SudokuSolver {

    public DFSSolver(String s) throws IOException {
        super(s);
    }

    public Board solve() {
        Board board = this.board;
        Stack<Board> stack = new Stack<>();
        stack.push(board);
        while(!stack.isEmpty()){
            Board b = stack.pop();
            if (b.isSolved()) {
                return b;
            }
            for(Board x : b.getNeighbors()){
                stack.push(x);
            }
        }
        return null;
    }
}






