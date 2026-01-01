input <- scan("stdin", quiet = TRUE)
n <- input[1]
arr <- input[2:(n + 1)]
freq <- table(arr)
unique_vals <- as.numeric(names(freq)[freq == 1])
if (length(unique_vals) == 0) {
  cat(0)
} else {
  cat(sum(unique_vals))
}
