package jp.co.wintechservice.webScheduler.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * トップページのコントローラー
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/calender", method = RequestMethod.POST)
    public String calender(Model model, @ModelAttribute("loginForm")LoginForm loginForm, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return "index";
          }

        List<MUser> userList = userRep.findAll();
        for (MUser mUser : userList) {
            if (mUser.getLoginId().equals(loginForm.getLoginId())) {
                model.addAttribute("loginId", loginForm.getLoginId());
                return "calender201902";
            }
        }
        return "index";
    }

    @RequestMapping(value = "/calender", params="previous", method = RequestMethod.POST)
    public String calenderPrevious(Model model) {
       return "calender201901";
    }

    @RequestMapping(value = "/calender", params="next", method = RequestMethod.POST)
    public String calenderNext(Model model) {
       return "calender201903";
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
