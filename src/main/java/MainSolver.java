import java.io.IOException;

public class MainSolver {
    public static void main(String [] args) throws IOException {
        SudokuSolver s = new RecursiveSolver("src/test/resources/trivial_puzzle.sdk");
        SudokuSolver s2 = new DFSSolver("src/test/resources/trivial_puzzle.sdk");
        System.out.println(s2.board);
        long t1 = System.nanoTime();
        System.out.println(s2.solve());
        long t2 = System.nanoTime();
        System.out.println(s.solve());
        long t3 = System.nanoTime();
        System.out.println("Time for Recursive Solution: " + String.valueOf(t2 - t1));
        System.out.println("Time for Iterative Solution: " + String.valueOf(t3 - t2));
    }
    /* The DFS Solver runs faster than the recursive solver.
     I'm guessing it runs faster because it doesn't have to
     get neighbors for every possible combination. */
}
