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

import jp.co.wintechservice.webScheduler.calender_day.CalenderDay;
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

    private int changeMonth = 0;

    CalenderDay calenderDay = new CalenderDay();

    /**
     * トップページのコントローラー
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/calender", method = RequestMethod.POST)
    public String calender(Model model, @ModelAttribute("loginForm")LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "index";
        }
        //SAMPLE123  ABC123

        List<MUser> userList = userRep.findAll();
        for (MUser mUser : userList) {
            if (mUser.getLoginId().equals(loginForm.getLoginId())) {
                changeMonth = 0;
                HttpSession session = request.getSession();
                session.setAttribute("changeMonth", changeMonth);
                calenderDay.setCalender(session);
                return "calender201902";
            }
        }
        return "index";
    }

    @RequestMapping(value = "/calender", params="previous", method = RequestMethod.POST)
    public String calenderPrevious(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        changeMonth--;
        session.setAttribute("changeMonth", changeMonth);
        calenderDay.setCalender(session);
        return "calender201902";
    }

    @RequestMapping(value = "/calender", params="thisMonth", method = RequestMethod.POST)
    public String calenderThisMonth(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        changeMonth = 0;
        session.setAttribute("changeMonth", changeMonth);
        calenderDay.setCalender(session);
        return "calender201902";
    }

    @RequestMapping(value = "/calender", params="next", method = RequestMethod.POST)
    public String calenderNext(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        changeMonth++;
        session.setAttribute("changeMonth", changeMonth);
        calenderDay.setCalender(session);
        return "calender201902";
    }

    @RequestMapping(value = "/scheduling", method = RequestMethod.POST)
    public String scheduling(Model model) {
        return "scheduling";
    }

    @RequestMapping(value = "/schedulingIsOk", method = RequestMethod.POST)
    public String schedulingIsOk(Model model) {
        return "schedulingIsOk";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
        return "index";
    }
}
