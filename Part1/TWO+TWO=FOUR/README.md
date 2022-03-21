<p align="center">
  <img src="https://study-eu.s3.amazonaws.com/uploads/university/universit--paris-1-panth-on-sorbonne-479-logo.png">
</p>


# DEC2-CONSTRAINT - M2IKSEM

Here is my exercise TWO + TWO = FOUR.

## Description

I used Python for my script and the library "time" to check the execution time of my code. I first tried to generate fast a random solution (1 Solution Two.py) : 

![Resultat 1](Img/Capture%20d’écran%202022-02-10%20à%2009.06.09.png?raw=true)

But then i wanted a solution that is able to display all the solutions (All Solutions Two.py) :

![Solution 2](Img/Capture%20d’écran%202022-02-10%20à%2009.06.45.png?raw=true)

We can see that i decided to not write each conditions like T!=W & T!=O & T!=F and so on because i thought it was not really responsive in case i wanted to code the SEND+MORE=MONEY or any other problem of that kind. So i decided to create a list and to compare the size of the list with the size of unique value of the list. If its not the same, than it is not a solution. 

![Resultat 2](Img/Capture%20d’écran%202022-02-10%20à%2009.06.58.png?raw=true)

As we can see, it take much more time to run (mostly because of the list and because of all the print) but is more complete. 

## Questions

1. Is it **easy** to program ? 
> I think this problem was quite easy to program without any library.
2. Can it be **generalized** (for arbitrary size of problems) ? 
> I guess it could, but not in the way i did it, because i need a "for" for each unique letter of the problem.
3. Is it **efficient** ? Does it **scale well** (in terms of executions) ? 
> Not really. As we can see in next answer, each new letter increase the execution time by so much. 
4. Measure execution time for different size problems.
> | Size | 5 (Two+Two=Four)  | 8 (Send+More=Money) without 0 as first | 8 (Send+More=Money) with 0 as first |
> | :---:   | :-: | :-: | :-: |
> | 1st tentative | 3.17s | 277.22s | 359.03s |
> | 2nd tentative | 3.42s | 293.85s | 352.4s |
> | 3d tentative | 3.41s | 275.27s | 347.32s |
> | Average | 3.33s | 282.11s | 352.92s |
>
> It takes approximatly 85x more time with 3 more letters.  (106x if we want to display all solution even if they start with a 0, time increased by displaying, but its the same number of iteration).

## Navigation

Back to main menu : [Root directory](/./)

Other exercises : 

- [README of the exercise : N-Queens](../N-Queens)
- [README of the exercise : Magic Square](../Magic-Square)
