from collections import deque

arr = list(map(int, input().split()))

if not arr:
    print("true")
else:
    q = deque()
    q.append(0)
    found_null = False
    is_complete = True

    while q:
        i = q.popleft()

        if i >= len(arr) or arr[i] == -1:
            found_null = True
        else:
            if found_null:
                is_complete = False
                break
            q.append(2 * i + 1)
            q.append(2 * i + 2)

    if is_complete:
        print("true")
    else:
        print("false")
