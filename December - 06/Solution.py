n = int(input("Enter n: "))
if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
else:
    magic_square = [[0] * n for _ in range(n)]

    magic_constant = n * (n * n + 1) // 2
    print(f"Magic constant: {magic_constant}")
    i = 0
    j = n // 2
    for num in range(1, n * n + 1):
        magic_square[i][j] = num
        new_i = (i - 1) % n
        new_j = (j + 1) % n
        if magic_square[new_i][new_j] != 0:
            i = (i + 1) % n
        else:
            i = new_i
            j = new_j
    for row in magic_square:
        for val in row:
            print(f"{val:3}", end=" ")
        print()
