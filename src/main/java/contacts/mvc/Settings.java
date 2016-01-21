package contacts.mvc;

import contacts.domain.Repo.UserSettingsRepo;
import contacts.domain.User;
import contacts.domain.UserSettings;
import contacts.services.AuthUtl;
import contacts.services.ContactUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexggg99 on 21.01.16.
 */

@RestController
@RequestMapping("/settings.json")
public class Settings {

    @Autowired
    private AuthUtl authUtl;
    @Autowired
    private ContactUtil contactUtil;
    @Autowired
    private UserSettingsRepo userSettingsRepo;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<String> getAllSettings() throws ClassNotFoundException {
        List<String> result = new ArrayList<String>();
        Field[] fields = contactUtil.getContactFields();
        for(Field field : fields){
            if(!field.getType().equals(User.class)){
                result.add(field.getName());
            }
        }
        System.out.println();
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> setSettings(@RequestBody List<String> settings){
        User user = authUtl.getUser();
        UserSettings setting = null;
        for(String str : settings){
            setting = new UserSettings(user, str);
            userSettingsRepo.save(setting);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
