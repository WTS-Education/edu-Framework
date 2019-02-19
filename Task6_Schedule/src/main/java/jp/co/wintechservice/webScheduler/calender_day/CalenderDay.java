package jp.co.wintechservice.webScheduler.calender_day;

import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

/**
 * カレンダー日付作成クラス
 * @author KohariJunichiro
 *
 */
public class CalenderDay {

    public void setCalender(int changeMonth, HttpSession session) {
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

            /* 35日分(1週間 * 5)の配列 */
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

            /* 年と月配列 */
            int[] yearAndMonth = {year, month};

            /* 日付を格納した配列を5つ(5週分)に分割 */
            int[] firstWeek = Arrays.copyOfRange(calendarDay, 0, 7);
            int[] secondWeek = Arrays.copyOfRange(calendarDay, 8, 15);
            int[] thirdWeek = Arrays.copyOfRange(calendarDay, 16, 23);
            int[] forthWeek = Arrays.copyOfRange(calendarDay, 24, 31);
            int[] fifthWeek = Arrays.copyOfRange(calendarDay, 32, 39);

            /* 年、月、日付配列をセッションスコープに格納 */
            session.setAttribute("yearAndMonth", yearAndMonth);
            session.setAttribute("firstWeek", firstWeek);
            session.setAttribute("secondWeek", secondWeek);
            session.setAttribute("thirdWeek", thirdWeek);
            session.setAttribute("forthWeek", forthWeek);
            session.setAttribute("fifthWeek", fifthWeek);
        }
    }
}

