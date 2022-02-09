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

## 4-queens, generalize to N-queens

Variables : ` `

Domains : ` `

Constraints : ` `
      
CSP = ` `

## Magic squares N

Variables : ` `

Domains : ` `

Constraints : ` `
      
CSP = ` `

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

COP = Minimize the number of returned coins (Sum of C values) : `COP : Minimize (C[2E] + C[1E] + C[50C] + C[20C] + C[10C] + C[5C])`

CSP = `( {C,A,S,D} , {N, N, N, N+} , {C1,C2,C3} ) + Minimize (C[2E] + C[1E] + C[50C] + C[20C] + C[10C] + C[5C]) `

## Stable matching

Variables : ` `

Domains : ` `

Constraints : ` `
      
CSP = ` `

Will probably be a COP to optimize the number of matches 
