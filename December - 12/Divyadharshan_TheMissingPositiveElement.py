n = int(input())
arr = [int(i) for i in input().split()]
print("Missing Number:",(n*(n+1)//2-(sum(set(arr)))))
print("Duplicate Number:",(sum(arr)-sum(set(arr))))