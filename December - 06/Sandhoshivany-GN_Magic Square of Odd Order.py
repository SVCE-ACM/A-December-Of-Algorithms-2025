n = int(input("Enter n: "))

if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
else:
    
    magic_square = [[0] * n for _ in range(n)]
    
    
    i, j = 0, n // 2  
    num = 1
    while num <= n * n:
        magic_square[i][j] = num
        num += 1
        new_i = (i - 1) % n
        new_j = (j + 1) % n
        i = (i + 1) % n
    else:
            i, j = new_i, new_j

    
    M = (n * (n * n + 1)) // 2
    print("Magic constant:", M)

    
    for row in magic_square:
        print(" ".join(f"{x:2d}" for x in row))
