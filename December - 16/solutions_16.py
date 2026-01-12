def delete_nth_from_end(header, n):
    length = 0
    p = header['next']
    while p is not None:
        length += 1
        p = p['next']
    
    position_before = length - n
  
    p = header
    for i in range(position_before):
        p = p['next']
    
    if p['next'] is not None:
        p['next'] = p['next']['next']
    
    return header['next']

head = []
header = {'val': 0, 'next': None}
current = header
size = int(input("Enter the size of the array: "))

for i in range(size):
    v = int(input("Enter the value: "))
    head.append(v)
    new_node = {'val': v, 'next': None}
    current['next'] = new_node
    current = new_node

p = header['next']
while p is not None:
    p = p['next']


n = int(input("\nEnter the position of the node to be removed from the end: "))

new_head = delete_nth_from_end(header, n)

updated_list = []
p = new_head
while p is not None:
    updated_list.append(p['val'])
    p = p['next']

print(updated_list)
