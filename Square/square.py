import time
from itertools import permutations, combinations




print("Starting Magic Square problem...")
start = time.time()
print("Size ? N x N)")
N = int(input())
square = [[0]*N for _ in range(N)]
magic_sum=15
sum_range=[[0,1,2],[3,4,5],[6,7,8],
           [0,3,6],[1,4,7],[2,5,8],
           [0,4,8],[2,4,6]]
def is_magic3x3(m):
    for i in range(len(sum_range)):
        if sum(m[x] for x in sum_range[i]) != magic_sum:
            return False
    return True

allowed_numbers =  range(1,N)
permutations = permutations(allowed_numbers)

perms = list(permutations)
magic_squares3x3=list()
for i in range(len(perms)):
    if is_magic3x3(perms[i]):
         magic_squares3x3.append(perms[i])
print(len(magic_squares3x3))

"""
def squareSolver(n):
    allowed_numbers =  range(1,n)
    for i in range (0,n):
        for j in range (0,n):
            while (condition):
  """              


"""
square[][j]
squareSolver(N)  
random.shuffle(allowed_numbers)
square[i][j] = allowed_numbers.pop()
"""
    
    
