class SpaceAge {

    private double seconds;
    private double years;

    SpaceAge(double seconds) {
        this.seconds = seconds;
        this.years = this.seconds / 31557600;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
        return this.years;
    }

    double onMercury() {
        return this.years / 0.2408467;
    }

    double onVenus() {
        return this.years / 0.61519726;
    }

    double onMars() {
        return this.years / 1.8808158;
    }

    double onJupiter() {
        return this.years / 11.862615;
    }

    double onSaturn() {
        return this.years / 29.447498;
    }

    double onUranus() {
        return this.years / 84.016846;
    }

    double onNeptune() {
        return this.years / 164.79132;
    }

}
