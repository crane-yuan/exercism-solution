pub fn raindrops(n: u32) -> String {
    let vec = vec![(3, "Pling"), (5, "Plang"), (7, "Plong")];
    let ans = vec
        .iter()
        .filter(|v| n % v.0 == 0)
        .map(|v| v.1.to_string())
        .collect::<Vec<_>>();
    if ans.is_empty() {
        n.to_string()
    } else {
        ans.join("")
    }
}
