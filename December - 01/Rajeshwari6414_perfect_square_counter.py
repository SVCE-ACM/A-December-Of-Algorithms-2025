# December 01 - Perfect Squares Counter

N = int(input())

perfect_squares = []
i = 1

while i * i <= N:
    perfect_squares.append(i * i)
    i += 1

# Print all perfect squares
print(*perfect_squares)

# Print the total count
print(len(perfect_squares))
