N = int(input())
limit = int(N**0.5)

perfect_squares = [i*i for i in range(1,limit + 1)]

print(*perfect_squares)
print(len(perfect_squares))

