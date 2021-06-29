pub fn build_proverb(list: &[&str]) -> String {
    if list.is_empty() {
        return String::new();
    }
    let mut ans = Vec::new();
    for i in 1..list.len() {
        ans.push(format!("For want of a {} the {} was lost.", list[i - 1], list[i]))
    }
    ans.push(format!("And all for the want of a {}.", list[0]));
    ans.join("\n")
}
