pub fn brackets_are_balanced(string: &str) -> bool {
    let mut stack = Vec::new();
    for ch in string.chars() {
        if ch == '(' || ch == '[' || ch == '{' {
            stack.push(ch);
        } else if ch == ')' || ch == ']' || ch == '}' {
            if stack.is_empty() {
                return false;
            }
            if ch == ')' && stack.pop().unwrap() != '(' {
                return false;
            }
            if ch == ']' && stack.pop().unwrap() != '[' {
                return false;
            }
            if ch == '}' && stack.pop().unwrap() != '{' {
                return false;
            }
        }
    }
    return stack.is_empty();
}
