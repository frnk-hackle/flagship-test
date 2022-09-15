package io.flagship.test;

import com.abtasty.flagship.main.Flagship;
import com.abtasty.flagship.model.Flag;
import com.abtasty.flagship.model.FlagMetadata;
import com.abtasty.flagship.visitor.Visitor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class AppController
{
    @GetMapping("/")
    public String config() throws ExecutionException, InterruptedException {
        AtomicReference<String> result = new AtomicReference<>("");
        Visitor visitor = Flagship.newVisitor("YOUR_VISITOR_ID")
                .context(new HashMap<>() {{
                    put("try", "me");
                }})
                .build();

        visitor.fetchFlags().get();
        Flag<String> flag = visitor.getFlag("well_done", "");
        return flag.value(true);
    }

}
