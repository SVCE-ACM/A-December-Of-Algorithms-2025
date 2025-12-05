program sum_unique_elements;

function main(arr: [i64; 100000], n: u32) -> i64 {
    let mut vals: [i64; 100000] = [0i64; 100000];
    let mut freq: [i64; 100000] = [0i64; 100000];
    let mut distinct: u32 = 0u32;

    let mut i: u32 = 0u32;
    while i < n {
        let x: i64 = arr[i];
        let mut found: bool = false;
        let mut j: u32 = 0u32;

        while j < distinct {
            if vals[j] == x {
                freq[j] = freq[j] + 1i64;
                found = true;
                break;
            }
            j = j + 1u32;
        }

        if found == false {
            vals[distinct] = x;
            freq[distinct] = 1i64;
            distinct = distinct + 1u32;
        }

        i = i + 1u32;
    }

    let mut sum: i64 = 0i64;
    let mut k: u32 = 0u32;

    while k < distinct {
        if freq[k] == 1i64 {
            sum = sum + vals[k];
        }
        k = k + 1u32;
    }

    return sum;
}
