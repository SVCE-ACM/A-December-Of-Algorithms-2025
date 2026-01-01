input <- scan("stdin", quiet = TRUE)
n <- input[1]
h <- input[2:(n + 1)]

peaks <- integer(0)

for (i in 2:(n - 1)) {
  if (h[i] > h[i - 1] && h[i] > h[i + 1]) {
    peaks <- c(peaks, i - 1)
  }
}

if (length(peaks) == 0) {
  cat(-1)
} else {
  cat(peaks, sep = " ")
}
