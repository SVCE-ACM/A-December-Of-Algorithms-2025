def sum_of_unique_elements(arr):
    from collections import Counter
    freq = Counter(arr)
    return sum(x for x, count in freq.items() if count == 1)
N = int(input())
arr = list(map(int, input().split()))
print(sum_of_unique_elements(arr)) 
