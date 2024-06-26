import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

// 「数独.pdf」のQuestion88

public class SudokuProblemHard88 {

	public static void main(String[] args) {
		Model model = new Model("Latin Square of Order 9");
		IntVar[][] x = model.intVarMatrix("x", 9, 9, 1, 9);
		
		for(int i=0; i<9; i++) {
			IntVar[] vars = {x[i][0], x[i][1], x[i][2], x[i][3], x[i][4], x[i][5], x[i][6], x[i][7], x[i][8]};
			model.allDifferent(vars).post(); // 各行で相異なる値をとる
		}
		
		for(int i=0; i<9; i++) {
			IntVar[] vars = {x[0][i], x[1][i], x[2][i], x[3][i], x[4][i], x[5][i], x[6][i], x[7][i], x[8][i]};
			model.allDifferent(vars).post(); // 各列で相異なる値をとる
		}

// 変数に特定の値を割り当てる			
		model.arithm(x[1][1], "=", 6).post();
		model.arithm(x[1][2], "=", 5).post();
		model.arithm(x[2][0], "=", 2).post();

		model.arithm(x[0][3], "=", 4).post();
		model.arithm(x[1][4], "=", 8).post();
		model.arithm(x[2][4], "=", 1).post();

		model.arithm(x[0][6], "=", 7).post();
		model.arithm(x[1][7], "=", 2).post();
		model.arithm(x[2][7], "=", 8).post();

		model.arithm(x[4][1], "=", 7).post();
		model.arithm(x[4][2], "=", 8).post();
		model.arithm(x[5][0], "=", 5).post();

		model.arithm(x[3][8], "=", 2).post();
		model.arithm(x[4][6], "=", 9).post();
		model.arithm(x[4][7], "=", 3).post();

		model.arithm(x[6][1], "=", 3).post();
		model.arithm(x[7][1], "=", 4).post();
		model.arithm(x[8][2], "=", 9).post();

		model.arithm(x[6][4], "=", 5).post();
		model.arithm(x[7][4], "=", 7).post();
		model.arithm(x[8][5], "=", 1).post();

		model.arithm(x[6][8], "=", 4).post();
		model.arithm(x[7][6], "=", 3).post();
		model.arithm(x[7][7], "=", 1).post();

// 各ブロックで相異なる値をとる

		IntVar[] vars0 = {x[0][0], x[0][1], x[0][2], x[1][0], x[1][1], x[1][2], x[2][0], x[2][1], x[2][2]};
			model.allDifferent(vars0).post();

		IntVar[] vars1 = {x[0][3], x[0][4], x[0][5], x[1][3], x[1][4], x[1][5], x[2][3], x[2][4], x[2][5]};
			model.allDifferent(vars1).post();

		IntVar[] vars2 = {x[0][6], x[0][7], x[0][8], x[1][6], x[1][7], x[1][8], x[2][6], x[2][7], x[2][8]};
			model.allDifferent(vars2).post();

		IntVar[] vars3 = {x[3][0], x[3][1], x[3][2], x[4][0], x[4][1], x[4][2], x[5][0], x[5][1], x[5][2]};
			model.allDifferent(vars3).post();

		IntVar[] vars4 = {x[3][3], x[3][4], x[3][5], x[4][3], x[4][4], x[4][5], x[5][3], x[5][4], x[5][5]};
			model.allDifferent(vars4).post();

		IntVar[] vars5 = {x[3][6], x[3][7], x[3][8], x[4][6], x[4][7], x[4][8], x[5][6], x[5][7], x[5][8]};
			model.allDifferent(vars5).post();

		IntVar[] vars6 = {x[6][0], x[6][1], x[6][2], x[7][0], x[7][1], x[7][2], x[8][0], x[8][1], x[8][2]};
			model.allDifferent(vars6).post();

		IntVar[] vars7 = {x[6][3], x[6][4], x[6][5], x[7][3], x[7][4], x[7][5], x[8][3], x[8][4], x[8][5]};
			model.allDifferent(vars7).post();

		IntVar[] vars8 = {x[6][6], x[6][7], x[6][8], x[7][6], x[7][7], x[7][8], x[8][6], x[8][7], x[8][8]};
			model.allDifferent(vars8).post();

		// Find a solution
		Solution solution = model.getSolver().findSolution();
		if (solution != null) {
			System.out.println(solution.toString());
		}
	}

}
