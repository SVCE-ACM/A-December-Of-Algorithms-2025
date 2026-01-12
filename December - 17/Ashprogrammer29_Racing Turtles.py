def turtleFleets(target, n, position, speed):
    if n == 0:
        print("No turtle fleets formed.")
        return
    
    turtles = sorted(zip(position, speed), reverse=True)
    stack = []  
    
    for pos, spd in turtles:
        time = (target - pos) / spd
        if not stack or time > stack[-1]:
            stack.append(time)  # new fleet

    print(f"The number of turtle fleets is: {len(stack)}")
