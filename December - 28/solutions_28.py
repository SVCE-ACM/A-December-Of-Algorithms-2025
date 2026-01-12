def min_sweets(n, scores):
    sweets = [1] * n
    
    for i in range(1, n):
        if scores[i] > scores[i - 1]:
            sweets[i] = sweets[i - 1] + 1
    
    for i in range(n - 2, -1, -1):
        if scores[i] > scores[i + 1]:
            sweets[i] = max(sweets[i], sweets[i + 1] + 1)
    
    return sum(sweets)

n = int(input("Enter number of students: "))
scores = list(map(int, input("Enter performance scores: ").split()))

result = min_sweets(n, scores)
print(result)
