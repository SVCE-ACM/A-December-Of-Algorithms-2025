N, K = map(int, input("Enter N and K: ").split())
arr = list(map(int, input(f"Enter {N} elements: ").split()))
start = 0
current_sum = 0
found = False
for end in range(N):
    current_sum += arr[end]
    while current_sum > K and start <= end:
        current_sum -= arr[start]
        start += 1
    if current_sum == K:
        print(start, end)
        found = True
        break
if not found:
    print(-1, -1)
