from math import sqrt, floor 

n = int(input()) 

result = [] 

for i in range(1, floor(sqrt(n)) + 1): 
    result.append(str(i * i)) 

print(" ".join(result)) 
print(len(result))