arr = list(map(int, input().strip().strip('[]').split(',')))
n = int(input().strip())
x = len(arr) - n
arr.pop(x)
print(arr)
