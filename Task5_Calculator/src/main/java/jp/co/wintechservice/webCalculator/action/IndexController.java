package jp.co.wintechservice.webCalculator.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.wintechservice.webCalculator.form.CalcForm;
import jp.co.wintechservice.webCalculator.logic.CalculationLogic;

/**
 * コントローラークラスの雛形
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
    /**
     * トップページのコントローラー
     *
     * @param model
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getCalcView(Model model, @ModelAttribute("calcform") CalcForm calcForm,
            BindingResult bindingResult, HttpServletRequest request) throws ServletException, IOException {
        if (bindingResult.hasErrors()) {
            return "calcView";
        }

        //CalculationLogicに計算してもらう
        CalculationLogic.calc(model, calcForm, request);

        return "calcView";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postCalcView(Model model, @ModelAttribute("calcForm") CalcForm calcForm,
             BindingResult bindingResult, HttpServletRequest request) throws ServletException, IOException {
        getCalcView(model, calcForm, bindingResult, request);
        return "calcView";
    }

}