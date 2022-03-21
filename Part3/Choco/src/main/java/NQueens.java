import java.util.Scanner;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class NQueens {

    private static Scanner reader;

	public void modelAndSolve(int nqueen, boolean allsolutions){
    	System.out.println("-----------------------------------");
    	System.out.println("Starting "+nqueen+"-queen solver... \n");
        int n = nqueen;
        Model model = new Model(n + "-queens problem");
        IntVar[] vars = new IntVar[n];
        for(int q = 0; q < n; q++){
            vars[q] = model.intVar("Q_"+q, 1, n);
        }
        for(int i  = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                model.arithm(vars[i], "!=",vars[j]).post();
                model.arithm(vars[i], "!=", vars[j], "-", j - i).post();
                model.arithm(vars[i], "!=", vars[j], "+", j - i).post();
            }
        }
        if (allsolutions){
        	AllSolution(model,n);
        } else {
            OneSolution(model, n);
        }
        
        System.out.println("\n-----------------------------------");
    }
    
	// Display One Solution
    public void OneSolution(Model m, int nqueen) {
    	Solution solution = m.getSolver().findSolution();
    	if(solution != null){
            System.out.println("One solution for "+nqueen+"-queens problem :");
            System.out.println(solution.toString());
        }
    	System.out.println("\nStatistics : \n");
    	m.getSolver().printStatistics();
    	
    }
    
    // Display All Solutions
    public void AllSolution(Model m, int nqueen) {
    	Solver solver = m.getSolver();
        Solution solution = new Solution(m);
        System.out.println("");
        System.out.println("All solutions for "+nqueen+"-queens problem : \n");
	    while (solver.solve()) {
	    	 solution.record();
	         System.out.println(solution);
	     }
	    System.out.println("\nStatistics : \n");
	    solver.printStatistics();
    }

    public static void main(String[] args) {
    	 reader = new Scanner(System.in); 
    	 System.out.println("Enter number of Queens :");
    	 int nqueens = reader.nextInt();
    	 System.out.println("Do you want all solutions ? (True/False)");
    	 boolean allsol = reader.nextBoolean();
         new NQueens().modelAndSolve(nqueens, allsol);
        
    }

}