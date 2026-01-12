options(expressions = 500000)
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

memo <- matrix(0, nrow = r, ncol = c)
dr <- c(0, 0, 1, -1)
dc <- c(1, -1, 0, 0)

dfs <- function(cr, cc) {
  if (memo[cr, cc] != 0) return(memo[cr, cc])
  
  max_l <- 1
  val <- grid[cr, cc]
  
  for (k in 1:4) {
    nr <- cr + dr[k]
    nc <- cc + dc[k]
    if (nr >= 1 && nr <= r && nc >= 1 && nc <= c) {
      if (grid[nr, nc] > val) {
        l <- 1 + dfs(nr, nc)
        if (l > max_l) max_l <- l
      }
    }
  }
  memo[cr, cc] <<- max_l
  return(max_l)
}

res <- 0
for (i in 1:r) {
  for (j in 1:c) {
    tmp <- dfs(i, j)
    if (tmp > res) res <- tmp
  }
}

cat(res, "\n", sep = "")
