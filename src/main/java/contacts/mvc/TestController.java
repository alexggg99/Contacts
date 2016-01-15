package contacts.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "view";
    }

}
