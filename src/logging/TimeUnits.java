package logging;

public enum TimeUnits {
    NANOSECONDS(1),
    MICROSECONDS(1000),
    MILLISECONDS(1000 * 1000),
    SECONDS(1000 * 1000 * 1000),
    MINUTES(SECONDS.toNanos(60)),
    HOURS(SECONDS.toNanos(60 * 60)),
    DAYS(SECONDS.toNanos(60 * 60 * 24));

    public final long nanosPerUnit;

    TimeUnits(long nanosPerUnit) {
        this.nanosPerUnit = nanosPerUnit;
    }

    public long toNanos(long value) {
        return value * nanosPerUnit;
    }
}