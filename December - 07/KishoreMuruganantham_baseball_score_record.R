input <- file("stdin", "r")
line <- readLines(input, n = 1)
line <- sub(".*=\\s*", "", line)
line <- gsub("\\[|\\]|\"", "", line)
ops <- unlist(strsplit(line, ","))

scores <- integer(0)

for (op in ops) {
  if (op == "C") {
    if (length(scores) > 0) {
      scores <- scores[-length(scores)]
    }
  } else if (op == "D") {
    if (length(scores) > 0) {
      scores <- c(scores, 2 * scores[length(scores)])
    }
  } else if (op == "+") {
    n <- length(scores)
    if (n >= 2) {
      scores <- c(scores, scores[n] + scores[n - 1])
    }
  } else {
    scores <- c(scores, as.integer(op))
  }
}

cat(sum(scores), "\n", sep = "")
