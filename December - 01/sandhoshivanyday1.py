# Input: upper bound of range
N = int(input())

# List to store perfect squares
perfect_squares = []

# Find all perfect squares <= N
i = 1
while i * i <= N:
    perfect_squares.append(i * i)
    i += 1

# Print perfect squares
print(*perfect_squares)

# Print total count
print(len(perfect_squares))
