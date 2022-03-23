import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

import java.util.List;

public class TWO_TWO_FOUR {

    public static void main(String[] args) {
        Model model = new Model("TWO + TWO = FOUR");
        System.out.println(model.getName());

        IntVar T = model.intVar("T", 1, 9);
        IntVar W = model.intVar("W", 0, 9);
        IntVar O = model.intVar("O", 0, 9);
        IntVar F = model.intVar("F", 1, 9);
        IntVar U = model.intVar("U", 0, 9);
        IntVar R = model.intVar("R", 0, 9);

        model.allDifferent(T, W, O, F, U, R).post();

        IntVar[] vars = new IntVar[]{
                T, W, O,
                T, W, O,
                F, O, U, R
        };

        int[] coeffs = new int[]{
                100, 10, 1,
                100, 10, 1,
                -1000, -100, -10, -1
        };

        model.scalar(vars, coeffs, "=", 0).post();

        List<Solution> solutions = model.getSolver().findAllSolutions();

        System.out.println("Amount of solutions : " + solutions.size());
        solutions.forEach(System.out::println);
    }
}
