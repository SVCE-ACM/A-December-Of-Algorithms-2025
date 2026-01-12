n = int(input())

if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
else:
    M = n * (n*n + 1) // 2
    print("Magic constant:", M)

    square = [[0]*n for _ in range(n)]

    i = 0
    j = n // 2

    for num in range(1, n*n + 1):
        square[i][j] = num

        ni = (i - 1) % n
        nj = (j + 1) % n

        if square[ni][nj] != 0:
            i = (i + 1) % n
        else:
            i = ni
            j = nj

    for row in square:
        for val in row:
            print(val, end=" ")
        print()
