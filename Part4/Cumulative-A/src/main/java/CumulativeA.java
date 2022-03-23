import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Task;

public class CumulativeA {

    public static void main(String[] args) {
        Model model = new Model("Cumulative A");
        System.out.println(model.getName());

        Task[] tasks = new Task[]{
                new Task(
                        model.intVar("start 1", 1),
                        model.intVar("duration 1", 2),
                        model.intVar("end 1", 3)),
                new Task(
                        model.intVar("start 2", 2),
                        model.intVar("duration 2", 2),
                        model.intVar("end 2", 4)),
                new Task(
                        model.intVar("start 3", 4),
                        model.intVar("duration 3", 1),
                        model.intVar("end 3", 5))
        };

        IntVar[] heights = new IntVar[]{
                model.intVar("height 1", 3),
                model.intVar("height 2", 2),
                model.intVar("height 3", 1)
        };

        System.out.println("1) " + model.cumulative(tasks, heights, model.intVar("limit", 4)).isSatisfied());

        tasks = new Task[]{
                new Task(
                        model.intVar("start 1", 1),
                        model.intVar("duration 1", 2),
                        model.intVar("end 1", 3)),
                new Task(
                        model.intVar("start 2", 4),
                        model.intVar("duration 2", 1),
                        model.intVar("end 2", 5)),
        };

        heights = new IntVar[]{
                model.intVar("height 1", 1),
                model.intVar("height 2", 2),
        };

        System.out.println("2) " + model.cumulative(tasks, heights, model.intVar("limit", 1)).isSatisfied());

        tasks = new Task[]{
                new Task(
                        model.intVar("start 1", 1),
                        model.intVar("duration 1", 2),
                        model.intVar("end 1", 3)),
                new Task(
                        model.intVar("start 2", 1),
                        model.intVar("duration 2", 2),
                        model.intVar("end 2", 3)),
                new Task(
                        model.intVar("start 3", 4),
                        model.intVar("duration 3", 1),
                        model.intVar("end 3", 6))
        };

        heights = new IntVar[]{
                model.intVar("height 1", 0),
                model.intVar("height 2", 4),
                model.intVar("height 3", 1)
        };

        System.out.println("3) " + model.cumulative(tasks, heights, model.intVar("limit", 4)).isSatisfied());
    }
}
