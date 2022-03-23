import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
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

        IntVar[] vector = new IntVar[]{}, diag = new IntVar[N];

        /* ROWS */
        for (int i = 0; i < N; i++) {
            model.sum(matrix[i], "=", SUM).post();
            vector = ArrayUtils.concat(vector, matrix[i]);
        }

        model.allDifferent(vector).post();

        vector = new IntVar[N];

        /* COLUMNS */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                vector[j] = matrix[j][i];
            }

            model.sum(vector, "=", SUM).post();
        }

        /* DIAGONALS */
        for (int i = 0; i < N; i++) {
            vector[i] = matrix[i][i];
            diag[i] = matrix[i][N - 1 - i];
        }

        model.sum(vector, "=", SUM).post();
        model.sum(diag, "=", SUM).post();

        Solution solution = model.getSolver().findSolution();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution.getIntVal(matrix[i][j]) + "\t");
            }

            System.out.println();
        }
    }
}
