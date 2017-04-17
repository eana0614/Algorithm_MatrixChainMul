#define _CRT_SECURE_NO_DEPRECATE

#include<stdio.h>
#include<stdlib.h>
#include<memory.h>
#include<limits.h>
#include<time.h>

int main(void);

void printAllMatrixSize(int size);
void fillElementP(int num);
void initCosts(int num);
void matrixChainMul(int size);
void printOptimalParens(int s, int e);


int *p = NULL;
int **cost = NULL;
int **smallCost = NULL;

int main(void) {

	int mode = 0;
	int matrixNum = 0;

	printf("!] 1.START         OTHER NUMBER.EXIT\n");
	printf("  >> INPUT MODE NUMBER = ");
	scanf("%d", &mode);

	while (mode == 1) {
		printf("\n!] INPUT TOTALL MATRIX NUMBER (3 OVER) = ");
		scanf("%d", &matrixNum);

		if (matrixNum < 3) {
			printf("!] WRONG NUMBER INPUT.\n");
			break;
		}

		fillElementP(matrixNum);
		initCosts(matrixNum);
		initCosts(matrixNum);

		printAllMatrixSize(matrixNum);

		matrixChainMul(matrixNum);

		printf("\nR] Small Cost Mul = ");
		printOptimalParens(1, matrixNum);
		printf("\nR] Small Cost Value = %d\n\n", cost[1][matrixNum]);

		printf("!] 1.START         OTHER NUMBER.EXIT\n");
		printf("  >> INPUT MODE NUMBER = ");
		scanf("%d", &mode);
	}

	printf("!] END\n");

}
void printOptimalParens(int s, int e) {
	if (s == e) {
		printf("A%d",s);
	}
	else {
		printf("(");
		printOptimalParens(s, smallCost[s][e]);
		printOptimalParens(smallCost[s][e] + 1, e);
		printf(")");
	}
}


void matrixChainMul(int size) {
	int n = size + 1;

	for (int i = 1; i < n; i++) {
		cost[i][i] = 0;
		smallCost[i][i] = i;
	}

	for (int l = 2; l < n; l++) {
		for (int i = 1; i < n - l + 1; i++) {
			int j = i + l - 1;
			cost[i][j] = INT_MAX;

			for (int k = i; k < j; k++) {
				int q = cost[i][k] + cost[k + 1][j] + p[i - 1] * p[k] * p[j];

				if (q < cost[i][j]) {
					cost[i][j] = q;
					smallCost[i][j] = k;
				}

			}
		}
	}
	
}

void initCosts(int num) {

	cost = (int**)malloc(sizeof(int*)* (num + 1));
	smallCost = (int**)malloc(sizeof(int*)* (num + 1));

	for (int i = 0; i <= num; i++) {
		cost[i] = (int*)malloc(sizeof(int)*(num+1));
		smallCost[i] = (int*)malloc(sizeof(int)*(num + 1));
		for (int j = 0; j <= num; j++) {
			cost[i][j] = -1;
			smallCost[i][j] = -1;
		}
	}

}

void printAllMatrixSize(int size) {
	int length = size;

	printf("-------------------------------\n");
		for (int i = 0; i < length; i++) {
			printf("     Matrix A%d = %d*%d\n", i + 1, p[i], p[i + 1]);
		}
	printf("-------------------------------\n");

}

void fillElementP(int num) {

	p = (int*)malloc(sizeof(int)*(num + 1));

	srand(time(NULL));
	for (int i = 0; i <= num; i++) {
		p[i] = (rand() % 20) + 1; //1~20
	}

}
