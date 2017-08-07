package registration;
import utils.Time;

/**
 * Represents the time at which a lecture is held
 *
 * @author spatel475
 * @version 1.0
 */
public class LectureTime {
    private LectureDays days;
    private Time startTime;
    private Time endTime;

    /**
     * Creates a LectureTime
     *
     * @param days the days on which lecture occurs
     * @param startHour the hour of the lecture's start time
     * @param startMinute the minute of the lecture's start time
     * @param endHour the hour of the lecture's end time
     * @param endMinute the minute of the lecture's end time
     *
     */
    public LectureTime(LectureDays days, int startHour,
        int startMinute, int endHour, int endMinute) {
        this.days = days;
        this.startTime = new Time(startHour, startMinute);
        this.endTime = new Time(endHour, endMinute);
    }

    /**
     * @return the days of lecture
     */
    public LectureDays getDays() {
        return days;
    }

    /**
     * @return the starting time of lecture
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * @return the ending time of lecture
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Determines whether two lecture times have any overlap
     *
     * @param time the time being checked for overlap with this time
     * @return true if the two lectures overlap and false otherwise
     */
    public boolean overlap(LectureTime time) {
        if (days != time.days) {
            return false;
        }
        Time endEarlierTime;
        Time startLaterTime;
        if (startTime.before(time.startTime)) {
            endEarlierTime = endTime;
            startLaterTime = time.startTime;
        } else {
            endEarlierTime = time.endTime;
            startLaterTime = startTime;
        }
        return !endEarlierTime.before(startLaterTime);
    }
}
