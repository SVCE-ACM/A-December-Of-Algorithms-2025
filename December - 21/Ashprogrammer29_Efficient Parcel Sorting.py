from collections import deque

def efficient_parcel_sorting(parcels):
    queue = deque(parcels)
    sorted_parcels = sorted(parcels)
    output = []

    for weight in sorted_parcels:
        
        idx = queue.index(weight)
        
        if idx <= len(queue) // 2:
            queue.rotate(-idx) 
        else:
            queue.rotate(len(queue) - idx)  

        output.append(queue.popleft())

    print(*output)



N = int(input())
parcels = list(map(int, input().split()))
efficient_parcel_sorting(parcels)
