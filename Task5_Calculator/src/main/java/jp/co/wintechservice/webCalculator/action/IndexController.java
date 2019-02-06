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

//import jp.co.wintechservice.webCalculator.logic.CalculationLogic;


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
    public String getCalcView() {
        return "calcView";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postCalcView(Model model, @ModelAttribute("calcForm") CalcForm calcForm,
             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "calcView";
        }

        ApplicationContext logicContext = new ClassPathXmlApplicationContext("spring/application-config.xml");
        CalculationLogic calcLogic = (CalculationLogic)logicContext.getBean("calcLogic");

        //CalculationLogicに計算してもらう
        calcLogic.calc(model, calcForm);

        return "calcView";
    }

}