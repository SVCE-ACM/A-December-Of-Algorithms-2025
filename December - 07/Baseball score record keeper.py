ops = input().split()  # input like: 5 2 C D +

scores = []

for op in ops:
    if op == "C":
        scores.pop()
    elif op == "D":
        scores.append(2 * scores[-1])
    elif op == "+":
        scores.append(scores[-1] + scores[-2])
    else:
        scores.append(int(op))

print(sum(scores))
