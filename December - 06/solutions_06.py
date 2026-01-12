import numpy as np

def magic_square(square, M, n, freq):
    for i in range(1, n*n + 1):
        freq.append(i)

    r = 0
    c = n // 2

    for num in freq:
        square[r][c] = num

        nr = (r - 1) % n
        nc = (c + 1) % n

        if square[nr][nc] != 0:  
            r = (r + 1) % n
        else:
            r, c = nr, nc

  
    for i in range(n):
        if sum(square[i]) != M:
            return False

    square_T = np.transpose(square)

    for i in range(n):
        if sum(square_T[i]) != M:
            return False

    d1 = sum(square[i][i] for i in range(n))
    d2 = sum(square[i][n - 1 - i] for i in range(n))

    if d1 != M or d2 != M:
        return False

    for i in range(n):
        for j in range(n):
            print(square[i][j], end=" ")
        print()

    return True


n = int(input("Enter the number of rows and columns (odd): "))
M = (n * (n*n + 1)) // 2

if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
else:
    freq = []
    square = [[0 for _ in range(n)] for _ in range(n)]
    magic_square(square, M, n, freq)
