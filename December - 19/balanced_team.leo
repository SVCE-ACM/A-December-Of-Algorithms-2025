program balanced_team;

function main(skills: [u32; 30], n: u32) -> u32 {
    let mut total: u32 = 0u32;
    let mut i: u32 = 0u32;
    
    while i < n {
        total = total + skills[i];
        i = i + 1u32;
    }

    let max_sum: u32 = total / 2u32 + 1u32;
    let mut dp: [bool; 3001] = [false; 3001];
    dp[0u32] = true;

    let mut j: u32 = 0u32;
    while j < n {
        let mut s: u32 = max_sum;
        while s > 0u32 {
            if s >= skills[j] && dp[s - skills[j]] {
                dp[s] = true;
            }
            s = s - 1u32;
        }
        j = j + 1u32;
    }

    let mut closest: u32 = 0u32;
    let mut k: u32 = 0u32;
    while k <= max_sum {
        if dp[k] && k > closest {
            closest = k;
        }
        k = k + 1u32;
    }

    let diff: u32 = total - 2u32 * closest;
    return diff;
}
