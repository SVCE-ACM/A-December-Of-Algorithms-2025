program perfect_squares;

function main(n: u32) -> (perfects: [u32; 100000], count: u32) {
    let mut arr: [u32; 100000] = [0u32; 100000];
    let mut k: u32 = 0u32;
    let mut i: u32 = 1u32;

    while i * i <= n {
        arr[k] = i * i;
        k = k + 1u32;
        i = i + 1u32;
    }

    return (arr, k);
}
