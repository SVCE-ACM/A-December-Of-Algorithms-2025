input <- file("stdin", "r")
lines <- readLines(input)
dims <- as.integer(unlist(strsplit(lines[1], "\\s+")))
r <- dims[1]
c <- dims[2]

grid <- matrix(0, nrow = r, ncol = c)
for (i in 1:r) {
  row_vals <- as.integer(unlist(strsplit(lines[i + 1], "\\s+")))
  grid[i, ] <- row_vals
}

if (grid[1, 1] == 1 || grid[r, c] == 1) {
  cat("-1\n")
} else {
  dist <- matrix(-1, nrow = r, ncol = c)
  dist[1, 1] <- 0
  
  q_r <- integer(r * c + 100)
  q_c <- integer(r * c + 100)
  head <- 1
  tail <- 1
  
  q_r[tail] <- 1
  q_c[tail] <- 1
  tail <- tail + 1
  
  found <- FALSE
  dr <- c(0, 0, 1, -1)
  dc <- c(1, -1, 0, 0)
  
  while (head < tail) {
    cr <- q_r[head]
    cc <- q_c[head]
    head <- head + 1
    d <- dist[cr, cc]
    
    if (cr == r && cc == c) {
      cat(d, "\n", sep = "")
      found <- TRUE
      break
    }
    
    for (k in 1:4) {
      nr <- cr + dr[k]
      nc <- cc + dc[k]
      
      if (nr >= 1 && nr <= r && nc >= 1 && nc <= c) {
        if (grid[nr, nc] == 0 && dist[nr, nc] == -1) {
          dist[nr, nc] <- d + 1
          q_r[tail] <- nr
          q_c[tail] <- nc
          tail <- tail + 1
        }
      }
    }
  }
  
  if (!found) {
    cat("-1\n")
  }
}
