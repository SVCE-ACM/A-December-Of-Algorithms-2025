input <- file("stdin", "r")
lines <- readLines(input)

p_val <- function(l) {
  l <- sub(".*=\\s*", "", l)
  l <- gsub("\\[|\\]", "", l)
  as.numeric(unlist(strsplit(l, ",")))
}

target <- p_val(lines[1])
n <- p_val(lines[2])

if (n == 0) {
  cat("No turtle fleets formed.\n")
} else {
  pos <- p_val(lines[3])
  spd <- p_val(lines[4])
  
  times <- (target - pos) / spd
  
  ord <- order(pos, decreasing = TRUE)
  sorted_times <- times[ord]
  
  fleets <- 0
  current_max <- 0
  
  for (t in sorted_times) {
    if (t > current_max) {
      fleets <- fleets + 1
      current_max <- t
    }
  }
  
  cat("The number of turtle fleets is: ", fleets, "\n", sep = "")
}
