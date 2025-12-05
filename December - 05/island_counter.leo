program island_counter;

function main(grid: [u8; 90000], r: u32, c: u32) -> u32 {
    let mut g: [u8; 90000] = grid;
    let mut stack_i: [u32; 90000] = [0u32; 90000];
    let mut stack_j: [u32; 90000] = [0u32; 90000];
    let mut top: u32 = 0u32;
    let mut count: u32 = 0u32;

    let mut i: u32 = 0u32;
    while i < r {
        let mut j: u32 = 0u32;
        while j < c {
            let idx: u32 = i * c + j;
            if g[idx] == 1u8 {
                count = count + 1u32;
                stack_i[top] = i;
                stack_j[top] = j;
                top = top + 1u32;
                while top > 0u32 {
                    top = top - 1u32;
                    let ci: u32 = stack_i[top];
                    let cj: u32 = stack_j[top];
                    let cidx: u32 = ci * c + cj;
                    if g[cidx] == 0u8 {
                        continue;
                    }
                    g[cidx] = 0u8;

                    if ci > 0u32 {
                        let ni: u32 = ci - 1u32;
                        let nj: u32 = cj;
                        let nidx: u32 = ni * c + nj;
                        if g[nidx] == 1u8 {
                            stack_i[top] = ni;
                            stack_j[top] = nj;
                            top = top + 1u32;
                        }
                    }
                    if ci + 1u32 < r {
                        let ni2: u32 = ci + 1u32;
                        let nj2: u32 = cj;
                        let nidx2: u32 = ni2 * c + nj2;
                        if g[nidx2] == 1u8 {
                            stack_i[top] = ni2;
                            stack_j[top] = nj2;
                            top = top + 1u32;
                        }
                    }
                    if cj > 0u32 {
                        let ni3: u32 = ci;
                        let nj3: u32 = cj - 1u32;
                        let nidx3: u32 = ni3 * c + nj3;
                        if g[nidx3] == 1u8 {
                            stack_i[top] = ni3;
                            stack_j[top] = nj3;
                            top = top + 1u32;
                        }
                    }
                    if cj + 1u32 < c {
                        let ni4: u32 = ci;
                        let nj4: u32 = cj + 1u32;
                        let nidx4: u32 = ni4 * c + nj4;
                        if g[nidx4] == 1u8 {
                            stack_i[top] = ni4;
                            stack_j[top] = nj4;
                            top = top + 1u32;
                        }
                    }
                }
            }
            j = j + 1u32;
        }
        i = i + 1u32;
    }

    return count;
}
