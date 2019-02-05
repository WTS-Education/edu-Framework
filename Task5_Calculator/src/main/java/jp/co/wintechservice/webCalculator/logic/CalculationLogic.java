package jp.co.wintechservice.webCalculator.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.wintechservice.webCalculator.beans.CalcBean;
import jp.co.wintechservice.webCalculator.form.CalcForm;

/**
 * Servlet implementation class CalclatorLogic
 */
public class CalculationLogic extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculationLogic() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    public void calc(Model model, @ModelAttribute("calcForm") CalcForm calcForm) {

        // TODO Auto-generated method stub

        ApplicationContext beanContext = new ClassPathXmlApplicationContext("spring/application-config.xml");
        CalcBean calc = (CalcBean)beanContext.getBean("calcBean");

        CalcForm form = calcForm;

        if (!model.containsAttribute("calcBean")) {
            model.addAttribute("calcBean", calc);
            calc.setOutput("0");
            calc.setInput("0");
            calc.setOperator("");
            calc.setExpression("");
            calc.setX("");
        }

        boolean numExists;
        boolean operatorExists;
        boolean delExists;
        boolean plusAlphaExists;

        //num(数字、小数点)が押下された場合
        if (form.getNum() != null) {
            String num = form.getNum();
            //numが小数点かつoutputが整数
            if (num.equals(".") && !calc.getOutput().contains(".")) {
                calc.setOutput(calc.getOutput() + num);
            }
            //numが数字の場合
            else if(!num.equals(".")) {
                if (calc.getOutput().indexOf("0") == 0) {
                    String havingFirstZero = calc.getOutput() + num;
                    StringBuilder killingFirstZero = new StringBuilder(havingFirstZero);
                    killingFirstZero.deleteCharAt(0);
                    calc.setOutput(killingFirstZero.toString());
                } else {
                  //直前に演算子を押下していた場合
                    if (operatorExists = true) {
                        calc.setOutput(num);
                        operatorExists = false;
                        } else {
                          //押下された数字を連結して出力
                            calc.setOutput(calc.getOutput() + num);
                        }
                }
            }
            numExists = true;
        }
        //operatorが押下された場合
        else if (form.getOperator() != null){
            String operator = form.getOperator();
            //直前にoperator(イコールを除く)を押下していた場合
            if (operatorExists = true && !operator.equals("=")) {
                //計算せずにoutputの値を控えておくだけ
                calc.setInput(calc.getOutput());
                //新しく押下されたオペレータをセット
                calc.setOperator(operator);
            } else {
                BigDecimal result = new BigDecimal(calc.getOutput());
                BigDecimal x = new BigDecimal(calc.getInput());
                //前回の計算結果
                String previousResult = calc.getOutput();
                //起動して初めてオペレーターが押下された場合
                if (calc.getOperator().isEmpty()) {
                    //計算式を作成
                    calc.setExpression(previousResult + " " + operator);
                    //入力された数字を控えておく
                    calc.setInput(calc.getOutput());
                } else {
                  //足し算
                    if (calc.getOperator().equals("+")) {
                        calc.setOutput(x.add(result).toString());
                    }
                    //引き算
                    else if (calc.getOperator().equals("-")) {
                        calc.setOutput(x.subtract(result).toString());
                    }
                    //掛け算
                    else if (calc.getOperator().equals("×")) {
                        calc.setOutput(x.multiply(result).toString());
                    }
                    //割り算
                    else if (calc.getOperator().equals("÷")) {
                        calc.setOutput(x.divide(result, 15, RoundingMode.HALF_UP).stripTrailingZeros().toString());
                    }
                    //計算式を作成
                    calc.setExpression(calc.getExpression() + " " + previousResult + " " + operator + " ");
                }
                //イコールが押下された場合
                if (operator.equals("=")) {
                    //前回の演算子
                    String previousOperator = calc.getOperator();
                    //直前に数字を押下している場合
                    if (numExists = true) {
                        //前回の計算結果を控えておく
                        calc.setInput(previousResult);
                        numExists = false;
                        operator = previousOperator;
                    }
                    //直前にイコールを押下していた場合
                    else {
                        operator = previousOperator;
                        //前回の計算結果を控えない
                    }
                    //計算式削除
                    calc.setExpression("");
                } else {
                    //計算結果を控えておく
                    calc.setInput(calc.getOutput());
                }
                //operatorを控えておく
                calc.setOperator(operator);
                operatorExists = true;
            }
        }


        //plusAlphaが押下された場合(±、√、x²、1/x)
        else if (form.getPlusAlpha() != null) {
            String plusAlpha = form.getPlusAlpha();
            calc.setX(calc.getOutput());
            if (plusAlpha.equals("±")) {
                calc.setOutput(String.valueOf(Integer.parseInt(calc.getOutput()) * -1));
            } else {
              //百分率
                if (plusAlpha.equals("%")) {
                    BigDecimal hundred = new BigDecimal(100);
                    BigDecimal output = new BigDecimal(calc.getOutput());
                    BigDecimal input = new BigDecimal(calc.getInput());
                    //output * (input /100)
                    String percent = String.valueOf(output.multiply(input.divide(hundred, 15, RoundingMode.HALF_UP)).stripTrailingZeros());
                    calc.setOutput(percent);
                } else {
                    //平方根
                    if (plusAlpha.equals("√")) {
                        String sqrt = String.valueOf(Math.sqrt(Double.parseDouble(calc.getOutput())));
                        calc.setOutput(sqrt);

                            String expressionArray[] = calc.getExpression().split(" ");
                            int index = expressionArray.length -1;
                            expressionArray[index] = " √(" + calc.getX() + ")";
                            calc.setExpression(String.join(" ", expressionArray));
                          }

                      //2乗
                        else if (plusAlpha.equals("x²")) {
                            BigDecimal square = new BigDecimal(calc.getOutput());
                            calc.setOutput(square.multiply(square).toString());

                                String expressionArray[] = calc.getExpression().split(" ");
                                int index = expressionArray.length -1;
                                expressionArray[index] = " sqrt(" + calc.getX() + ")";
                                calc.setExpression(String.join(" ", expressionArray));
                            }

                    //逆数
                    else if (plusAlpha.equals("1/x")) {
                        BigDecimal one = new BigDecimal(1);
                        BigDecimal inverse = new BigDecimal(calc.getOutput());
                        calc.setOutput(one.divide(inverse, 15, RoundingMode.HALF_UP).stripTrailingZeros().toString());


                            String expressionArray[] = calc.getExpression().split(" ");
                            int index = expressionArray.length -1;
                            expressionArray[index] = " 1/(" + calc.getX() + ")";
                            calc.setExpression(String.join(" ", expressionArray));
                        }
                    }
                    String expressionArray[] = calc.getExpression().split(" ");
                    int index = expressionArray.length -1;
                    calc.setX(expressionArray[index]);

                    }
                }


       //CE,C,戻 が押下された場合
        else  if (form.getDel() != null) {
             String del = form.getDel();
             //CE(入力中の文字を削除)
             if (del.equals("CE")) {
                 calc.setOutput("0");
             }
             //C(リセット)
             else if (del.equals("C")) {
                 calc.setOutput("0");
                 calc.setInput("0");
                 calc.setOperator("");
                 calc.setExpression("");
                 operatorExists = false;
                 plusAlphaExists = false;
             }
             //◀(バックスペース)
             else if (del.equals("◀")){
                 //押下された値の桁数
                 int length = String.valueOf(calc.getOutput()).length();
                 //最後尾の数字のインデックス
                 int lengthBack = length - 1;
                 if (length > 1) {
                    StringBuilder back = new StringBuilder(calc.getOutput());
                    back.deleteCharAt(lengthBack);
                    calc.setOutput(back.toString());
                }
             }
         }
     }
}
