def calPoints(operations):
    stack = []

    for op in operations:
        if op == "C":
            stack.pop()
        elif op == "D":
            stack.append(stack[-1] * 2)
        elif op == "+":
            stack.append(stack[-1] + stack[-2])
        else:
            stack.append(int(op))

    return sum(stack)

ops1 = ["5","2","C","D","+"]
ops2 = ["5","-2","4","C","D","9","+","+"]

print(calPoints(ops1))  # 30
print(calPoints(ops2)) 
