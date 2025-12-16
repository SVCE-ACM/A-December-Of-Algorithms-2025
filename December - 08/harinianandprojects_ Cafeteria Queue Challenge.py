stu = list(map(int, input().strip("[]").split(",")))
san = list(map(int, input().strip("[]").split(",")))
c0 = stu.count(0)
c1 = stu.count(1)
for x in san:
    if x == 0:
        if c0 == 0:
            break
        c0 -= 1
    else:
        if c1 == 0:
            break
        c1 -= 1
print(c0 + c1)
