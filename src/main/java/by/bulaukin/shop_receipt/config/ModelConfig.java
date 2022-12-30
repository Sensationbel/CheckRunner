package by.bulaukin.shop_receipt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ModelConfig {

    @Bean
    public ModelAndView modelAndView(){
        return new ModelAndView();
    }
}
