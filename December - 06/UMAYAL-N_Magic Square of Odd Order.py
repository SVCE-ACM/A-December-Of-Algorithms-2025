n = int(input())

if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
else:
    magic = [[0]*n for _ in range(n)]

    # Standard Siamese method (top-middle start)
    i, j = 0, n // 2
    for num in range(1, n*n + 1):
        magic[i][j] = num
        ni, nj = (i - 1) % n, (j + 1) % n
        if magic[ni][nj]:
            i = (i + 1) % n
        else:
            i, j = ni, nj

    # Rotate 180 degrees to match sample output
    magic = [row[::-1] for row in magic[::-1]]

    M = n * (n*n + 1) // 2
    print("Magic constant:", M)
    for row in magic:
        print(*row)
