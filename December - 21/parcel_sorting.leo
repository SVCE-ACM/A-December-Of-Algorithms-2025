program parcel_sorting;

function main(weights: [u32; 10000], n: u32) -> [u32; 10000] {
    let mut queue: [u32; 10000] = [0u32; 10000];
    let mut sorted: [u32; 10000] = [0u32; 10000];
    let mut i: u32 = 0u32;
    
    while i < n {
        queue[i] = weights[i];
        i = i + 1u32;
    }

    let mut size: u32 = n;
    let mut sorted_idx: u32 = 0u32;

    while size > 0u32 {
        let mut min_idx: u32 = 0u32;
        let mut min_val: u32 = queue[0u32];
        let mut j: u32 = 1u32;
        
        while j < size {
            if queue[j] < min_val {
                min_val = queue[j];
                min_idx = j;
            }
            j = j + 1u32;
        }

        sorted[sorted_idx] = min_val;
        sorted_idx = sorted_idx + 1u32;

        let mut k: u32 = min_idx;
        while k < size - 1u32 {
            queue[k] = queue[k + 1u32];
            k = k + 1u32;
        }
        size = size - 1u32;
    }

    return sorted;
}
