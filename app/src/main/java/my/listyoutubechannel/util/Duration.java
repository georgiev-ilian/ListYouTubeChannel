package my.listyoutubechannel.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describing video duration value received
 * from youtube service.
 * <p>
 * Created by ilian.
 */
public final class Duration {

    private int hours;

    private int minutes;

    private int seconds;

    private Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public int hashCode() {
        int hashCode = 31;

        hashCode = 31 * hashCode + this.hours;
        hashCode = 31 * hashCode + this.minutes;
        hashCode = 31 * hashCode + this.hours;

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Duration)) {
            return false;
        }

        Duration other = (Duration) obj;

        return this.seconds == other.seconds &&
               this.minutes == other.minutes &&
               this.hours == other.hours;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static Duration parse(String duration) {
        String pattern = "^PT(([0-9]*)H)?(([0-9]*)M)?(([0-9]*)S)?";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(duration);

        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        if (m.find()) {
            if (m.group(2) != null && m.group(2).length() > 0) {
                hours = Integer.valueOf(m.group(2));
            }

            if (m.group(4) != null && m.group(4).length() > 0) {
                minutes = Integer.valueOf(m.group(4));
            }

            if (m.group(6) != null && m.group(6).length() > 0) {
                seconds = Integer.valueOf(m.group(6));
            }

            return new Duration(hours, minutes, seconds);
        }

        throw new IllegalArgumentException("String duration : " + duration + " cannot be parsed.");
    }
}
