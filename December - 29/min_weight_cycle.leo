program min_weight_cycle;

struct Edge {
    u: u32,
    v: u32,
    w: u32,
}

function main(edges: [Edge; 50000], num_edges: u32, v: u32) -> u32 {
    let mut min_cycle: u32 = 999999u32;

    let mut i: u32 = 0u32;
    while i < num_edges {
        let edge: Edge = edges[i];
        
        let mut dist: [u32; 500] = [999999u32; 500];
        dist[edge.u] = 0u32;

        let mut k: u32 = 0u32;
        while k < v - 1u32 {
            let mut j: u32 = 0u32;
            while j < num_edges {
                let e: Edge = edges[j];
                if e.u == edge.u && e.v == edge.v {
                    j = j + 1u32;
                    continue;
                }
                
                if dist[e.u] != 999999u32 && dist[e.u] + e.w < dist[e.v] {
                    dist[e.v] = dist[e.u] + e.w;
                }
                if dist[e.v] != 999999u32 && dist[e.v] + e.w < dist[e.u] {
                    dist[e.u] = dist[e.v] + e.w;
                }
                j = j + 1u32;
            }
            k = k + 1u32;
        }

        if dist[edge.v] != 999999u32 {
            let cycle_weight: u32 = dist[edge.v] + edge.w;
            if cycle_weight < min_cycle {
                min_cycle = cycle_weight;
            }
        }
        i = i + 1u32;
    }

    return min_cycle;
}
