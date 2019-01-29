package jp.co.wintechservice.webCalculator.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
}