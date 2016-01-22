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
public class SettingsController {

    @Autowired
    private AuthUtl authUtl;
    @Autowired
    private ContactUtil contactUtil;
    @Autowired
    private UserSettingsRepo userSettingsRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getAllSettings() throws ClassNotFoundException {
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
        //delete all userSettings
        List<UserSettings> list = userSettingsRepo.findUserSettingsByUser(user.getUsername());
        for(UserSettings userSettings : list){
            userSettingsRepo.delete(userSettings.getId());
        }
        List<UserSettings> s = userSettingsRepo.findUserSettingsByUser(user.getUsername());
        UserSettings set;
        for(String setting : settings){
            set = new UserSettings(user, setting);
            userSettingsRepo.save(set);
        }
        s = userSettingsRepo.findUserSettingsByUser(user.getUsername());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserSettings", method = RequestMethod.GET)
    public List<String> getUserSettings(){
        User currentUser = authUtl.getUser();
        List<String> output = new ArrayList<String>();
        List<UserSettings> settings = userSettingsRepo.findUserSettingsByUser(currentUser.getUsername());
        for(UserSettings s : settings){
            output.add(s.getSetting());
        }
        return output;
    }

}
