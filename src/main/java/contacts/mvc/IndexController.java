package contacts.mvc;

import contacts.domain.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/newContact")
    public String newContact(){
        return "index";
    }

    @RequestMapping("/editContact/**")
    public String editContact(){
        return "index";
    }

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/regUser", method = RequestMethod.POST)
    public ModelAndView regUser(@RequestBody String loginRequest, HttpServletRequest request){

        String response = null;
        String username = "";
        String password = "";

        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(loginRequest.toString());
            JSONObject jsonObject = (JSONObject) obj;
            username = (String) jsonObject.get("username");
            password = (String) jsonObject.get("password");
        }catch(ParseException pe){
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }

//        User user = userRepo.findByUsername(username);
//        if(user != null){
//            return "{\"error\": true}";
//        }

        ModelAndView modelAndView = new ModelAndView("registration");
//        if(user.getUsername().length() <4 || user.getPassword().length() <4){
//            modelAndView.addObject("badCredentions", false);
//        }
//        System.out.println(user);
        return modelAndView;
    }

}
