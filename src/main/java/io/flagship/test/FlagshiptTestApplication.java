package io.flagship.test;

import com.abtasty.flagship.main.Flagship;
import com.abtasty.flagship.main.FlagshipConfig;
import com.abtasty.flagship.model.Flag;
import com.abtasty.flagship.visitor.Visitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class FlagshiptTestApplication {

    public static void main(String[] args) {
//        Flagship.start("cchdo9r1idc010k92r70", "fNhUYdUXKhEiUNlHSSOhKawQJanWrHNvRBOcQKtq", new FlagshipConfig.DecisionApi());
        Visitor visitor = Flagship.newVisitor("YOUR_VISITOR_ID")
                .context(new HashMap<>() {{
                    put("try", "me");
                }})
                .build();

        visitor.fetchFlags().whenComplete((instance, error) -> {
            Flag<String> wellDone =  visitor.getFlag("well_done", "");
            System.out.println(wellDone);
        });

        SpringApplication.run(FlagshiptTestApplication.class, args);
    }

}
