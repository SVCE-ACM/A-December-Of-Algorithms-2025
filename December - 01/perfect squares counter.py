import math
N = int(input())
squares = []
limit = int(math.sqrt(N))
for i in range(1, limit + 1):
    squares.append(i * i)
print(*squares)
print(len(squares))
