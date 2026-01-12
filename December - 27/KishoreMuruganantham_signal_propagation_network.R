input <- file("stdin", "r")
lines <- readLines(input)
n <- as.integer(lines[1])
m <- as.integer(lines[2])

adj <- vector("list", n)
if (m > 0) {
  for (i in 1:m) {
    vals <- as.numeric(unlist(strsplit(lines[2 + i], "\\s+")))
    u <- vals[1] + 1
    v <- vals[2] + 1
    w <- vals[3]
    adj[[u]] <- c(adj[[u]], list(c(v, w)))
  }
}

s_Line <- lines[2 + m + 1]
s_node <- as.integer(s_Line) + 1

dist <- rep(Inf, n)
dist[s_node] <- 0
visited <- rep(FALSE, n)

for (count in 1:n) {
  min_val <- Inf
  u <- -1
  
  for (i in 1:n) {
    if (!visited[i] && dist[i] < min_val) {
      min_val <- dist[i]
      u <- i
    }
  }
  
  if (u == -1) break
  visited[u] <- TRUE
  
  neighbors <- adj[[u]]
  if (length(neighbors) > 0) {
    for (nb in neighbors) {
      v_idx <- nb[1]
      wt <- nb[2]
      if (dist[u] + wt < dist[v_idx]) {
        dist[v_idx] <- dist[u] + wt
      }
    }
  }
}

res <- max(dist)
if (res == Inf) {
  cat("-1\n")
} else {
  cat(res, "\n", sep = "")
}
