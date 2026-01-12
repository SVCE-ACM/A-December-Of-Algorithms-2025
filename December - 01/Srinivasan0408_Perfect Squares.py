import math
n=int(input())
limit=int(math.sqrt(n))
squares=[i*i for i in range(1,limit+1)]
print(*squares)
print(len(squares))