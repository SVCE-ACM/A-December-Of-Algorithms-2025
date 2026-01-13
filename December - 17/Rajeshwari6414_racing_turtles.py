target = int(input())
n = int(input())
position = list(map(int, input().split()))
speed = list(map(int, input().split()))

if n == 0:
    print("No turtle fleets formed.")
else:
    turtles = sorted(zip(position, speed), reverse=True)
    fleets = 0
    time = 0

    for p, s in turtles:
        t = (target - p) / s
        if t > time:
            fleets += 1
            time = t

    print(f"The number of turtle fleets is: {fleets}")
