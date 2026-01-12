input <- file("stdin", "r")
lines <- readLines(input)
n <- as.numeric(lines[1])
arr <- as.numeric(unlist(strsplit(lines[2], "\\s+")))

sum_a <- sum(arr)
sum_sq_a <- sum(arr^2)

sum_n <- n * (n + 1) / 2
sum_sq_n <- n * (n + 1) * (2 * n + 1) / 6

val1 <- sum_a - sum_n
val2 <- sum_sq_a - sum_sq_n

val3 <- val2 / val1

x <- (val1 + val3) / 2
y <- val3 - x

cat("Missing Number:", y, "\n")
cat("Duplicate Number:", x, "\n")
