package jp.co.wintechservice.webScheduler.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.wintechservice.webScheduler.form.LoginForm;

/**
 * コントローラークラスの雛形
 *
 */
@Controller
public class IndexController {

    /**
     * トップページのコントローラー
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public String top(Model model) {
        return "top";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
        return "index";
    }
}
