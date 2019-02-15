package jp.co.wintechservice.webScheduler.calender_day;

import java.util.Calendar;

/**
 * カレンダー日付作成クラス
 * @author KohariJunichiro
 *
 */
public class CalenderDay {

    public void setCalender() {
        int year, month, firstDayOfWeek;
        Calendar calendar = Calendar.getInstance();
        for (year = 2018; year <= 2019; year++) {
            for (month = 1; month <= 12; month++) {
                calendar.set(year, month, 1);
                firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            }
        }


    }
}
