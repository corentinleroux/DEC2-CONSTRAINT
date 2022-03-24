import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.selectors.values.IntDomainRandom;
import org.chocosolver.solver.search.strategy.selectors.variables.FirstFail;
import org.chocosolver.solver.search.strategy.selectors.variables.InputOrder;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {
        Model model = new Model("Magic Square");
        System.out.println(model.getName());

        System.out.print("Size of the square : ");
        final int N = new Scanner(System.in).nextInt(), MIN = 1, MAX = N * N;

        IntVar SUM = model.intVar(MAX, MAX * N);

        IntVar[][] matrix = model.intVarMatrix(N, N, MIN, MAX);

        IntVar[] allValues = new IntVar[]{}, columns = new IntVar[N], diag1 = new IntVar[N], diag2 = new IntVar[N];

        /* ROWS */
        for (int i = 0; i < N; i++) {
            model.sum(matrix[i], "=", SUM).post();
            allValues = ArrayUtils.concat(allValues, matrix[i]);
        }

        model.allDifferent(allValues).post();

        /* COLUMNS */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                columns[j] = matrix[j][i];
            }

            model.sum(columns, "=", SUM).post();
        }

        /* DIAGONALS */
        for (int i = 0; i < N; i++) {
            diag1[i] = matrix[i][i];
            diag2[i] = matrix[i][N - 1 - i];
        }

        model.sum(diag1, "=", SUM).post();
        model.sum(diag2, "=", SUM).post();

        /* STRATEGY */
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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution.getIntVal(matrix[i][j]) + "\t");
            }

            System.out.println();
        }
    }
}
