from collections import Counter 

n = int(input()) 
arr = [int(i) for i in input().split()] 
counts = Counter(arr) 
result = 0 

for key in counts: 
    if counts[key] == 1:
        result += key 

print(result)