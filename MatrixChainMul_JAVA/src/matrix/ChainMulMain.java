package matrix;

import java.util.Scanner;

public class ChainMulMain {
	

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("====================================");
		System.out.println("| 1. START    OTHER NUMBER EXIT    |");
		System.out.println("====================================");
		System.out.print("!] INUPUT NUMBER = ");
		int mode = scanner.nextInt();
		scanner.nextLine();
		
		while(mode == 1){
			
			
			System.out.print("!] INPUT TOTALL MATRIX NUMBER (3 above )= ");
			int matrixNum = scanner.nextInt();
			scanner.nextLine();
			
			if(matrixNum < 3){
				System.out.println("!] WRONG NUMBER INPUT.");
				break;
			}
			MatrixMul mm = new MatrixMul(matrixNum);
			mm.printAllMatrixSize();
			
			mm.matrixChain();
			System.out.print("!] Small Cost Mul = ");
			mm.printOptimalParens(1, matrixNum);
	
			System.out.println("\n!] Small Cost Value = "+mm.costMin());
			System.out.println("\n");
			
			System.out.println("====================================");
			System.out.println("| 1. START    OTHER NUMBER EXIT    |");
			System.out.println("====================================");
			System.out.print("!] INUPUT NUMBER = ");
			mode = scanner.nextInt();
			scanner.nextLine();
			
		}
		
		System.out.println("!] END");
	}

}
