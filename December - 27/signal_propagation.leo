program signal_propagation;

struct Edge {
    to: u32,
    time: u32,
}

function main(adj: [[Edge; 500]; 500], adj_size: [u32; 500], n: u32, source: u32) -> u32 {
    let mut dist: [u32; 500] = [999999u32; 500];
    let mut visited: [bool; 500] = [false; 500];
    dist[source] = 0u32;

    let mut i: u32 = 0u32;
    while i < n {
        let mut min_dist: u32 = 999999u32;
        let mut u: u32 = 0u32;
        let mut j: u32 = 0u32;
        
        while j < n {
            if !visited[j] && dist[j] < min_dist {
                min_dist = dist[j];
                u = j;
            }
            j = j + 1u32;
        }

        if min_dist == 999999u32 {
            return 999999u32;
        }

        visited[u] = true;

        let mut k: u32 = 0u32;
        while k < adj_size[u] {
            let edge: Edge = adj[u][k];
            let v: u32 = edge.to;
            let new_dist: u32 = dist[u] + edge.time;
            
            if new_dist < dist[v] {
                dist[v] = new_dist;
            }
            k = k + 1u32;
        }
        i = i + 1u32;
    }

    let mut max_time: u32 = 0u32;
    let mut m: u32 = 0u32;
    while m < n {
        if dist[m] == 999999u32 {
            return 999999u32;
        }
        if dist[m] > max_time {
            max_time = dist[m];
        }
        m = m + 1u32;
    }

    return max_time;
}
