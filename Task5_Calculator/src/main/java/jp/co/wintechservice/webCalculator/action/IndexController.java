package jp.co.wintechservice.webCalculator.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.wintechservice.webCalculator.beans.CalcBean;
import jp.co.wintechservice.webCalculator.form.CalcForm;
import jp.co.wintechservice.webCalculator.logic.CalculationLogic;

//import jp.co.wintechservice.webCalculator.logic.CalculationLogic;


/**
 * コントローラークラスの雛形
 *
 */

@Controller
public class IndexController {

    @Autowired
    CalculationLogic calculate;
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
    public String postCalcView(@ModelAttribute("calcForm") CalcForm calcForm,
            @ModelAttribute("calcBean") CalcBean calcBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "calcView";
        }

        //CalculationLogicに計算してもらう
        calculate.calc(calcForm, calcBean);

        return "calcView";
    }

}