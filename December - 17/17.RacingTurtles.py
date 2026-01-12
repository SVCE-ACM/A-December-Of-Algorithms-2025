target = int(input("Enter target: "))
n = int(input("Enter number of turtles: "))
if n == 0:
    print("No turtle fleets formed.")
else:
    position = list(map(int, input("Enter positions: ").split()))
    speed = list(map(int, input("Enter speeds: ").split()))
    if len(position) != n or len(speed) != n:
        print("Error: Number of positions or speeds does not match n.")
    else:
        turtles = sorted(zip(position, speed), reverse=True)
        times = [(target - pos) / spd for pos, spd in turtles]
        fleets = 0
        stack = []
        for t in times:
            if not stack or t > stack[-1]:
                stack.append(t)
                fleets += 1
        print(f"The number of turtle fleets is: {fleets}")
