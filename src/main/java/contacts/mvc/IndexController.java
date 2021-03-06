package contacts.mvc;

import contacts.domain.Repo.RoleRepo;
import contacts.domain.Repo.UserRepo;
import contacts.domain.Repo.UserSettingsRepo;
import contacts.domain.Role;
import contacts.domain.User;
import contacts.domain.UserSettings;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Controller
public class IndexController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserSettingsRepo userSettingsRepo;

    @RequestMapping("/*")
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

    @RequestMapping("/settings")
    public String settings(){
        return "index";
    }

    @RequestMapping(value = "/regUser", method = RequestMethod.POST)
    public @ResponseBody String regUser(@RequestBody String request){

        String response = null;
        String username = "";
        String password = "";

        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(request.toString());
            JSONObject jsonObject = (JSONObject) obj;
            username = (String) jsonObject.get("username");
            password = (String) jsonObject.get("password");
        }catch(ParseException pe){
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }

        User user = userRepo.findUserByUsername(username);
        if(user != null){
            return "{\"error\": \"exist\",\"mes\": \"user exist\"}";
        }

        Role role = roleRepo.findRoleByAuthority("USER");
        if(role == null){
            role = roleRepo.save(new Role("USER"));
        }
        user = new User(role, password, username);
        userRepo.save(user);
        //initialize default user settings
        UserSettings setting = new UserSettings(user, "fullName");
        userSettingsRepo.save(setting);
        setting = new UserSettings(user, "vk");
        userSettingsRepo.save(setting);

        return "{\"error\": \"success\"}";
    }

}
