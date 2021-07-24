package sl.springboot.test.java8.optional;

import java.util.Date;

public class Person {

    private String timeStr;
    private Date dateTime;

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "timeStr='" + timeStr + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
