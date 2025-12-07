ops <- scan("stdin", what = "character", quiet = TRUE)
scores <- integer(0)

for (op in ops) {
  if (op == "C") {
    scores <- scores[-length(scores)]
  } else if (op == "D") {
    scores <- c(scores, 2L * scores[length(scores)])
  } else if (op == "+") {
    scores <- c(scores, scores[length(scores)] + scores[length(scores) - 1])
  } else {
    scores <- c(scores, as.integer(op))
  }
}

cat(sum(scores))
