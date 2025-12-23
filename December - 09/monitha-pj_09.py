n = int(input())
arr = list(map(int, input().split()))
summ = 0
for i in arr:
    if arr.count(i) == 1:
        summ += i
print(summ)

