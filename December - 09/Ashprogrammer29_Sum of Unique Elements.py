def sumOfUniqueElements(arr):
    freq = {}

    for x in arr:
        freq[x] = freq.get(x, 0) + 1

    total = 0
    for x, f in freq.items():
        if f == 1:
            total += x

    return total
