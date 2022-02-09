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
      
`CSP = ( {S, E, N, D, M, O, R, Y} , {0...9, 0...9, 0...9, 0...9, 0...9, 0...9, 0...9, 0...9} , {allDifferent(S, E, N, D, M, O, R, Y) ∧ ( (1000*S + 100*E + 10*N + D) + (1000*M + 100*O + 10*R + E) = (10000*M + 1000*O + 100*N + 10*E + Y))})`

## 4-queens, generalize to N-queens

Variables : ` `

Domains : ` `

Constraints : ` `
      
`CSP = `

## Magic squares N

Variables : ` `

Domains : ` `

Constraints : ` `
      
`CSP = `

## Vending machine

Variables : ` `

Domains : ` `

Constraints : ` `
      
`CSP = `

## Stable matching

Variables : ` `

Domains : ` `

Constraints : ` `
      
`CSP = `

Will probably be a COP to optimize the number of matches 
