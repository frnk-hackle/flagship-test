package io.flagship.test;


import com.abtasty.flagship.main.Flagship;
import com.abtasty.flagship.main.FlagshipConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfiguration {

    @PostConstruct
    public void init() {
        System.out.println("Flagshipt start");
        Flagship.start("cchdo9r1idc010k92r70", "fNhUYdUXKhEiUNlHSSOhKawQJanWrHNvRBOcQKtq", new FlagshipConfig.DecisionApi());
    }

}
