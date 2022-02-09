import random
import time

# Verify if solution is valid
def check(t,w,o,f,u,r):
    rBoolean = r ==(o*2)%10
    uBoolean = u ==(w*2)%10 + (o*2)//10
    oBoolean = o == (t*2)%10 + (w*2)//10
    fBoolean = (f == (t*2)//10)
    return True if(rBoolean & uBoolean & oBoolean & fBoolean) else False 

# Generate random solution (not smart)
def findSolution():
    global T,W,O,F,U,R
    shuffle()
    test = check(T,W,O,F,U,R)
    while(test==False):
          shuffle()
          test = check(T,W,O,F,U,R)
    print("    ",T," ",W," ",O,"\n","+  ",T," ",W," ",O,"\n",
          "---------------","\n",F," ",O," ",U," ",R,"\n")
    return True

# Generate value for each variables
def shuffle():
    global T,W,O,F,U,R
    deck =  [0,2,3,4,5,6,7,8,9]
    random.shuffle(deck)
    T = deck.pop()
    W = deck.pop()
    O = deck.pop()
    U = deck.pop()
    R = deck.pop()
    F = 1
    
# Execute
start = time.time()
print("Starting...","\n")
findSolution()
end = time.time()
print("Execution time : ",round(end-start,2),"s")
