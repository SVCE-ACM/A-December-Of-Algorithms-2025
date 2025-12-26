def find_missing_and_duplicate(n, arr):
    xor_all = 0
    for i in range(1, n + 1):
        xor_all ^= i
    for num in arr:
        xor_all ^= num
    
    rightmost_bit = xor_all & -xor_all
    
    x = 0
    y = 0
    
    for i in range(1, n + 1):
        if i & rightmost_bit:
            x ^= i
        else:
            y ^= i
    
    for num in arr:
        if num & rightmost_bit:
            x ^= num
        else:
            y ^= num
    
    count_x = 0
    for num in arr:
        if num == x:
            count_x += 1
    
    if count_x == 2:
        duplicate = x
        missing = y
    else:
        duplicate = y
        missing = x
    
    return missing, duplicate

n = int(input())
arr = list(map(int, input().split()))

missing, duplicate = find_missing_and_duplicate(n, arr)

print(f"Missing Number: {missing}")
print(f"Duplicate Number: {duplicate}")