input <- file("stdin", "r")
lines <- readLines(input)
dims <- as.integer(unlist(strsplit(lines[1], "\\s+")))
r <- dims[1]
c <- dims[2]

grid <- matrix("", nrow = r, ncol = c)
start_pos <- c(0, 0)

for (i in 1:r) {
  row_chars <- strsplit(lines[i + 1], "")[[1]]
  grid[i, ] <- row_chars
  if ("S" %in% row_chars) {
    j <- which(row_chars == "S")
    start_pos <- c(i, j)
  }
}

get_key_bit <- function(ch) {
  utf8ToInt(ch) - utf8ToInt("a")
}
get_door_bit <- function(ch) {
  utf8ToInt(ch) - utf8ToInt("A")
}

visited <- array(FALSE, dim = c(r, c, 1024))

q_r <- integer(2000000)
q_c <- integer(2000000)
q_mask <- integer(2000000)
q_dist <- integer(2000000)

head <- 1
tail <- 1

q_r[tail] <- start_pos[1]
q_c[tail] <- start_pos[2]
q_mask[tail] <- 0
q_dist[tail] <- 0
tail <- tail + 1
visited[start_pos[1], start_pos[2], 1] <- TRUE

found <- FALSE
dr <- c(0, 0, 1, -1)
dc <- c(1, -1, 0, 0)

while (head < tail) {
  cr <- q_r[head]
  cc <- q_c[head]
  cmask <- q_mask[head]
  d <- q_dist[head]
  head <- head + 1
  
  if (grid[cr, cc] == "T") {
    cat(d, "\n", sep = "")
    found <- TRUE
    break
  }
  
  for (k in 1:4) {
    nr <- cr + dr[k]
    nc <- cc + dc[k]
    
    if (nr >= 1 && nr <= r && nc >= 1 && nc <= c) {
      cell <- grid[nr, nc]
      if (cell == "#") next
      
      nmask <- cmask
      allowed <- TRUE
      
      if (cell >= "a" && cell <= "j") {
        nmask <- bitwOr(cmask, bitwShiftL(1, get_key_bit(cell)))
      } else if (cell >= "A" && cell <= "J") {
        req <- get_door_bit(cell)
        if (bitwAnd(cmask, bitwShiftL(1, req)) == 0) {
          allowed <- FALSE
        }
      }
      
      if (allowed && !visited[nr, nc, nmask + 1]) {
        visited[nr, nc, nmask + 1] <- TRUE
        q_r[tail] <- nr
        q_c[tail] <- nc
        q_mask[tail] <- nmask
        q_dist[tail] <- d + 1
        tail <- tail + 1
      }
    }
  }
}

if (!found) {
  cat("-1\n")
}
