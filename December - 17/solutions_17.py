target = int(input("Enter the target: "))
n = int(input("Enter the number of turtles: "))
speed = []
position = []
time={}
for i in range(n):
    print("\nturtle #",i+1)
    p = int(input("Enter the position: "))
    s = int(input("Enter the speed: "))
     
    position.append(p)
    speed.append(s)

    time[p]=(target-p)//s

new_time = dict(sorted(time.items(),reverse=True))
time_list = list(new_time.values())

fleet = 1
for i in range(1,len(time_list)):
    if time_list[i] > time_list[i-1]:
        fleet += 1
print("The number of turtle fleet is: ",fleet)
    
