def waterstatus(water_status, water_path, start, count):
    water_status[start] = 1
    
    for i in water_path:
        if i[0] == start:
            water_status[i[1]] = 1  

V = int(input("Enter the number of reservoirs: "))
E = int(input("Enter the number of pipes: "))
water_path = []  
flag = 0

for i in range(E):
    print("Pair #", i+1)
    u = int(input("Enter the value (u,_): "))
    v = int(input("Enter the value (_,v): "))
    pair = [u, v]
    
    if i == 0 or any(u in sublist or v in sublist for sublist in water_path):
        water_path.append(pair)
    else:
        flag = -1

if flag == -1:
    print(flag)
else:
    water_status_input = list(map(int, input("Enter initial water status: ").split()))
    water_status = water_status_input[:]
  
    from collections import deque
    
    queue = deque()
    for i in range(V):
        if water_status[i] == 1:
            queue.append((i, 0)) 
    
    max_minutes = 0
    
    while queue:
        current, minute = queue.popleft()
        max_minutes = max(max_minutes, minute)
        
        for edge in water_path:
            if edge[0] == current and water_status[edge[1]] == 0:
                water_status[edge[1]] = 1
                queue.append((edge[1], minute + 1))
            elif edge[1] == current and water_status[edge[0]] == 0:
                water_status[edge[0]] = 1
                queue.append((edge[0], minute + 1))
    
    if all(status == 1 for status in water_status):
        print(max_minutes)
    else:
        print(-1)
