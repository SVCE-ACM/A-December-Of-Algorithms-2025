#farthest reach
def farthest_reach(arr):
    n = len(arr)
    max_reach = 0
    for i in range(n):
        if i>max_reach:
            return False
        max_reach = max(max_reach, i + arr[i])
        if max_reach >= n - 1:
            return True
    return True

arr = list(map(int,input().split()))
print(farthest_reach(arr))
