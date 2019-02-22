package jp.co.wintechservice.webScheduler.calendar_day;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * カレンダー日付作成クラス
 * @author KohariJunichiro
 *
 */
public class CalendarDay {

    /**
     * カレンダーの日付を動的に表示するための計算
     * 日付情報をリストに入れてセッションスコープに格納
     * @param session
     */
    public void setCalender(HttpSession session) {
        int year, month, firstDayOfWeek;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        Calendar calendar4 = Calendar.getInstance();

        /* 現在表示されている年、月を格納する配列 [0] = 年 [1] = 月 */
        int[] yearAndMonth = (int[]) session.getAttribute("yearAndMonth");
        if (yearAndMonth == null) {
            yearAndMonth = new int[3];
            yearAndMonth[0] = calendar.get(Calendar.YEAR);
            yearAndMonth[1] = calendar.get(Calendar.MONTH);
        }
        year = yearAndMonth[0];
        month = yearAndMonth[1];

        /* 月の値を加算減算 */
        if (session.getAttribute("previous") != null) {
            if (month == 0) {
                year -= 1;
                month = 11;
                yearAndMonth[0] = year;
            } else {
                month -= 1;
            }
            session.setAttribute("previous", null);
        } else if (session.getAttribute("next") != null) {
            if (month == 11) {
                year += 1;
                month = 0;
                yearAndMonth[0] = year;
            } else {
                month += 1;
            }
            session.setAttribute("next", null);
        }
        yearAndMonth[1] = month;

        /* 先月最終日 */
        calendar2.set(year, month, 0);
        int previousMonthlastDay = calendar2.get(Calendar.DATE);
        /* 今月最終日 */
        calendar3.set(year, month + 1, 0);
        int thisMonthlastDay = calendar3.get(Calendar.DATE);
        yearAndMonth[2] = thisMonthlastDay;
        /* 今月ついたちは何曜日?(日:1～土:７) */
        calendar4.set(year, month, 1);
        firstDayOfWeek = calendar4.get(Calendar.DAY_OF_WEEK);

        session.setAttribute("yearAndMonth", yearAndMonth);

        /* 35日分(1週間 * 5)の配列 */
        List<Integer> calendarDay = new ArrayList<Integer>();
        //            int[] calendarDay = new int[35];

        /* 先月分の日付 */
        for (int i = firstDayOfWeek - 2 ; i >= 0 ; i--){
            calendarDay.add(previousMonthlastDay - i);
            //                calendarDay[index++] = previousMonthlastDay - i;
        }

        /* 今月の日付 */
        for (int i = 1 ; i <= thisMonthlastDay ; i++){
            calendarDay.add(i);
            //                calendarDay[index++] = i;
        }
        /* 来月分の日付 */
        int nextMonthDay = 1;
        while (calendarDay.size() < 42){
            calendarDay.add(nextMonthDay++);
            //                calendarDay[index++] = nextMonthDay++;
        }

        int count = 0;
        List<ArrayList<Integer>> calendarDayDividedBy5or6weeks = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < 6; i++) {
                ArrayList<Integer> calendarWeek = new ArrayList<Integer>();
                for (int j = 0; j < 7; j++) {
                    int oneWeek = calendarDay.get(count++);
                    calendarWeek.add(oneWeek);
                }
                calendarDayDividedBy5or6weeks.add(calendarWeek);
                if (i == 4 && calendarWeek.contains(thisMonthlastDay)) {
                    break;
                }
            }

        //            int[][] calendarDay7_5 = new int[5][7];
        //            for (int i = 0; i < calendarDay7_5.length; i++) {
        //                for (int j = 0; j < calendarDay7_5[i].length; j++) {
        //                    calendarDay7_5[i][j] = calendarDay[count++];
        //                }
        //            }

        /* 日付配列をセッションスコープに格納 */
        session.setAttribute("calendarDayDividedBy5or6weeks", calendarDayDividedBy5or6weeks);
        //            session.setAttribute("calendarDay", calendarDay7_5);

    }
}

