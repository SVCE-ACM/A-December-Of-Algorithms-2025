n = int(input())
if n % 2 == 0:
    print("Magic square is only possible for odd values of n.")
    exit()

M = n * (n*n + 1) // 2
print(f"Magic constant: {M}")

magic = [[0] * n for _ in range(n)]

num = 1
i, j = 0, n // 2  

while num <= n * n:
    magic[i][j] = num

    num += 1
    new_i = (i - 1) % n   
    new_j = (j + 1) % n    

    
    if magic[new_i][new_j] != 0:
        i = (i + 1) % n
    else:
        i, j = new_i, new_j


for row in magic:
    print(*row)
