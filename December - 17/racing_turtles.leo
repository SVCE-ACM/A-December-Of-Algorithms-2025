program racing_turtles;

function main(target: u32, position: [u32; 100000], speed: [u32; 100000], n: u32) -> u32 {
    if n == 0u32 {
        return 0u32;
    }

    let mut times: [u32; 100000] = [0u32; 100000];
    let mut sorted_pos: [u32; 100000] = [0u32; 100000];
    let mut i: u32 = 0u32;

    while i < n {
        sorted_pos[i] = position[i];
        i = i + 1u32;
    }

    let mut j: u32 = 0u32;
    while j < n {
        let mut k: u32 = j + 1u32;
        while k < n {
            if sorted_pos[k] > sorted_pos[j] {
                let temp_pos: u32 = sorted_pos[j];
                sorted_pos[j] = sorted_pos[k];
                sorted_pos[k] = temp_pos;
            }
            k = k + 1u32;
        }
        j = j + 1u32;
    }

    let mut fleets: u32 = 0u32;
    let mut max_time: u32 = 0u32;
    let mut m: u32 = 0u32;

    while m < n {
        let pos: u32 = sorted_pos[m];
        let mut idx: u32 = 0u32;
        while idx < n && position[idx] != pos {
            idx = idx + 1u32;
        }
        
        let time: u32 = (target - pos) / speed[idx];
        
        if time > max_time {
            fleets = fleets + 1u32;
            max_time = time;
        }
        m = m + 1u32;
    }

    return fleets;
}
