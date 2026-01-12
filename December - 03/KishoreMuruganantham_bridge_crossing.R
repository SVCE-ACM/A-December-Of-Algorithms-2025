input <- file("stdin", "r")
line <- readLines(input, n = 1)
if (grepl("=", line)) {
  line <- sub(".*=\\s*", "", line)
}
line <- gsub("\\[|\\]", "", line)
stones <- as.integer(unlist(strsplit(line, ",")))

solve <- function(nums) {
  n <- length(nums)
  max_reach <- 0
  for (i in 1:n) {
    pos <- i - 1
    if (pos > max_reach) {
      return("false")
    }
    max_reach <- max(max_reach, pos + nums[i])
    if (max_reach >= n - 1) {
      return("true")
    }
  }
  return("true")
}

cat(solve(stones), "\n", sep = "")
