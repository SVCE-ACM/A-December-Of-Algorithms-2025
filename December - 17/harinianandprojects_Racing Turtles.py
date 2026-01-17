import ast

target = int(input())
n = int(input())
if n == 0:
    print("No turtle fleets formed.")
else:
    position = ast.literal_eval(input())
    speed = ast.literal_eval(input())
    turtles = sorted(zip(position, speed), reverse=True)
    fleets = 0
    last_time = 0

    for pos, spd in turtles:
        time = (target - pos) / spd
        if time > last_time:
            fleets += 1
            last_time = time
    print(f"The number of turtle fleets is: {fleets}")
