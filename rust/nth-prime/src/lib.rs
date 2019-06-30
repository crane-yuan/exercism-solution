pub fn nth(n: u32) -> u32 {
    let mut cur: u32 = 2;
    let mut prime: u32 = 0;
    while prime < n {
        cur += 1;
        if is_prime(cur) { prime += 1 }
    }
    cur
}

fn is_prime(n: u32) -> bool {
    if n == 1 {
        return false;
    }
    if n % 2 == 0 {
        return false;
    }
    for i in 2..(n as f64).sqrt() as u32 + 1 {
        if n % i == 0 {
            return false;
        }
    }
    true
}
