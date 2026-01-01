input <- scan("stdin", quiet = TRUE)
n <- input[1]
arr <- input[2:(n + 1)]

duplicate <- -1
missing <- -1

for (i in 1:n) {
  idx <- abs(arr[i])
  if (arr[idx] < 0) {
    duplicate <- idx
  } else {
    arr[idx] <- -arr[idx]
  }
}

for (i in 1:n) {
  if (arr[i] > 0) {
    missing <- i
    break
  }
}

cat("Missing Number:", missing, "\n")
cat("Duplicate Number:", duplicate)
