<p align="center">
  <img src="https://study-eu.s3.amazonaws.com/uploads/university/universit--paris-1-panth-on-sorbonne-479-logo.png">
</p>


# DEC2-CONSTRAINT - M2IKSEM

Back to main menu : [Main README](https://github.com/corentinleroux/dec2-constraint/)

## Part 2 - Modeling Exercices
Here is all the exercices for my homework of DEC2-Constraint.

CSP : P = (V, D, C) 

- P = Variables
- D = Domains
- C = Constraints 
      
## SEND + MORE = MONEY

Variables : `{S, E, N, D, M, O, R, Y}`

Domains : `{0...9, 0...9, 0...9, 0...9, 0...9, 0...9, 0...9, 0...9}`

Constraints : `{allDifferent(S, E, N, D, M, O, R, Y) ∧ ( (1000*S + 100*E + 10*N + D) + (1000*M + 100*O + 10*R + E) = (10000*M + 1000*O + 100*N + 10*E + Y))}`
      
CSP = `( {S, E, N, D, M, O, R, Y} , {0...9, 0...9, 0...9, 0...9, 0...9, 0...9, 0...9, 0...9} , {allDifferent(S, E, N, D, M, O, R, Y) ∧ ( (1000*S + 100*E + 10*N + D) + (1000*M + 100*O + 10*R + E) = (10000*M + 1000*O + 100*N + 10*E + Y))})`

## 4-queens, generalized to N-queens

Variables : `{N (number of Queens and size of the board), Board[N][N]}`

Domains : `N ∈ N+`

Constraints :

- `C1 means only 1 queen by column`

- `C2 means only 1 queen by row`

- `C3 means only 1 queen by diagonale `

- `C1 : ∑(j=1, n) Board[i][j] == 1 `

- `C2 : ∑(i=1, n) Board[i][j] == 1`

- `C3 : ∑(i,j=1, n) Board[i+1][j+1] + Board[i-1][j-1] == 1  `

- `C4 : N > 3`

CSP = `( {N, Board[N][N]} , {N+,N} , {C1,C2,C3,C4 } )`


## Magic squares N

Variables : `{N (size of the problem), M (magic constant), Board[N][N] }`

Domains : `{N0, N+, N0}`

Constraints : ``

- `C2 means sum of colum must equal M`
- `C3 means sum of row must equal M`
- `C4 means sum of diagonal must equal M`
- `C5 means all numbers of the board must be different`

- `C1 : M == N(N^2+1) / 2`
- `C2 : `∑(j=1, n) Board[i][j] == M `
- `C3 : `∑(j=1, n) Board[i][j] == M`
- `C4 : ∑(i,j=1, n) Board[i+1][j+1] + Board[i-1][j-1] == M`
- `C5 : allDifferent(Board[i][j] for i,j in N)`
      
CSP = `( {N, M, Board[N][N]} , {N0, N+, N0} , {C1, C2, C3, C4, C5} )`


## Vending machine

I take the assumption that all is calculated on the euro basis.

Variables : `{C, A, S, D} `

- C[2E,1E,50C,20C,10C,5C] = Returning number of coin for each type of coin
- A[2E,1E,50C,20C,10C,5C] = Amount of coin inserted for each type of coin
- S[2E,1E,50C,20C,10C,5C] = Number of coin available of each type 
- D = Product cost

Domains : `{N0, N0, N0, N+} `

Constraints : ` {C1, C2, C3}`

C1 means user have to insert amount > to price

C2 means we should return the différence between what is insert and the price

C3 means we cant give back more pieces than what we have in stock

- `C1 : A[2E]*2 + A[1E]*1 + A[50C]*0.5 A[20C]*0.2 + A[10C]*0.1  + A[10C]*0.1 + A[5C]*0.5 >= D`
- `C2 : C[2E]*2 + C[1E]*1 + C[50C]*0.5 C[20C]*0.2 + c[10C]*0.1  + c[10C]*0.1 + c[5C]*0.5 = D - A[2E]*2 + A[1E]*1 + A[50C]*0.5 A[20C]*0.2 + A[10C]*0.1  + A[10C]*0.1 + A[5C]*0.5`
- `C3 : C[i] <= A[i] + S[i] for i in (2E,1E,50C,20C,10C,5C)`      

COP = Minimize the number of returned coins (Sum of C values) : `COP : Minimize (∑C[i] i ∈ [2E,1E,50C,20C,10C,5C]) ou Minimize (C[2E] + C[1E] + C[50C] + C[20C] + C[10C] + C[5C]) (présentation différente)`


COP = `( {C,A,S,D} , {N, N, N, N+} , {C1,C2,C3} ) +  Minimize (∑C[i] i ∈ [2E,1E,50C,20C,10C,5C])`

## Stable matching

Variables : `Wi (the wife of a given man i) , Hj (the husband of woman j), ManTable[x][y], WomanTable[y][x], y (number of woman) , x (number of man) `

Domains : ` `

Constraints : `Hj `
      
CSP = ` `

Will probably be a COP to optimize the number of matches 
