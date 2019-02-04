package jp.co.wintechservice.webCalculator.action;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.wintechservice.webCalculator.form.CalcForm;
import jp.co.wintechservice.webCalculator.logic.CalculationLogic;

//import jp.co.wintechservice.webCalculator.logic.CalculationLogic;


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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCalcView() {
        return "calcView";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postCalcView(Model model, @ModelAttribute("calcForm") CalcForm calcForm,
             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "calcView";
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
        CalculationLogic calcLogic = (CalculationLogic)context.getBean("calcLogic");

        //CalculationLogicに計算してもらう
        calcLogic.calc(calcForm);

        return "calcView";
    }

}