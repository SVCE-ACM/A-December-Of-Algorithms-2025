def turtleFleets(target, n, position, speed):
    if n == 0:
        print("No turtle fleets formed.")
        return

    turtles = sorted(zip(position, speed), reverse=True)
    fleets = 0
    max_time = 0

    for p, s in turtles:
        time = (target - p) / s
        if time > max_time:
            fleets += 1
            max_time = time

    print(f"The number of turtle fleets is: {fleets}")

target = int(input())
n = int(input())
position = [int(i) for i in input().split()]
speed = [int(i) for i in input().split()]
turtleFleets(target,n,position,speed)