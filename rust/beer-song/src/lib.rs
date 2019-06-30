pub fn verse(n: i32) -> String {
    let no_bottle = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
    if n == 0 { return no_bottle.to_string(); }

    let bottle_1 = "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n";

    if n == 1 { return bottle_1.to_string(); }

    let bottle_2 = "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n";
    if n == 2 { return bottle_2.to_string(); }

    format!("{} bottles of beer on the wall, {} bottles of beer.\nTake one down and pass it around, {} bottles of beer on the wall.\n", n, n, n - 1)
}

pub fn sing(start: i32, end: i32) -> String {
    let mut result = String::new();
    let mut i = start;
    let mut spilt_str = "";
    while i >= end {
        result.push_str(spilt_str);
        result.push_str(&verse(i));
        i -= 1;
        spilt_str = "\n";
    }

    result
}
