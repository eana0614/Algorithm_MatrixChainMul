package matrix;

import java.util.ArrayList;



public class MatrixMul {
	
	int p[];
	int[][] cost, smallCost;
	
	int MAX = 1000000;
	
	public MatrixMul(int num){
		int pNum = num+1;	
		
		p = new int[pNum];
		
		fillElementP();
		
	}
	
	public void printAllMatrixSize() {
		int length = p.length-1;
		
		System.out.println("------------------------------------");
		
		for(int i=0; i<length; i++){
			System.out.println("Matrix A"+(i+1)+" = "+p[i]+"x"+p[i+1]);
		}
		
		System.out.println("------------------------------------");
	}
	

	private void fillElementP() {
		
		for(int i=0; i<p.length; i++){
			double random = Math.random();
			int pValue = (int)(random * 20)+1; // Matrix Size = 1~20
			p[i] = pValue;
		}
		
	}


	public void printOptimalParens(int i, int j){
		if(i == j){
			System.out.print("A"+i);
		}else{
			System.out.print("(");
			printOptimalParens(i, smallCost[i][j]);
			printOptimalParens(smallCost[i][j]+1, j);
			System.out.print(")");
		}
	}
	
	public int costMin(){
		return cost[1][cost.length-1];
	}

	public void matrixChain() {
		
		initCostandShort();
		
		int n = cost.length;
		
		for(int i=1; i < n; i++){
			cost[i][i] = 0;
			smallCost[i][i] = i;
		}
		
		for(int l = 2; l < n; l++){
			for(int i=1; i < n-l+1; i++){
				int j = i+l-1;
				cost[i][j] = MAX;
				
				for(int k=i; k<j; k++){
					int q = cost[i][k] + cost[k+1][j] + p[i-1]*p[k]*p[j];
					if(q < cost[i][j]){
						cost[i][j] = q;
						smallCost[i][j] = k;
					}
				}
			}
		}
		
	}

	private void initCostandShort() {
		int length = p.length;
		cost = new int[length][length];
		smallCost = new int[length][length];
		
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				cost[i][j] = -1;
				smallCost[i][j] = -1;
			}
		}
		
	}


	

}
