program mountain_peaks;

function main(heights: [u32; 100000], n: u32) -> ([u32; 100000], u32) {
    let mut peaks: [u32; 100000] = [0u32; 100000];
    let mut count: u32 = 0u32;

    if n < 3u32 {
        return (peaks, 0u32);
    }

    let mut i: u32 = 1u32;
    while i < n - 1u32 {
        if heights[i] > heights[i - 1u32] && heights[i] > heights[i + 1u32] {
            peaks[count] = i;
            count = count + 1u32;
        }
        i = i + 1u32;
    }

    return (peaks, count);
}
