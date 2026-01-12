input <- file("stdin", "r")
lines <- readLines(input)
dims <- as.integer(unlist(strsplit(lines[1], "\\s+")))
v <- dims[1]
e <- dims[2]

adj <- vector("list", v)
if (e > 0) {
  for (i in 1:e) {
    vals <- as.integer(unlist(strsplit(lines[1 + i], "\\s+")))
    u <- vals[1] + 1
    w <- vals[2] + 1
    adj[[u]] <- c(adj[[u]], w)
    adj[[w]] <- c(adj[[w]], u)
  }
}

states <- as.integer(unlist(strsplit(lines[1 + e + 1], "\\s+")))

dist <- rep(Inf, v)
queue <- integer(v + 10)
head <- 1
tail <- 1

for (i in 1:v) {
  if (states[i] == 1) {
    dist[i] <- 0
    queue[tail] <- i
    tail <- tail + 1
  }
}

max_d <- 0

while (head < tail) {
  curr <- queue[head]
  head <- head + 1
  d <- dist[curr]
  if (d > max_d) max_d <- d
  
  if (!is.null(adj[[curr]])) {
    for (nxt in adj[[curr]]) {
      if (dist[nxt] == Inf) {
        dist[nxt] <- d + 1
        queue[tail] <- nxt
        tail <- tail + 1
      }
    }
  }
}

if (any(dist == Inf)) {
  cat("-1\n")
} else {
  cat(max_d, "\n", sep = "")
}
