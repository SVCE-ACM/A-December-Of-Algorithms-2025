s = input("roots = ").strip()
s = s[1:-1]
items = s.split(",")
arr = []
for x in items:
    if x == "null":
        arr.append(None)
    else:
        arr.append(int(x))
seen_null = False
for x in arr:
    if x is None:
        seen_null = True
    else:
        if seen_null:
            print("false")
            break
else:
    print("true")