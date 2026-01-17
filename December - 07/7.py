def calPoints(ops):
    stack = []
    for op in ops:
        if op == "C":
            stack.pop()
        elif op == "D":
            stack.append(2 * stack[-1])
        elif op == "+":
            stack.append(stack[-1] + stack[-2])
        else:
            stack.append(int(op))
    return sum(stack)

ops = list(map(str, input().split()))
print(calPoints(ops))
