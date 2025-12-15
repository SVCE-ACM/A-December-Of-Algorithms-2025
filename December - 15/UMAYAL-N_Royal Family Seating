# Royal Family Seating - Complete Binary Tree Check
from collections import deque

nodes = input().strip().strip('[]').split(',')
nodes = [x.strip() for x in nodes]

# Level order array check
found_null = False
complete = True

for x in nodes:
    if x == 'null':
        found_null = True
    else:
        if found_null:
            complete = False
            break

print(str(complete).lower())
