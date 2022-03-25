% Use this editor as a MiniZinc scratch book
include "alldifferent.mzn";

int: N;
int: MAX = N*N;
set of int: DIM = 1..N;

var MAX..(MAX*N): SUM;
array[DIM, DIM] of var 1..MAX: matrix;

constraint alldifferent(matrix);
constraint forall (row in DIM) (sum (column in DIM) (matrix[row, column]) = SUM);
constraint forall (column in DIM) (sum (row in DIM) (matrix[row, column]) = SUM);
constraint sum (diag in DIM) (matrix[diag, diag]) = SUM;
constraint sum (diag in DIM) (matrix[N-diag+1, diag]) = SUM;

solve satisfy;
