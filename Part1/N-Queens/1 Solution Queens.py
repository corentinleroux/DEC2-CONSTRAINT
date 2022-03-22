import time

def attacked(i,j):
    for x in range (0,N):
        if board[i][x]==1 or board[x][j]==1:return True
    for x in range (0,N):
        for y in range (0,N):
            if ((x+y==i+j) or (x-y==i-j)) and board[x][y]==1 : return True
    return False

def n_queens(n):
    if n==0:return True
    for i in range(0,N):
        for j in range(0,N):
            if (not(attacked(i,j))) and (board[i][j]!=1):
                board[i][j]=1
                if n_queens(n-1)==True: return True
                board[i][j]=0
    return False
"""
print("Starting N-Queens problem ...")
start = time.time()
print ("Input N number of Queens : ")
N = int(input())
board = [[0]*N for _ in range(N)]
n_queens(N)
for i in board: print (i)
end = time.time()
print("\nExecution time : ", round(end-start,2),"s")
print("--------------------------")
"""

print("Starting 8-Queens problem ...")
start = time.time()
N = 8
board = [[0]*N for _ in range(N)]
n_queens(N)
for i in board: print (i)
end = time.time()
print("\nExecution time : ", round(end-start,2),"s")
print("--------------------------")

print("Starting 10-Queens problem ...")
start = time.time()
N = 10
board = [[0]*N for _ in range(N)]
n_queens(N)
for i in board: print (i)
end = time.time()
print("\nExecution time : ", round(end-start,2),"s")
print("--------------------------")

print("Starting 11-Queens problem ...")
start = time.time()
N = 11
board = [[0]*N for _ in range(N)]
n_queens(N)
for i in board: print (i)
end = time.time()
print("\nExecution time : ", round(end-start,2),"s")
print("--------------------------")

print("Starting 12-Queens problem ...")
start = time.time()
N = 12
board = [[0]*N for _ in range(N)]
n_queens(N)
for i in board: print (i)
end = time.time()
print("\nExecution time : ", round(end-start,2),"s")
print("--------------------------")
