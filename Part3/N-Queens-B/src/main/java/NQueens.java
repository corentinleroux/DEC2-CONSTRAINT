import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        Model model = new Model("N Queens");
        System.out.println(model.getName());

        System.out.print("Size of the square : ");
        final int N = new Scanner(System.in).nextInt(), MIN = 1;

        IntVar[] rows = model.intVarArray(N, MIN, N), columns = model.intVarArray(N, MIN, N);
        IntVar[] diag1 = new IntVar[N], diag2 = new IntVar[N];

        for (int i = 0; i < N; i++) {
            diag1[i] = model.sum("diag1", rows[i], columns[i]);
            diag2[i] = model.sum("diag2", model.intOffsetView(model.intMinusView(rows[i]), N), columns[i]);
        }

        model.allDifferent(rows).post();
        model.allDifferent(columns).post();
        model.allDifferent(diag1).post();
        model.allDifferent(diag2).post();

        Solution solution = model.getSolver().findSolution();

        boolean queenPosition;
        int y = 0;

        System.out.print(" \t");
        for (int i = 0; i < N; i++) {
            System.out.print((i + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < N; i++) {
            System.out.print((i + 1) + "\t");

            for (int j = 0; j < N; j++) {
                queenPosition = false;

                for (int k = 0; k < N; k++) {
                    if (solution.getIntVal(rows[k]) == (i + 1) && solution.getIntVal(columns[k]) == (j + 1)) {
                        y = j + 1;
                        queenPosition = true;
                    }
                }

                System.out.print((queenPosition ? "q" : "-") + "\t");
            }

            System.out.println("\t( " + (i + 1) + ", " + y + " )");
        }
    }
}
