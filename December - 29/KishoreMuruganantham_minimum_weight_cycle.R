input <- file("stdin", "r")
lines <- readLines(input)

l1 <- sub(".*=\\s*", "", lines[1])
v <- as.integer(l1)

rest <- paste(lines[-1], collapse = " ")
rest <- sub(".*=\\s*", "", rest)
rest <- gsub("\\[|\\]|\\s+", "", rest)
vals <- as.integer(unlist(strsplit(rest, ",")))

adj <- vector("list", v)
if (length(vals) > 0) {
  num_e <- length(vals) / 3
  for (i in seq_len(num_e)) {
    base <- (i - 1) * 3
    u <- vals[base + 1] + 1
    w_node <- vals[base + 2] + 1
    wt <- vals[base + 3]
    
    adj[[u]] <- c(adj[[u]], list(c(w_node, wt)))
    adj[[w_node]] <- c(adj[[w_node]], list(c(u, wt)))
  }
}

min_cycle <- Inf

for (s in 1:v) {
  dist <- rep(Inf, v)
  parent <- rep(-1, v)
  dist[s] <- 0
  
  visited <- rep(FALSE, v)
  
  for (count in 1:v) {
    min_d <- Inf
    u <- -1
    
    for (i in 1:v) {
      if (!visited[i] && dist[i] < min_d) {
        min_d <- dist[i]
        u <- i
      }
    }
    
    if (u == -1 || min_d == Inf) break
    visited[u] <- TRUE
    
    nbs <- adj[[u]]
    if (length(nbs) > 0) {
      for (nb in nbs) {
        idx <- nb[1]
        wt <- nb[2]
        
        if (dist[u] + wt < dist[idx]) {
          dist[idx] <- dist[u] + wt
          parent[idx] <- u
        } else if (visited[idx] && idx != parent[u]) {
          res <- dist[u] + dist[idx] + wt
          if (res < min_cycle) min_cycle <- res
        }
      }
    }
  }
}

if (min_cycle == Inf) {
  cat("-1\n")
} else {
  cat(min_cycle, "\n", sep = "")
}
