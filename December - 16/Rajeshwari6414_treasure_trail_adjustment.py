head = list(map(int, input().split()))
n = int(input())

if len(head) == n:
    print([])
else:
    head.pop(len(head) - n)
    print(head)
