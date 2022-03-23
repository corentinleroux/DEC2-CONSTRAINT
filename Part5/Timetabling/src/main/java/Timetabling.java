import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

import java.util.List;
import java.util.Random;

public class Timetabling {

    public static void main(String[] args) {
        Model model = new Model("Timetabling");
        System.out.println(model.getName());

        final int days = 5, max = 30;

        IntVar[] morning = new IntVar[days], afternoon = new IntVar[days];

        for (int i = 0; i < days; i++) {
            morning[i] = model.intVar("morning " + (i + 1), 0, 5);
            afternoon[i] = model.intVar("afternoon " + (i + 1), 0, 5);
        }

        for (int i = 0; i < days; i++) {
            model.ifThen(
                    model.arithm(morning[i], ">", 2),
                    model.arithm(afternoon[i], "<=", 2)
            );

            model.ifThen(
                    model.arithm(afternoon[i], ">", 2),
                    model.arithm(morning[i], "<=", 2)
            );
        }

        IntVar[] total = ArrayUtils.concat(morning, afternoon);

        model.sum(total, "=", max).post();

        List<Solution> solutions = model.getSolver().findAllSolutions();

        System.out.println("Amount of solutions : " + solutions.size() + "\nA random solution :");

        Solution solution = solutions.get(new Random().nextInt(solutions.size()));

        for (int i = 0; i < days; i++) {
            System.out.println(
                    morning[i].getName() + " = " + solution.getIntVal(morning[i])
                            + "\t| \t"
                            + afternoon[i].getName() + " = " + solution.getIntVal(afternoon[i]));
        }
    }
}
