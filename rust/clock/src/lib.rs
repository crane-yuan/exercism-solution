use std::fmt;

#[derive(Debug, Eq, PartialEq)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

const HOURS_PER_DAY: i32 = 24;
const MINUTES_PER_HOUR: i32 = 60;

impl Clock {
    fn normalize(hours: i32, minutes: i32) -> (i32, i32) {
        let extra_hrs_from_min = (minutes / MINUTES_PER_HOUR) % HOURS_PER_DAY;
        let mut hour = (hours + extra_hrs_from_min) % HOURS_PER_DAY;

        let mut minute = minutes % MINUTES_PER_HOUR;

        if minute < 0 {
            hour -= 1;
            minute += MINUTES_PER_HOUR;
        }

        if hour < 0 {
            hour += HOURS_PER_DAY;
        }

        (hour, minute)
    }

    pub fn new(hours: i32, minutes: i32) -> Self {
        let (h, m) = Clock::normalize(hours, minutes);
        Clock {
            hours: h,
            minutes: m,
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Clock::new(self.hours, self.minutes + minutes)
    }
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{:02}:{:02}", self.hours, self.minutes)
    }
}

