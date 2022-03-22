import time

def two_problem():
    s= 0
    for T in range (10):
        for W in range (10):
            for O in range (10):
                for F in range (1,10):
                    for U in range (10):
                        for R in range(10):
                            x = []
                            x.extend((str(T),str(W),str(O),str(F),str(U),str(R)))
                            if (len(x)!=len(set(x))):
                                continue;
                            elif (200*T + 20*W + 2*O == 1000*F + 100*O + 10*U + 1*R) :
                                s+=1 
                                print("Solution ",s," : ",T,W,O," + ",T,W,O," = ",F,O,U,R,sep="")
                                break;
    print("\nThere is ",s," solutions.")


print("Starting Two + Two = Four ...")
start = time.time()
two_problem()
end = time.time()
print("Execution time : ", round(end-start,2),"s")
print("--------------------------")


def send_more(y):
    s= 0
    for S in range (y,10):
        for E in range (10):
            for N in range (10):
                for D in range (10):
                    for M in range (y,10):
                        for O in range(10):
                            for R in range(10):
                                for Y in range(10):
                                    x = []
                                    x.extend((str(S),str(E),str(N),str(D),str(M),str(O),str(R),str(Y)))
                                    # Check if some letter have same value 
                                    if (len(x)!=len(set(x))):
                                        continue;
                                    # Check if SEND + MORE = MONEY
                                    elif (((1000*S + 100*E + 10*N + D) + (1000*M + 100*O + 10*R + E)) == (10000*M + 1000*O + 100*N + 10*E + Y)) :
                                        s+=1 
                                        print("Solution ",s," : ",S,E,N,D," + ",M,O,R,E," = ",M,O,N,E,Y,sep="")
                                        break;
    print("\nThere is ",s," solutions.")

"""
print("Starting Send + More = Money ... without 0 allowed as first value")
start = time.time()
send_more(1)
end = time.time()
print("Execution time : ", round(end-start,2),"s")
print("--------------------------")
print("Starting Send + More = Money ... with 0 allowed as first value")
start = time.time()
send_more(0)
end = time.time()
print("Execution time : ", round(end-start,2),"s")
print("--------------------------")
"""

