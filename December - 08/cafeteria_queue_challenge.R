input <- scan("stdin", quiet = TRUE)
n <- input[1]
students <- input[2:(1 + n)]
sandwiches <- input[(2 + n):(1 + 2 * n)]

count0 <- sum(students == 0)
count1 <- n - count0

for (i in 1:n) {
  if (sandwiches[i] == 0) {
    if (count0 > 0) {
      count0 <- count0 - 1
    } else {
      break
    }
  } else {
    if (count1 > 0) {
      count1 <- count1 - 1
    } else {
      break
    }
  }
}

cat(count0 + count1)
