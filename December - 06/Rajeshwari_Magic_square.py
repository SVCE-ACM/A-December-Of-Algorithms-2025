n = int(input("Enter n:"))

if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
else:
    magic_square = [[0]*n for _ in range(n)]
    num = 1
    i, j = 0, n // 2

    while num <= n*n:
        magic_square[i][j] = num
        num += 1
        new_i, new_j = (i-1) % n, (j+1) % n
        if magic_square[new_i][new_j]:
            i = (i+1) % n
        else:
            i, j = new_i, new_j

    magic_constant = n * (n*n + 1) // 2
    print("Magic constant:", magic_constant)
    for row in magic_square:
        print(*row)
