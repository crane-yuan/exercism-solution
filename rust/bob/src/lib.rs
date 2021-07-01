pub fn reply(message: &str) -> &str {
    match message {
        msg if has_yell(msg) && has_question(msg) => "Calm down, I know what I'm doing!",
        msg if has_question(msg) => "Sure.",
        msg if has_yell(msg) => "Whoa, chill out!",
        msg if has_silence(msg) => "Fine. Be that way!",
        _ => "Whatever."
    }
}

fn has_yell(message: &str) -> bool {
    let chars = message.trim_matches(|a: char| !a.is_alphabetic());
    !chars.is_empty() && chars.to_uppercase().eq(chars)
}

fn has_question(message: &str) -> bool {
    message.trim_end().ends_with('?')
}

fn has_silence(message: &str) -> bool {
    message.trim().is_empty()
}
