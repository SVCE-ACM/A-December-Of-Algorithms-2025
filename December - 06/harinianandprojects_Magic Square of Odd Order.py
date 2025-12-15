n = int(input("Enter n: "))
if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
else:
    M = n * (n**2 + 1) // 2
    print(f"Magic constant: {M}")
    magic = [[0] * n for _ in range(n)]
    i, j = 0, n // 2
    for num in range(1, n*n + 1):
        magic[i][j] = num
        ni, nj = (i - 1) % n, (j + 1) % n
        if magic[ni][nj] != 0:
            i = (i + 1) % n
        else:
            i, j = ni, nj
    for row in magic:
        print(" ".join(f"{x:3}" for x in row))
