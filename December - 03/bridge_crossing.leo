program bridge_crossing;

function main(stones: [u32; 10000], len: u32) -> bool {
    let mut max_reach: u32 = 0u32;
    let mut i: u32 = 0u32;

    if len == 0u32 {
        return false;
    }

    while i <= max_reach && i < len {
        let jump: u32 = stones[i as u32];
        if i + jump > max_reach {
            max_reach = i + jump;
        }
        if max_reach + 1u32 >= len {
            return true;
        }
        i = i + 1u32;
    }

    return max_reach + 1u32 >= len;
}
