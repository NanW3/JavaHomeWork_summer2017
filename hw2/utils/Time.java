package utils;

/**
 * Represents a time with hours and minutes
 *
 * @author spatel475
 * @version 1.0
 */
public class Time {
    private int hour;
    private int minute;

    /**
     * Creates a Time
     *
     * @param hour the hour of the time
     * @param minute the minute of the time
     * @throws IllegalArgumentException if hours not between 0 and 23
     * and minute not between 0 and 59
     */
    public Time(int hour, int minute) {
        if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
            throw new IllegalArgumentException("Invalid time! Hour must be "
                + "between 0 and 23 and minute between 0 and 59");
        }
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * @return the hour of the time
     */
    public int getHour() {
        return hour;
    }

    /**
     * @return the minute of the time
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @return A string of the form "hour:minute"
     */
    public String toString() {
        return hour + ":" + minute;
    }

    /**
     * Returns whether time occurs before this time.
     *
     * @param time the time being compared to this time
     * @return true if time occurs before this time and false otherwise
     */
    public boolean before(Time time) {
        if (hour > time.hour) {
            return false;
        }
        if (hour < time.hour) {
            return true;
        }
        if (minute <= time.minute) {
            return true;
        }
        return false;
    }
}
