input <- file("stdin", "r")
lines <- readLines(input)

board <- matrix("", nrow = 9, ncol = 9)
for (i in 1:9) {
  row_vals <- unlist(strsplit(lines[i], "\\s+"))
  board[i, ] <- row_vals
}

is_valid <- function(r, c, k) {
  if (any(board[r, ] == k)) return(FALSE)
  if (any(board[, c] == k)) return(FALSE)
  
  r_start <- floor((r - 1) / 3) * 3 + 1
  c_start <- floor((c - 1) / 3) * 3 + 1
  
  sub_box <- board[r_start:(r_start + 2), c_start:(c_start + 2)]
  if (any(sub_box == k)) return(FALSE)
  
  return(TRUE)
}

solve <- function() {
  for (i in 1:9) {
    for (j in 1:9) {
      if (board[i, j] == ".") {
        for (k in 1:9) {
          sgs <- as.character(k)
          if (is_valid(i, j, sgs)) {
            board[i, j] <<- sgs
            if (solve()) return(TRUE)
            board[i, j] <<- "."
          }
        }
        return(FALSE)
      }
    }
  }
  return(TRUE)
}

if (solve()) {
  for (i in 1:9) {
    cat(paste(board[i, ], collapse = " "), "\n", sep = "")
  }
}
