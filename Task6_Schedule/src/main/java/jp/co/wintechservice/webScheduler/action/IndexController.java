package jp.co.wintechservice.webScheduler.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.wintechservice.webScheduler.calendar_day.CalendarDay;
import jp.co.wintechservice.webScheduler.form.LoginForm;
import jp.co.wintechservice.webScheduler.model.MUser;
import jp.co.wintechservice.webScheduler.repository.UserRepository;

/**
 * コントローラークラスの雛形
 * @author KohariJunichiro
 */
@Controller
public class IndexController {

    @Autowired
    private UserRepository userRep;

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
                calendarDay.setCalender(session);
                return "calendar";
            }
        }
        if (request.getParameter("ok") != null) {
            return "calendar";
        }
        return "index";
    }

    /**
     * 前月のカレンダーを表示するコントローラー
     * @param model
     * @param request
     * @return calendar
     */
    @RequestMapping(value = "/calendar", params="previous", method = RequestMethod.POST)
    public String calendarPrevious(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("previous", "previous");
        calendarDay.setCalender(session);
        return "calendar";
    }

    @RequestMapping(value = "/calendar", params="thisMonth", method = RequestMethod.POST)
    public String calendarThisMonth(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("yearAndMonth", null);
        calendarDay.setCalender(session);
        return "calendar";
    }

    @RequestMapping(value = "/calendar", params="next", method = RequestMethod.POST)
    public String calendarNext(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("next", "next");
        calendarDay.setCalender(session);
        return "calendar";
    }

    @RequestMapping(value = "/scheduling", method = RequestMethod.POST)
    public String scheduling(Model model) {
        return "scheduling";
    }

    @RequestMapping(value = "/schedulingIsOk", method = RequestMethod.POST)
    public String schedulingIsOk(Model model, HttpServletRequest request) {
        if (request.getParameter("plan") != null) {
            return "schedulingIsOk";
        } else if (request.getParameter("return") != null) {
            return "calendar";
        }
        return "calendar";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
        return "index";
    }
}
