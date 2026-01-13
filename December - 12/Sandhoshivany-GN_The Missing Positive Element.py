def find_missing_and_duplicate(arr, n):
    S = sum(arr)
    S_N = n * (n + 1) // 2
    Sq = sum(x * x for x in arr)
    Sq_N = n * (n + 1) * (2 * n + 1) // 6

    diff = S - S_N            
    sq_diff = Sq - Sq_N       

    sum_DM = sq_diff // diff 


    D = (diff + sum_DM) // 2
    M = D - diff

    return M, D

N = int(input())
arr = list(map(int, input().split()))


missing, duplicate = find_missing_and_duplicate(arr, N)
print(f"Missing Number: {missing}")
print(f"Duplicate Number: {duplicate}")
