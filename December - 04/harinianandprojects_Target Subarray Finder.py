size, goal = map(int, input().split())
numbers = list(map(int, input().split()))

start = 0
window_sum = 0

for end in range(size):
    window_sum += numbers[end]

    while window_sum > goal and start <= end:
        window_sum -= numbers[start]
        start += 1

    if window_sum == goal:
        print(start, end)
        break
else:
    print(-1, -1)
