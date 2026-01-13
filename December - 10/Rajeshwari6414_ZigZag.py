N = int(input())
values = list(map(int, input().split()))

result = []
left, right = 0, N - 1

while left <= right:
    if left == right:
        result.append(values[left])
    else:
        result.append(values[left])
        result.append(values[right])
    left += 1
    right -= 1

print(*result)
