# Treasure Trail Adjustment
arr = list(map(int, input().strip().strip('[]').split(',')))
n = int(input().strip())

idx = len(arr) - n
arr.pop(idx)

print(arr)
