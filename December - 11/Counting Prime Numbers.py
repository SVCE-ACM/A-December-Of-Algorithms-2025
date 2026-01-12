N = int(input("Enter N: "))
if N <= 2:
    print("The count of prime numbers less than", N, "is: 0")
else:
    is_prime = [True] * N
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(N**0.5) + 1):
        if is_prime[i]:
            for j in range(i*i, N, i):
                is_prime[j] = False

    count = sum(is_prime)
    print("The count of prime numbers less than", N, "is:", count)
