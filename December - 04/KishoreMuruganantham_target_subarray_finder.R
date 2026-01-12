input <- file("stdin", "r")
lines <- readLines(input)
first_line <- as.numeric(unlist(strsplit(lines[1], "\\s+")))
n <- first_line[1]
k <- first_line[2]
second_line <- as.numeric(unlist(strsplit(lines[2], "\\s+")))
curr_sum <- 0
seen <- new.env(hash = TRUE, parent = emptyenv())
seen[["0"]] <- -1
found <- FALSE
for (i in 1:length(second_line)) {
  idx <- i - 1
  curr_sum <- curr_sum + second_line[i]
  target <- curr_sum - k
  start_entry <- seen[[as.character(target)]]
  if (!is.null(start_entry)) {
    cat(start_entry + 1, idx, "\n")
    found <- TRUE
    break
  }
  if (is.null(seen[[as.character(curr_sum)]])) {
    seen[[as.character(curr_sum)]] <- idx
  }
}
if (!found) {
  cat("-1 -1\n")
}
