package jp.co.wintechservice.webScheduler.calender_day;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * カレンダー日付作成クラス
 * @author KohariJunichiro
 *
 */
public class CalenderDay {

    int changeYear = 0;
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
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        int changeMonth = (Integer) session.getAttribute("changeMonth") % 12;

        /* 年をまたいだ際の年月計算 */
        month += changeMonth;
        if (month < 0) {
            month = 11;
            changeYear--;
            session.setAttribute("changeYear", changeYear);
            session.setAttribute("changeMonth", changeMonth);
        } else if (11 < month) {
            month = 0;
            changeYear++;
            session.setAttribute("changeYear", changeYear);
            session.setAttribute("changeMonth", changeMonth);
        }
        changeYear = (Integer) session.getAttribute("changeYear");
        year += changeYear;

        /* 先月最終日 */
        calendar2.set(year, month, 0);
        int previousMonthlastDay = calendar2.get(Calendar.DATE);
        /* 今月最終日 */
        calendar3.set(year, month + 1, 0);
        int thisMonthlastDay = calendar3.get(Calendar.DATE);
        /* 今月ついたちは何曜日?(日:1～土:７) */
        calendar4.set(year, month, 1);
        firstDayOfWeek = calendar4.get(Calendar.DAY_OF_WEEK);

        /* 35日分(1週間 * 5)の配列 */
        List<Integer> calendarDay35 = new ArrayList<Integer>();
        //            int[] calendarDay35 = new int[35];

        /* 先月分の日付 */
        for (int i = firstDayOfWeek - 2 ; i >= 0 ; i--){
            calendarDay35.add(previousMonthlastDay - i);
            //                calendarDay35[index++] = previousMonthlastDay - i;
        }

        /* 今月の日付 */
        for (int i = 1 ; i <= thisMonthlastDay ; i++){
            calendarDay35.add(i);
            //                calendarDay35[index++] = i;
        }
        /* 来月分の日付 */
        int nextMonthDay = 1;
        while (calendarDay35.size() < 35){
            calendarDay35.add(nextMonthDay++);
            //                calendarDay35[index++] = nextMonthDay++;
        }

        int count = 0;
        List<ArrayList<Integer>> calendarDay5_7 = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> calendarWeek = new ArrayList<Integer>();
            for (int j = 0; j < 7; j++) {
                int calendarDay = calendarDay35.get(count++);
                calendarWeek.add(calendarDay);
            }
            calendarDay5_7.add(calendarWeek);
        }



        //            int[][] calendarDay7_5 = new int[5][7];
        //            for (int i = 0; i < calendarDay7_5.length; i++) {
        //                for (int j = 0; j < calendarDay7_5[i].length; j++) {
        //                    calendarDay7_5[i][j] = calendarDay35[count++];
        //                }
        //            }

        /* 年と月配列 */
        int[] yearAndMonth = {year, month + 1};

        /* 年、月、日付配列をセッションスコープに格納 */
        session.setAttribute("yearAndMonth", yearAndMonth);
        session.setAttribute("calendarDay", calendarDay5_7);
        //            session.setAttribute("calendarDay", calendarDay7_5);

    }
}

