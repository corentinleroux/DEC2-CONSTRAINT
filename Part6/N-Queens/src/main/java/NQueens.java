import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.selectors.values.IntDomainRandom;
import org.chocosolver.solver.search.strategy.selectors.variables.FirstFail;
import org.chocosolver.solver.search.strategy.selectors.variables.InputOrder;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

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

        IntVar[] allValues = ArrayUtils.concat(rows, columns);

        System.out.println("1\t- default");
        System.out.println("2\t- dom over WDeg search");
        System.out.println("3\t- input order LB search");
        System.out.println("4\t- over main diagonal");
        System.out.println("5\t- over secondary diagonal");
        System.out.print("Choose the search strategy : ");
        final int S = new Scanner(System.in).nextInt();

        switch (S) {
            case 2:
                model.getSolver().setSearch(Search.domOverWDegSearch(allValues));
                break;
            case 3:
                model.getSolver().setSearch(Search.inputOrderLBSearch(allValues));
                break;
            case 4:
                model.getSolver().setSearch(
                        Search.intVarSearch(new InputOrder<>(model), new IntDomainRandom(1), diag1),
                        Search.intVarSearch(new FirstFail(model), new IntDomainRandom(1), allValues));
                break;
            case 5:
                model.getSolver().setSearch(
                        Search.intVarSearch(new InputOrder<>(model), new IntDomainRandom(1), diag2),
                        Search.intVarSearch(new FirstFail(model), new IntDomainRandom(1), allValues));
                break;
            default:
                break;
        }

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
