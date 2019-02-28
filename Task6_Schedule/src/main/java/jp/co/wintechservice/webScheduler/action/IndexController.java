package jp.co.wintechservice.webScheduler.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.wintechservice.webScheduler.calendar_day.CalendarDay;
import jp.co.wintechservice.webScheduler.form.LoginForm;
import jp.co.wintechservice.webScheduler.form.ScheduleForm;
import jp.co.wintechservice.webScheduler.model.MUser;
import jp.co.wintechservice.webScheduler.model.TSchedule;
import jp.co.wintechservice.webScheduler.repository.TscheduleRepository;
import jp.co.wintechservice.webScheduler.repository.UserRepository;

/**
 * コントローラークラスの雛形
 * @author KohariJunichiro
 */
@Controller
public class IndexController {

    @Autowired
    private UserRepository userRep;
    @Autowired
    private TscheduleRepository tscheRep;

    private ApplicationContext context;

    private EntityManager manager;

    CalendarDay calendarDay = new CalendarDay();

    /**
     * トップページのコントローラー
     * @param model
     * @return
     */
    @RequestMapping(value = "/calendar", method = RequestMethod.POST)
    public String calendar(Model model, @ModelAttribute("loginForm")LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "index";
        }
        //SAMPLE123  ABC123

        List<MUser> userList = userRep.findAll();
        for (MUser mUser : userList) {
            if (mUser.getLoginId().equals(loginForm.getLoginId())) {
                HttpSession session = request.getSession();
                session.setAttribute("yearAndMonth", null);
                int userId = mUser.getUserId();
                session.setAttribute("userId", userId);
                String userName = mUser.getUserName();
                session.setAttribute("userName", userName);
                calendarDay.setCalender(session);
                List<TSchedule> scheuleList = tscheRep.findAll();
                session.setAttribute("scheduleList", scheuleList);
                return "calendar";
            }
        }
        if (request.getParameter("ok") != null) {
            HttpSession session = request.getSession();
            List<TSchedule> scheuleList = tscheRep.findAll();
            session.setAttribute("scheduleList", scheuleList);
            return "calendar";
        }
        return "index";
    }

    /**
     * ◀ボタンが押下された際に前月のカレンダーを表示するコントローラー
     * @param model
     * @param request
     * @return "calendar"
     */
    @RequestMapping(value = "/calendar", params="previous", method = RequestMethod.POST)
    public String calendarPrevious(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("previous", "previous");
        calendarDay.setCalender(session);
        List<TSchedule> scheuleList = tscheRep.findAll();
        session.setAttribute("scheduleList", scheuleList);
        return "calendar";
    }

    /**
     * 今月ボタンが押下された際に今月のカレンダーを表示させるコントローラー
     * @param model
     * @param request
     * @return "calendar"
     */
    @RequestMapping(value = "/calendar", params="thisMonth", method = RequestMethod.POST)
    public String calendarThisMonth(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("yearAndMonth", null);
        calendarDay.setCalender(session);
        List<TSchedule> scheuleList = tscheRep.findAll();
        session.setAttribute("scheduleList", scheuleList);
        return "calendar";
    }

    /**
     * ▶ボタンが押下された際に翌月のカレンダーを表示させるコントローラー
     * @param model
     * @param request
     * @return "calendar"
     */
    @RequestMapping(value = "/calendar", params="next", method = RequestMethod.POST)
    public String calendarNext(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("next", "next");
        calendarDay.setCalender(session);
        List<TSchedule> scheduleList = tscheRep.findAll();
        session.setAttribute("scheduleList", scheduleList);
        return "calendar";
    }

    /**
     * カレンダー→スケジュール登録ページ
     * @param model
     * @param request
     * @return "sceduling"
     */
    @RequestMapping(value = "/scheduling", method = RequestMethod.POST)
    public String scheduling(Model model, HttpServletRequest request, @RequestParam(name="selectedDay")String day) {
        HttpSession session = request.getSession();
        int selectedDay = Integer.parseInt(day);
        session.setAttribute("selectedDay", selectedDay);
        return "scheduling";
    }

    /**
     * スケジュール登録「登録ボタン」→登録完了ページ
     * スケジュール登録「戻るボタン」→カレンダーページ
     * @param model
     * @param request
     * @return "schedulingIsOk"
     * @return "calendar"
     */
    @RequestMapping(value = "/schedulingIsOk", method = RequestMethod.POST)
    public String schedulingIsOk(Model model, HttpServletRequest request, @ModelAttribute("scheduleForm")ScheduleForm scheduleForm) {
        HttpSession session = request.getSession();
        if (request.getParameter("plan") != null || request.getParameter("update") != null) {
            /*
             * TScheduleエンティティインスタンス作成
             * startTimestamp, endTimestamp, title, description, note,
             * editAuthority, releaseFlg, insertDate, insertUser, deleteFlg
             */
            TSchedule tSchedule = new TSchedule();

            //登録者、登録日時・更新者、更新日時セット
            int userId = (Integer) session.getAttribute("userId");
            Timestamp todayTimestamp = new Timestamp(System.currentTimeMillis());
            if (request.getParameter("plan") != null) {
                tSchedule.setInsertUser(userId);
                tSchedule.setInsertDate(todayTimestamp);
            } else if (request.getParameter("update") != null) {
                tSchedule.setUpdateUser(userId);
                tSchedule.setUpdateDate(todayTimestamp);
                TSchedule schedule = (TSchedule) session.getAttribute("schedule");
                tSchedule.setScheduleId(schedule.getScheduleId());
                tSchedule.setInsertUser(schedule.getInsertUser());
                tSchedule.setInsertDate(schedule.getInsertDate());
            }

            //開始日時セット
            Calendar startCal = Calendar.getInstance();
            startCal.set(Integer.parseInt(scheduleForm.getStartYear()), Integer.parseInt(scheduleForm.getStartMonth()) - 1,
                    Integer.parseInt(scheduleForm.getStartDay()), Integer.parseInt(scheduleForm.getStartOclock()),
                    Integer.parseInt(scheduleForm.getStartMinute()));
            Timestamp startTimestamp = new Timestamp(startCal.getTimeInMillis());
            tSchedule.setStartTimestamp(startTimestamp);

            //終了日時セット
            Calendar endCal = Calendar.getInstance();
            endCal.set(Integer.parseInt(scheduleForm.getEndYear()), Integer.parseInt(scheduleForm.getEndMonth()) - 1,
                    Integer.parseInt(scheduleForm.getEndDay()), Integer.parseInt(scheduleForm.getEndOclock()),
                    Integer.parseInt(scheduleForm.getEndMinute()));
            Timestamp endTimestamp = new Timestamp(endCal.getTimeInMillis());
            tSchedule.setEndTimestamp(endTimestamp);

            //タイトル、タイトル色、内容、備考、編集権限、公開範囲、削除フラグセット
            tSchedule.setTitle(scheduleForm.getTitle());
            tSchedule.setTitleColor(Integer.parseInt(scheduleForm.getTitleColor()));
            tSchedule.setDescription(scheduleForm.getDescription());
            tSchedule.setNote(scheduleForm.getNote());
            tSchedule.setEditAuthority(userId);
            tSchedule.setReleaseFlg("0");
            tSchedule.setDeleteFlg("0");

            //スケジュール登録
            tscheRep.saveAndFlush(tSchedule);

            session.setAttribute("updateAndDelete", null);
            session.setAttribute("selectedDay", null);

            return "schedulingIsOk";
        } else if (request.getParameter("delete") != null) {
            session.setAttribute("updateAndDelete", null);
            session.setAttribute("selectedDay", null);
            return "delete_check";
        } else if (request.getParameter("return") != null) {
            List<TSchedule> scheuleList = tscheRep.findAll();
            session.setAttribute("scheduleList", scheuleList);
            session.setAttribute("updateAndDelete", null);
            session.setAttribute("selectedDay", null);
            session.setAttribute("startDay", null);
            return "calendar";
        }
        return "calendar";
    }

    /**
     * 削除クリック→削除確認ページ
     * @param model
     * @param request
     * @return "deletingIsOk"
     * @return "scheduling"
     */
    @RequestMapping(value = "/deletingIsOk", method = RequestMethod.POST)
    public String deletingIsOk(Model model, HttpServletRequest request) {
        if (request.getParameter("yes") != null) {
            HttpSession session = request.getSession();
            TSchedule schedule = (TSchedule) session.getAttribute("schedule");
            tscheRep.delete(schedule);
            return "deletingIsOk";
        } else if (request.getParameter("no") != null) {
            return "scheduling";
        }
        return "deletingIsOk";
    }


    /**
     * ログインページを表示させるコントローラー
     * @param model
     * @param loginForm
     * @return "index"
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
        return "index";
    }

    /**
     *  カレンダーの予定リンク→更新削除ページ
     * @param model
     * @param request
     * @return "scheduling"
     */
    @RequestMapping(value = "/scheduling", method = RequestMethod.GET)
    public String updateAndDelete(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int scheduleId = Integer.parseInt(request.getParameter("id"));
        Optional<TSchedule> scheduleOfThisDay = tscheRep.findById(scheduleId);
        if (scheduleOfThisDay.isPresent()) {
            TSchedule schedule = scheduleOfThisDay.get();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(schedule.getStartTimestamp().getTime());
            int[] scheduleDay = {calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE)};
            session.setAttribute("scheduleDay", scheduleDay);
            session.setAttribute("schedule", schedule);
            session.setAttribute("titleColor", schedule.getTitleColor());
        }
        session.setAttribute("updateAndDelete", "updateAndDelete");
        return "scheduling";
    }

}
