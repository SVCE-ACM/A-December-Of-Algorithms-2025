input_str = input().strip()
target = int(input_str.split("=")[1].strip())

input_str = input().strip()
n = int(input_str.split("=")[1].strip())

if n == 0:
    print("No turtle fleets formed.")
else:
    input_str = input().strip()
    position_str = input_str.split("=")[1].strip().strip("[]")
    position = list(map(int, position_str.split(",")))
    
    input_str = input().strip()
    speed_str = input_str.split("=")[1].strip().strip("[]")
    speed = list(map(int, speed_str.split(",")))
    
    turtles = list(zip(position, speed))
    turtles.sort(reverse=True)
    
    fleets = 0
    current_time = 0
    
    for pos, spd in turtles:
        time_to_finish = (target - pos) / spd
        if time_to_finish > current_time:
            fleets += 1
            current_time = time_to_finish
    
    print(f"The number of turtle fleets is: {fleets}")