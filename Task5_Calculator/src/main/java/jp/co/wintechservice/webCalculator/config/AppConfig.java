package jp.co.wintechservice.webCalculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.wintechservice.webCalculator.beans.CalcBean;
import jp.co.wintechservice.webCalculator.logic.CalculationLogic;

@Configuration
public class AppConfig {

    @Bean(name = "calcLogic")
    CalculationLogic calculationLogic() {
        return new CalculationLogic();
    }

    @Bean(name = "calcBean")
    CalcBean calcBean() {
        return new CalcBean();
    }

}
