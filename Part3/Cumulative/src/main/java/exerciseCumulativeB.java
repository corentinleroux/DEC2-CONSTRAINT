import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Task;

import java.util.List;

public class exerciseCumulativeB {

    public static void main(String[] args) {
        Model model = new Model();

        Task[] tasks = new Task[]{
                new Task(model.intVar(1, 9), 1, model.intVar(1, 8)),
                new Task(model.intVar(1, 9), 2, model.intVar(1, 8)),
                new Task(model.intVar(1, 9), 3, model.intVar(1, 8)),
                new Task(model.intVar(1, 9), 4, model.intVar(1, 8))
        };

        IntVar[] heights = new IntVar[]{
                model.intVar(1),
                model.intVar(2),
                model.intVar(5),
                model.intVar(7)
        };

        model.cumulative(tasks, heights, model.intVar(7)).post();

        Solver solver = model.getSolver();

        List<Solution> solutions = solver.findAllSolutions();

        System.out.println("Solutions amount : " + solutions.size());
        solutions.forEach(System.out::println);
    }
}
