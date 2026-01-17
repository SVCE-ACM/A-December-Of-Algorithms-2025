def turtleFleets(target, position, speed):
    n = len(position)
    if n == 0:
        print("No turtle fleets formed.")
        return
    turtles = sorted(zip(position, speed), reverse=True)
    times = [(target - p) / s for p, s in turtles]
    
    fleets = 0
    curr_time = 0
    for t in times:
        if t > curr_time:
            fleets += 1
            curr_time = t
    
    print(f"The number of turtle fleets is: {fleets}")

if __name__ == "__main__":
    target = int(input("target: "))
    n = int(input("n: "))
    
    if n == 0:
        print("No turtle fleets formed.")
    else:
        position = list(map(int, input("Enter positions:").split()))
        speed = list(map(int, input("Enter speeds:").split()))
        turtleFleets(target, position, speed)
