<p align="center">
  <img src="https://study-eu.s3.amazonaws.com/uploads/university/universit--paris-1-panth-on-sorbonne-479-logo.png">
</p>

# DEC2-CONSTRAINT - M2IKSEM

Here is my exercise for N-Queens problem.

## Description

## Questions

1. Is it **easy** to program ? 
> The problem is quite simple to program with two for loops to check the columns and rows and a recursion function to check the diagonals. 

2. Can it be **generalized** (for arbitrary size of problems) ? 
> The code is generelized to N-queens (even if not optimized
 
3. Is it **efficient** ? Does it **scale well** (in terms of executions) ? 
>  Not really, mainly because of the recursion function which increases the complexity of the program. I think there are much more efficient solutions. 

4. Measure execution time for different size problems.
> | Size | 6  | 8 | 10 | 11 | 12 |
> | :---:   | :-: | :-: | :-: | :-: | :-: |
> | 1st tentative | 0.25s | 3.32s | 24.52s | 6.87s | 571.81s |
> | 2nd tentative | 0.18s | 4.06s | 25.76s | 6.33s | 610.14s |
> | 3d tentative | 0.18s | 3.15s | 23.37s | 6.99s | 609.57s |
> | Average | 0.20s | 3.51s | 24.55s | 6.73s | 597.17s |
> | Multiplier | 1 | 18 | 123 | 34 | 2 986 |


## Navigation 
Here is all the exercices for my homework of DEC2-Constraint.


Back to main menu : [Main README]()

Other exercises : 

- [README of the exercise : TWO + TWO = FOUR](../TWO+TWO=FOUR)
- [README of the exercise : Magic Square](../Magic-Square)
