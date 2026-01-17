def min_sweets(scores):
    n = len(scores)
    sweets = [1] * n
    for i in range(1, n):
        if scores[i] > scores[i-1]:
            sweets[i] = sweets[i-1] + 1
    for i in range(n-2, -1, -1):
        if scores[i] > scores[i+1]:
            sweets[i] = max(sweets[i], sweets[i+1] + 1)
    
    return sum(sweets)
if __name__ == "__main__":
    n = int(input().strip())
    scores = list(map(int, input().split()))
    result = min_sweets(scores)
    print(result)
