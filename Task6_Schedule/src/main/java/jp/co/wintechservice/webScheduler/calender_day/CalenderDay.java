package jp.co.wintechservice.webScheduler.calender_day;

import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * カレンダー日付作成クラス
 * @author KohariJunichiro
 *
 */
public class CalenderDay {

    public void setCalender(HttpServletRequest request, int changeMonth) {
        int year, month, firstDayOfWeek;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        /* 12月 + 1 = 1月 */
        if (month + changeMonth == 13) {
            year--;
            month = 1;
            /* 1月 - 1 = 12月 */
        } else if (month + changeMonth == 0) {
            year++;
            month = 12;
        } else {
            month += changeMonth;
            calendar.set(year, month, 1);
            firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            /* 先月最終日 */
            calendar.set(year, month - 1, 0);
            int previousMonthlastDay = calendar.get(Calendar.DATE);
            /* 今月最終日 */
            calendar.set(year, month, 0);
            int thisMonthlastDay = calendar.get(Calendar.DATE);

            int[] calendarDay = new int[35];
            int index = 0;

            /* 先月分の日付 */
            for (int i = firstDayOfWeek - 2 ; i >= 0 ; i--){
                calendarDay[index++] = previousMonthlastDay - i;
            }

            /* 今月の日付 */
            for (int i = 1 ; i <= thisMonthlastDay ; i++){
                calendarDay[index++] = i;
            }
            /* 来月分の日付 */
            int nextMonthDay = 1;
            while (index < 35){
                calendarDay[index++] = nextMonthDay++;
            }

            /* 日付を格納した配列を5つ(5週分)に分割 */
            int[] firstWeek = Arrays.copyOfRange(calendarDay, 0, 6);
            int[] secondWeek = Arrays.copyOfRange(calendarDay, 7, 13);
            int[] thirdWeek = Arrays.copyOfRange(calendarDay, 14, 20);
            int[] forthWeek = Arrays.copyOfRange(calendarDay, 21, 27);
            int[] fifthWeek = Arrays.copyOfRange(calendarDay, 28, 34);


            HttpSession session = request.getSession();
            session.setAttribute("year", year);
            session.setAttribute("month", month);
            session.setAttribute("day", calendarDay);
        }
    }
}

