import math
def perfect_squares(n):
    squares = []
    for i in range(1, int(math.sqrt(n)) + 1):
        squares.append(i * i)
    return squares

n = int(input())
result = perfect_squares(n)
for i in result:
    print(i, end = " ")