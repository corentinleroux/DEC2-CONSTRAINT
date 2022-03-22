import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Task;

public class exerciseCumulativeA {

    public static void main(String[] args) {
        Model model = new Model();

        Task[] tasks = new Task[]{
                new Task(model.intVar(1), 2, model.intVar(3)),
                new Task(model.intVar(2), 2, model.intVar(4)),
                new Task(model.intVar(4), 1, model.intVar(5))
        };

        IntVar[] heights = new IntVar[]{
                model.intVar(3),
                model.intVar(2),
                model.intVar(1)
        };

        System.out.println("1) " + model.cumulative(tasks, heights, model.intVar(4)).isSatisfied());

        tasks = new Task[]{
                new Task(model.intVar(1), 2, model.intVar(3)),
                new Task(model.intVar(4), 1, model.intVar(5)),
        };

        heights = new IntVar[]{
                model.intVar(1),
                model.intVar(2),
        };

        System.out.println("2) " + model.cumulative(tasks, heights, model.intVar(1)).isSatisfied());

        tasks = new Task[]{
                new Task(model.intVar(1), 2, model.intVar(3)),
                new Task(model.intVar(1), 2, model.intVar(3)),
                new Task(model.intVar(4), 1, model.intVar(6))
        };

        heights = new IntVar[]{
                model.intVar(0),
                model.intVar(4),
                model.intVar(1)
        };

        System.out.println("3) " + model.cumulative(tasks, heights, model.intVar(4)).isSatisfied());
    }
}
