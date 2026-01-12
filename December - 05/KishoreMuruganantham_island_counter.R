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

visited <- matrix(FALSE, nrow = r, ncol = c)
icount <- 0

dr <- c(0, 0, 1, -1)
dc <- c(1, -1, 0, 0)

q_r <- integer(r * c + 1)
q_c <- integer(r * c + 1)

for (i in 1:r) {
  for (j in 1:c) {
    if (grid[i, j] == 1 && !visited[i, j]) {
      icount <- icount + 1
      
      head <- 1
      tail <- 1
      
      q_r[tail] <- i
      q_c[tail] <- j
      tail <- tail + 1
      visited[i, j] <- TRUE
      
      while (head < tail) {
        cr <- q_r[head]
        cc <- q_c[head]
        head <- head + 1
        
        for (k in 1:4) {
          nr <- cr + dr[k]
          nc <- cc + dc[k]
          
          if (nr >= 1 && nr <= r && nc >= 1 && nc <= c) {
            if (grid[nr, nc] == 1 && !visited[nr, nc]) {
              visited[nr, nc] <- TRUE
              q_r[tail] <- nr
              q_c[tail] <- nc
              tail <- tail + 1
            }
          }
        }
      }
    }
  }
}

cat(icount, "\n", sep = "")
