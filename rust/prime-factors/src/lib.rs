pub fn factors(mut n: u64) -> Vec<u64> {
    let mut ans = Vec::new();
    for num in 2..=n {
        while n % num == 0 {
            ans.push(num);
            n /= num;
        }
        if n == 1 {
            break;
        }
    }
    ans
}
