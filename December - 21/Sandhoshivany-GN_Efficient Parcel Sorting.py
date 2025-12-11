from collections import deque

def efficient_parcel_sorting(weights):
    q = deque(weights)
    sorted_list = []

    while q:
        
        min_val = min(q)

        
        while q[0] != min_val:
            q.append(q.popleft())  

        
        sorted_list.append(q.popleft())

    return sorted_list



n = int(input())
weights = list(map(int, input().split()))
print(*efficient_parcel_sorting(weights))
