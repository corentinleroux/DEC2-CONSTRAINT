% Use this editor as a MiniZinc scratch book
include "alldifferent.mzn";

int: N;
set of int: DIM = 1..N;

array[DIM] of var DIM: rows;
array[DIM] of var DIM: columns;
array[DIM] of var int: diag1;
array[DIM] of var int: diag2;
array[DIM, DIM] of var 0..1: grid;

constraint alldifferent(rows);
constraint alldifferent(columns);
constraint alldifferent(diag1);
constraint alldifferent(diag2);
constraint forall (i in DIM) (diag1[i] = rows[i] + columns[i]);
constraint forall (i in DIM) (diag2[i] = N - rows[i] + columns[i]);
constraint forall (i in DIM) (grid[rows[i], columns[i]] = 1);

solve satisfy;
