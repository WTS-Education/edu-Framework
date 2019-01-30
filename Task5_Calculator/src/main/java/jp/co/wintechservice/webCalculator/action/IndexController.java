package jp.co.wintechservice.webCalculator.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.wintechservice.webCalculator.logic.CalculationLogic;


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
    public String getCalcView(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        return "calcView";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postCalcView(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        //CalculationLogicに計算してもらう
        CalculationLogic.calc(request,response);
//        CalcBean calcBean = new CalcBean();
//        model.addAttribute("calcBean", calcBean);

        return "calcView";
    }

}