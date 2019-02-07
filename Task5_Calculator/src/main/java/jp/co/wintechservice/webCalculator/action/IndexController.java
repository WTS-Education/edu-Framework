package jp.co.wintechservice.webCalculator.action;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.wintechservice.webCalculator.beans.CalcBean;
import jp.co.wintechservice.webCalculator.form.CalcForm;
import jp.co.wintechservice.webCalculator.logic.CalculationLogic;

/**
 * コントローラークラスの雛形
 *
 */
@Controller
@RequestMapping("/")
@SessionAttributes(types = CalcBean.class)
public class IndexController {
    /**
     * トップページのコントローラー
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getCalcView(Model model, @ModelAttribute("calcform") CalcForm calcForm,
            BindingResult bindingResult, CalcBean calcBean) {
        postCalcView(model, calcForm, bindingResult, calcBean);
        return "calcView";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ModelAttribute("calcBean")
    public String postCalcView(Model model, @ModelAttribute("calcForm") CalcForm calcForm,
             BindingResult bindingResult, CalcBean calcBean) {
        if (bindingResult.hasErrors()) {
            return "calcView";
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
        CalculationLogic calcLogic = (CalculationLogic) context.getBean("calcLogic");

        //CalculationLogicに計算してもらう
        calcLogic.calc(model, calcForm, calcBean);

        return "calcView";
    }

}