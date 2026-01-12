def generate_square(n):
    if n % 2 == 0:
        print("Magic square is only possible for odd values of n.")
        return

    magic_constant = n * (n**2 + 1) // 2
    print(f"Magic constant: {magic_constant}")

    mat = [[0] * n for _ in range(n)]
    i = n // 2
    j = n - 1

    for num in range(1, n * n + 1):
        if i == -1 and j == n:
            j = n - 2
            i = 0
        else:
            if j == n:
                j = 0
            if i < 0:
                i = n - 1

        if mat[i][j]:
            j -= 2
            i += 1
            if i >= n: i = 0
            if j < 0: j = n - 1
            
        mat[i][j] = num
        j += 1
        i -= 1

    for row in mat:
        print(" ".join(f"{val:<3}" for val in row))


n = int(input())
generate_square(n)