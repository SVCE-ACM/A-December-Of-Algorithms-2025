def turtleFleets(target, n, position, speed):
    if n == 0:
        print("No turtle fleets formed.")
        return

    turtles = sorted(zip(position, speed), reverse=True)
    times = [(target - p) / s for p, s in turtles]

    fleets = 0
    prev_time = 0

    for t in times:
        if t > prev_time:
            fleets += 1
            prev_time = t

    print(f"The number of turtle fleets is: {fleets}")

if __name__ == "__main__":
    target = int(input().strip())
    n = int(input().strip())
    position = eval(input().strip())
    speed = eval(input().strip())
    turtleFleets(target, n, position, speed)
