import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

import java.util.List;

public class SEND_MORE_MONEY {

    public static void main(String[] args) {
        Model model = new Model("SEND + MORE = MONEY");
        System.out.println(model.getName());

        IntVar S = model.intVar("S", 1, 9);
        IntVar E = model.intVar("E", 0, 9);
        IntVar N = model.intVar("N", 0, 9);
        IntVar D = model.intVar("D", 0, 9);
        IntVar M = model.intVar("M", 1, 9);
        IntVar O = model.intVar("O", 0, 9);
        IntVar R = model.intVar("R", 0, 9);
        IntVar Y = model.intVar("Y", 0, 9);

        model.allDifferent(S, E, N, D, M, O, R, Y).post();

        IntVar[] vars = new IntVar[]{
                S, E, N, D,
                M, O, R, E,
                M, O, N, E, Y
        };

        int[] coeffs = new int[]{
                1000, 100, 10, 1,
                1000, 100, 10, 1,
                -10000, -1000, -100, -10, -1
        };

        model.scalar(vars, coeffs, "=", 0).post();

        List<Solution> solutions = model.getSolver().findAllSolutions();

        System.out.println("Amount of solutions : " + solutions.size());
        solutions.forEach(System.out::println);
    }
}
