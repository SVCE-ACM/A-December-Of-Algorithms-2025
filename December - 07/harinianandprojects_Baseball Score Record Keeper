ops = input().strip("[]").replace('"', '').split(",")

sc = []

for x in ops:
    if x == "C":
        sc.pop()
    elif x == "D":
        sc.append(sc[-1] * 2)
    elif x == "+":
        sc.append(sc[-1] + sc[-2])
    else:
        sc.append(int(x))

print(sum(sc))
