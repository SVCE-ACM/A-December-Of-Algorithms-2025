program baseball_score;

function main(ops: [i32; 1000], kinds: [u8; 1000], len: u32) -> i32 {
    let mut stack: [i32; 1000] = [0i32; 1000];
    let mut top: u32 = 0u32;
    let mut i: u32 = 0u32;

    while i < len {
        let k: u8 = kinds[i as u32];
        if k == 0u8 {
            let v: i32 = ops[i as u32];
            stack[top] = v;
            top = top + 1u32;
        } else if k == 1u8 {
            let v1: i32 = stack[top - 1u32];
            let v2: i32 = stack[top - 2u32];
            let v: i32 = v1 + v2;
            stack[top] = v;
            top = top + 1u32;
        } else if k == 2u8 {
            let v1: i32 = stack[top - 1u32];
            let v: i32 = v1 + v1;
            stack[top] = v;
            top = top + 1u32;
        } else if k == 3u8 {
            if top > 0u32 {
                top = top - 1u32;
            }
        }
        i = i + 1u32;
    }

    let mut sum: i32 = 0i32;
    let mut j: u32 = 0u32;
    while j < top {
        sum = sum + stack[j];
        j = j + 1u32;
    }

    return sum;
}
