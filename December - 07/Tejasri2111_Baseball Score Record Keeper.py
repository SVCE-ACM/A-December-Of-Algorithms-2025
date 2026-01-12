def calPoints(operations):
    record = []
    
    for op in operations:
        if op == "C":
            if record:
                record.pop()
        elif op == "D":
            if record:
                record.append(2 * record[-1])
        elif op == "+":
            if len(record) >= 2:
                record.append(record[-1] + record[-2])
            elif len(record) == 1:
                record.append(record[-1])
        else:
            record.append(int(op))
    
    return sum(record)

ops_input = input("Enter operations separated by space: ").split()
result = calPoints(ops_input)
print("Total score:", result)