pub fn sum_of_multiples(limit: u32, factors: &[u32]) -> u32 {
    let mut sum = 0u32;
    for num in 1..limit {
        for fac in factors {
            if (0 != *fac) && (num % fac == 0) {
                sum += num;
                break;
            }
        }
    }

    sum
}
