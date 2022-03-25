% Use this editor as a MiniZinc scratch book
include "alldifferent.mzn";

int: N = 3;
int: MAX = N*N;
set of int: DIM = 1..N;
set of int: RANGE = 1..MAX;

array[RANGE, RANGE] of 0..MAX: base;
array[RANGE, RANGE] of var RANGE: grid;

base=[| 0, 0, 0, 0, 0, 0, 0, 0, 0
      | 0, 6, 8, 4, 0, 1, 0, 7, 0
      | 0, 0, 0, 0, 8, 5, 0, 3, 0
      | 0, 2, 6, 8, 0, 9, 0, 4, 0
      | 0, 0, 7, 0, 0, 0, 9, 0, 0
      | 0, 5, 0, 1, 0, 6, 3, 2, 0
      | 0, 4, 0, 6, 1, 0, 0, 0, 0
      | 0, 3, 0, 2, 0, 7, 6, 9, 0
      | 0, 0, 0, 0, 0, 0, 0, 0, 0
      |];
      
constraint forall (i, j in RANGE) (if base[i, j] > 0 then grid[i, j] = base[i, j] else true endif);
constraint forall (i in RANGE) (alldifferent( [ grid[i, j] | j in RANGE ] ));
constraint forall (j in RANGE) (alldifferent( [ grid[i, j] | i in RANGE ] ));
constraint forall (a, b in DIM) (alldifferent( [ grid[(a * N) - x + 1, (b * N) - y + 1] | x, y in DIM ]));

solve satisfy;
