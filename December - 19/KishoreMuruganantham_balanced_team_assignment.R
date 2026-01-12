input <- file("stdin", "r")
lines <- readLines(input)
n <- as.integer(lines[1])
skills <- as.integer(unlist(strsplit(lines[2], "\\s+")))

total_sum <- sum(skills)

dp <- logical(total_sum + 1)
dp[1] <- TRUE

for (val in skills) {
  current_reachable_indices <- which(dp)
  new_reachable_indices <- current_reachable_indices + val
  new_reachable_indices <- new_reachable_indices[new_reachable_indices <= (total_sum + 1)]
  dp[new_reachable_indices] <- TRUE
}

reachable_sums <- which(dp) - 1
diffs <- abs(total_sum - 2 * reachable_sums)
cat(min(diffs), "\n", sep = "")
