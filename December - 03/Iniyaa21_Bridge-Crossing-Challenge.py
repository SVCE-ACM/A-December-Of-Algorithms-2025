stones = eval(input()) 
n = len(stones) 
max_reach = 0 

for i in range(n): 
    if max_reach < i:
        print("false") 
        break 
    max_reach = max(max_reach, i + stones[i])
    if max_reach >= n - 1: 
        print("true")
        break 