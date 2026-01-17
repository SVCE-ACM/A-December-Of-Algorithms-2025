from collections import deque

def parcel_sort(weights):
    q = deque(weights)
    sorted_output = []
    while q:
        min_val = min(q)
        while q[0] != min_val:
            q.append(q.popleft())
        sorted_output.append(q.popleft())
    
    return sorted_output

if __name__ == "__main__":
    N = int(input().strip())
    weights = list(map(int, input().split()))
    result = parcel_sort(weights)
    print(" ".join(map(str, result)))
