n, k = [int(i) for i in input().split()]
arr = [int(i) for i in input().split()] 

prefix_sum_map = {0:-1} 
current_sum = 0 

for i in range(n):
    current_sum += arr[i] 
    required_sum = current_sum - k 
    if required_sum in prefix_sum_map:
        start = prefix_sum_map[required_sum] + 1
        end = i 
        print(start, end) 
        break 
    prefix_sum_map[current_sum] = i 

else: 
    print(-1, -1)