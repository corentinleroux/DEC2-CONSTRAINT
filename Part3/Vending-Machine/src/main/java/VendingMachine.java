import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {
        Model model = new Model("Vending Machine");
        System.out.println(model.getName());

        int[] money = new int[]{
                5,
                10,
                20,
                50,
                100,
                200
        };

        int[] fund = new int[]{
                52,
                25,
                40,
                30,
                11,
                3
        };

        IntVar[] change = new IntVar[]{
                model.intVar("0.05€", 0, fund[0]),
                model.intVar("0.10€", 0, fund[1]),
                model.intVar("0.20€", 0, fund[2]),
                model.intVar("0.50€", 0, fund[3]),
                model.intVar("1€", 0, fund[4]),
                model.intVar("2€", 0, fund[5])
        };

        System.out.print("Your money (in cents) : ");
        final int T = new Scanner(System.in).nextInt();

        System.out.print("Price of your drink (in cents) : ");
        final int P = new Scanner(System.in).nextInt();

        model.scalar(change, money, "=", model.intVar(T - P)).post();

        List<Solution> solutions = model.getSolver().findAllSolutions();

        System.out.println("Change : " + (T - P));
        System.out.println("Amount of solutions : " + solutions.size());
        solutions.forEach(System.out::println);
    }
}
