import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Task;

import java.util.List;

public class CumulativeB {

    public static void main(String[] args) {
        Model model = new Model("Cumulative B");
        System.out.println(model.getName());

        Task[] tasks = new Task[]{
                new Task(
                        model.intVar("start 1", 1, 9),
                        model.intVar("duration 1", 1),
                        model.intVar("end 1", 1, 8)),
                new Task(
                        model.intVar("start 2", 1, 9),
                        model.intVar("duration 2", 2),
                        model.intVar("end 2", 1, 8)),
                new Task(
                        model.intVar("start 3", 1, 9),
                        model.intVar("duration 3", 3),
                        model.intVar("end 3", 1, 8)),
                new Task(
                        model.intVar("start 4", 1, 9),
                        model.intVar("duration 4", 4),
                        model.intVar("end 4", 1, 8))
        };

        IntVar[] heights = new IntVar[]{
                model.intVar("height 1", 1),
                model.intVar("height 2", 2),
                model.intVar("height 3", 5),
                model.intVar("height 4", 7)
        };

        model.cumulative(tasks, heights, model.intVar("limit", 7)).post();

        List<Solution> solutions = model.getSolver().findAllSolutions();

        System.out.println("Amount of solutions : " + solutions.size());
        solutions.forEach(System.out::println);
    }
}
