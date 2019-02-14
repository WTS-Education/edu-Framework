package jp.co.wintechservice.webScheduler.calender_day;

import java.util.Calendar;

public class CalenderDay {

    private int year, month, firstDay, lastDay;

    public CalenderDay(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public void calenderSet() {
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        for (int month = 1; month <= 12; month++) {
            CalenderDay calenderDay = new CalenderDay(nowYear, month);

        }
    }
}
