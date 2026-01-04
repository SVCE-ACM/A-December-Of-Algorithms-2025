N = int(input("Enter N: "))

if N <= 2:
    print("The count of prime numbers less than N is: 0")
else:
    is_prime = [True] * N
    is_prime[0] = is_prime[1] = False

    p = 2
    while p * p < N:
        if is_prime[p]:
            for i in range(p * p, N, p):
                is_prime[i] = False
        p += 1

    count = 0
    for i in range(2, N):
        if is_prime[i]:
            count += 1

    print("The count of prime numbers less than N is:", count)
